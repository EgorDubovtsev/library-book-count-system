package org.lib.service;


import org.lib.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooksList();

    void addBook(BookDTO book);

    BookDTO findByName(String name);

    void saveBook(String bookName, String bookOwner, String returnDate);
}
