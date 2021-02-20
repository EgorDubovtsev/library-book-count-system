package org.lib.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.lib.dao.AuthorizedUserDao;
import org.lib.dao.BooksDao;
import org.lib.dao.SimpleBooksDao;
import org.lib.mappers.AuthorizedUserMapper;
import org.lib.mappers.BookMapper;
import org.lib.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class WebConfig {

    @Bean
    public AuthorizedUserMapper authorizedUserMapper() {
        return new AuthorizedUserMapper();
    }

    @Autowired
    @Bean
    public AuthorizedUserDao authorizedUserDao(JdbcTemplate jdbcTemplate, AuthorizedUserMapper authorizedUserMapper) {
        return new AuthorizedUserDao(jdbcTemplate, authorizedUserMapper);
    }


    @Bean
    public BookMapper bookMapper() {
        return new BookMapper();
    }

    public BooksDao booksDao() {
        return new SimpleBooksDao();
    }

    @Bean
    public FieldChecker fieldChecker() {
        return new FieldCheckerService();
    }

    @Bean
    public SearchService searchService() {
        return new SimpleSearchService();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
