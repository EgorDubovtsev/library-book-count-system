package org.lib.mappers;


import org.lib.dto.BookDTO;
import org.lib.dto.CreatedBookDTO;

public interface IBookMapper {
    BookDTO mapFromCreatedBook(CreatedBookDTO createdBookDTO);
}
