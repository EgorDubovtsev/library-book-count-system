package org.lib.dao;

import org.lib.entity.AuthorizedUser;
import org.lib.mappers.AuthorizedUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AuthorizedUserDao implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AuthorizedUserMapper authorizedUserMapper;


    public AuthorizedUserDao(JdbcTemplate jdbcTemplate, AuthorizedUserMapper authorizedUserMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorizedUserMapper = authorizedUserMapper;
    }

    @Override
    public List<AuthorizedUser> getList() {
        String sql = "SELECT * FROM users full join authorized_data on users.login = authorized_data.login";
        return jdbcTemplate.query(sql, authorizedUserMapper);
    }

    @Override
    public int registrateUser(AuthorizedUser authorizedUser) {
        String sqlInsertIntoUsers = "INSERT INTO USERS (user_name,login) VALUES (?, ?)";
        String sqlInsertIntoAuthorizedData = "INSERT INTO authorized_data values('"
                + authorizedUser.getLogin() + "','" + authorizedUser.getPassword() + "');";
        jdbcTemplate.update(sqlInsertIntoUsers, authorizedUser.getName(),
                authorizedUser.getLogin());

        return jdbcTemplate.update(sqlInsertIntoAuthorizedData);
    }

}
