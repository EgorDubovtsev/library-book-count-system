package org.lib.dao;


import org.lib.dto.BookDTO;
import org.lib.dto.SearchParametersDTO;

import java.util.List;

public interface BooksDao {
    List<BookDTO> getList();

    int addBook(BookDTO bookDTO);

    BookDTO getBookByName(String name);

    List<BookDTO> getBooksByParameters(SearchParametersDTO searchParameters);
}
