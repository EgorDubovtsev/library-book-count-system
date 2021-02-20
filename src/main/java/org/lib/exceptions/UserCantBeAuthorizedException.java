package org.lib.exceptions;

public class UserCantBeAuthorizedException extends Exception {
    public UserCantBeAuthorizedException() {
    }

    public UserCantBeAuthorizedException(String s) {
        super(s);
    }
}
