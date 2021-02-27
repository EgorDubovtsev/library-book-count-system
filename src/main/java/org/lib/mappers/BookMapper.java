package org.lib.mappers;


import org.lib.dto.BookDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookMapper implements RowMapper<BookDTO> {

    @Override
    public BookDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BookDTO book = new BookDTO();
        book.setName(resultSet.getString("book_name"));
        book.setOccupied(resultSet.getBoolean("is_occupied"));
        String returnDate = resultSet.getString("return_date");
        if (returnDate!=null && !returnDate.trim().equals("")) {
            book.setReturnDate(LocalDate.parse(returnDate,dateTimeFormatter));
        }
        book.setAuthor(resultSet.getString("author"));
        book.setOwnerName(resultSet.getString("ownerName"));
        book.setGenre(resultSet.getString("genre"));
        return book;
    }

}
