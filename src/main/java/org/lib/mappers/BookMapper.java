package org.lib.mappers;


import org.lib.dto.BookDTO;
import org.lib.dto.CreatedBookDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<BookDTO>, IBookMapper {

    @Override
    public BookDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        BookDTO book = new BookDTO();
        book.setName(resultSet.getString("book_name"));
        book.setPublishYear(resultSet.getInt("publishYear"));
        book.setDescription(resultSet.getString("description"));
        book.setAuthor(resultSet.getString("author"));
        book.setGenre(resultSet.getString("genre"));
        book.setPrice(resultSet.getInt("price"));
        return book;
    }

    @Override
    public BookDTO mapFromCreatedBook(CreatedBookDTO createdBookDTO) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor(createdBookDTO.getAuthor());
        bookDTO.setDescription(createdBookDTO.getDescription());
        bookDTO.setName(createdBookDTO.getName());
        bookDTO.setPrice(createdBookDTO.getPrice());
        bookDTO.setPublishYear(createdBookDTO.getPublishYear());
        bookDTO.setGenre(createdBookDTO.getGenre());
        return bookDTO;
    }
}
