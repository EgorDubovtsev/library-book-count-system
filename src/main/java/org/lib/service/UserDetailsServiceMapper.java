package org.lib.service;

import org.lib.entity.AuthorizedUser;
import org.lib.exceptions.UserCantBeAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserDetailsServiceMapper implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private FieldChecker fieldChecker;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        AuthorizedUser authorizedUserDto = (AuthorizedUser) userService.getAuthorizedUserByLogin(login);
        try {
            if (fieldChecker.isNull(authorizedUserDto)) {
                throw new UserCantBeAuthorizedException("Load user By Username was failed");
            }
        } catch (UserCantBeAuthorizedException ex) {
            ex.printStackTrace();
        }
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(("USER")));

        return new User(
                authorizedUserDto.getLogin(),
                authorizedUserDto.getPassword(),
                roles
        );
    }

}
