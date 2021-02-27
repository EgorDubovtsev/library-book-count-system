package org.lib.dao;

import org.lib.dto.BookDTO;
import org.lib.dto.SearchParametersDTO;
import org.lib.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleBooksDao implements BooksDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getList() {
        String sqlGetAllBooks = "SELECT * FROM books_list join books_genres_lib on books_list.book_name = books_genres_lib.book_name";
        return jdbcTemplate.query(sqlGetAllBooks, bookMapper);
    }

    @Override
    public int addBook(BookDTO bookDTO) {
        String sqlAddBook = "INSERT INTO books_list(book_name, author) values(?, ?);";

        String sqlAddBookGenre = "INSERT INTO books_genres_lib VALUES(?, ?);";
        jdbcTemplate.update(sqlAddBook, bookDTO.getName(), bookDTO.getAuthor());
        return jdbcTemplate.update(sqlAddBookGenre, bookDTO.getName(), bookDTO.getGenre());
    }

    @Override
    public BookDTO getBookByName(String name) {
        if (name.trim().equals("")) {
            return null;
        }
        String sqlGetBookByName = "SELECT * FROM books_list join books_genres_lib on books_list.book_name = books_genres_lib.book_name where books_list.book_name = ?";
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
        String sqlGetBooksByParameters = "SELECT * FROM (" +
                "SELECT * FROM (" +
                "SELECT * FROM books_list WHERE book_name LIKE ?) AS books" +
                " JOIN books_genres_lib ON books.book_name = books_genres_lib.book_name " +
                "WHERE books_genres_lib.genre LIKE ?" +
                ") AS result_table WHERE result_table.author LIKE ?";

        return jdbcTemplate.query(sqlGetBooksByParameters, bookMapper, bookName, bookGenre, bookAuthor);
    }

    @Override
    public void saveBook(String bookName, String bookOwnerName, String returnDate) {
        String saveBookSql = "UPDATE books_list set (ownerName, return_date, is_occupied) = (?,?,?) where book_name=?";
        boolean isOccupied = !bookOwnerName.equals("");

        jdbcTemplate.update(saveBookSql,bookOwnerName,returnDate,isOccupied,bookName);
    }
}
