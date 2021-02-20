package org.lib.dao;

import org.lib.dto.BookDTO;
import org.lib.dto.SearchParametersDTO;
import org.lib.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SimpleBooksDao implements BooksDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getList() {
        String sqlGetAllBooks = "SELECT * FROM books join books_genres on books.book_name = books_genres.book_name";
        return jdbcTemplate.query(sqlGetAllBooks, bookMapper);
    }

    @Override
    public int addBook(BookDTO bookDTO) {
        String sqlAddBook = "INSERT INTO books values(?, ?, ?, ?, ?);";

        String sqlAddBookGenre = "INSERT INTO books_genres VALUES(?, ?);";
        jdbcTemplate.update(sqlAddBook, bookDTO.getName(),
                bookDTO.getPublishYear(), bookDTO.getDescription(),
                bookDTO.getPrice(), bookDTO.getAuthor());
        return jdbcTemplate.update(sqlAddBookGenre, bookDTO.getName(), bookDTO.getGenre());
    }

    @Override
    public BookDTO getBookByName(String name) {
        if (name.trim().equals("")) {
            return null;
        }
        String sqlGetBookByName = "SELECT * FROM books join books_genres on books.book_name = books_genres.book_name where books.book_name = ?";
        try {
            return jdbcTemplate.queryForObject(sqlGetBookByName, bookMapper, name);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BookDTO> getBooksByParameters(SearchParametersDTO searchParameters) {
        String bookName = searchParameters.getName().equals("") ? "%" : searchParameters.getName();
        String bookAuthor = searchParameters.getAuthor().equals("") ? "%" : searchParameters.getAuthor();
        String bookGenre = searchParameters.getGenre().equals("") ? "%" : searchParameters.getGenre();
        String bookMaxPrice = searchParameters.getMaxPrice();
        String sqlGetBooksByParameters = "SELECT * FROM (" +
                "SELECT * FROM (" +
                "SELECT * FROM books WHERE book_name LIKE ?) AS books" +
                " JOIN books_genres ON books.book_name = books_genres.book_name " +
                "WHERE books_genres.genre LIKE ?" +
                ") AS result_table WHERE result_table.author LIKE ?";
        if (!bookMaxPrice.equals("")) {
            return jdbcTemplate.query(sqlGetBooksByParameters, bookMapper, bookName, bookGenre, bookAuthor).stream()
                    .filter(bookDTO -> bookDTO.getPrice() < Integer.parseInt(bookMaxPrice))
                    .collect(Collectors.toList());
        }
        return jdbcTemplate.query(sqlGetBooksByParameters, bookMapper, bookName, bookGenre, bookAuthor);
    }
}
