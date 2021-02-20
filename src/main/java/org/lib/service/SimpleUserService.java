package org.lib.service;

import org.lib.dao.AuthorizedUserDao;
import org.lib.entity.AuthorizedUser;
import org.lib.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;

@Service
public class SimpleUserService implements UserService {
    @Autowired
    private AuthorizedUserDao authorizedUserDao;

    @Override
    @Nullable
    public User getAuthorizedUserByLogin(String login) {
        return authorizedUserDao.getList().stream()
                .filter(value -> value.getLogin().equals(login))
                .findFirst().orElse(null);
    }

    @Override
    public boolean addAuthorizedUser(@Nullable AuthorizedUser user) {
        if (user != null) {
            authorizedUserDao.registrateUser(user);
            return true;
        }
        return false;
    }

}
