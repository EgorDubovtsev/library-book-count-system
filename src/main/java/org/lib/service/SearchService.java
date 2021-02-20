package org.lib.service;


import org.lib.dto.BookDTO;
import org.lib.dto.SearchParametersDTO;

import java.util.List;

public interface SearchService {
    List<BookDTO> findBookBySearchParameters(SearchParametersDTO searchParameters);
}
