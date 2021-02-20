package org.lib.service;


import org.lib.entity.AuthorizedUser;
import org.lib.entity.User;

public interface UserService {
    User getAuthorizedUserByLogin(String login);

    boolean addAuthorizedUser(AuthorizedUser user);

}
