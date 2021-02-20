package org.lib.dao;


import org.lib.entity.AuthorizedUser;

import java.util.List;

public interface UserDao {
    List<AuthorizedUser> getList();

    int registrateUser(AuthorizedUser authorizedUser);
}
