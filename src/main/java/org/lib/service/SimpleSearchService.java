package org.lib.service;

import org.lib.dao.BooksDao;
import org.lib.dto.BookDTO;
import org.lib.dto.SearchParametersDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SimpleSearchService implements SearchService {
    @Autowired
    private BooksDao booksDao;

    @Override
    public List<BookDTO> findBookBySearchParameters(SearchParametersDTO searchParameters) {
        return booksDao.getBooksByParameters(searchParameters);
    }
}
