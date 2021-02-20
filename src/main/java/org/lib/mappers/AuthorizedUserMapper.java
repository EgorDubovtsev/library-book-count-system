package org.lib.mappers;


import org.lib.dto.RegistredUserDTO;
import org.lib.entity.AuthorizedUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizedUserMapper implements RowMapper<AuthorizedUser>, UserMapper {

    @Override
    public AuthorizedUser mapRow(ResultSet resultSet, int i) throws SQLException {
        AuthorizedUser authorizedUser = new AuthorizedUser();
        authorizedUser.setName(resultSet.getString("user_name"));
        authorizedUser.setLogin(resultSet.getString("login"));
        authorizedUser.setPassword(resultSet.getString("password"));
        return authorizedUser;
    }

    @Override
    public AuthorizedUser mapFromDto(RegistredUserDTO registredUserDTO) {
        AuthorizedUser authorizedUser = new AuthorizedUser();
        authorizedUser.setName(registredUserDTO.getName());
        authorizedUser.setPassword(registredUserDTO.getPassword());
        authorizedUser.setLogin(registredUserDTO.getLogin());
        return authorizedUser;
    }
}
