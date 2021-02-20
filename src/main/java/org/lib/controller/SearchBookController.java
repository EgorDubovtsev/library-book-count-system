package org.lib.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lib.dto.SearchParametersDTO;
import org.lib.dto.SimpleSearchParameters;
import org.lib.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchBookController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/api/search")
    public @ResponseBody
    String getBookByParameters(@RequestParam String name,
                               @RequestParam String author,
                               @RequestParam String genre,
                               @RequestParam String maxPrice) {
        SearchParametersDTO searchParameters = new SimpleSearchParameters();
        searchParameters.setName(name);
        searchParameters.setAuthor(author);
        searchParameters.setGenre(genre);
        searchParameters.setMaxPrice(maxPrice);

        searchService.findBookBySearchParameters(searchParameters);
        try {
            return objectMapper.writeValueAsString(searchService.findBookBySearchParameters(searchParameters));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
