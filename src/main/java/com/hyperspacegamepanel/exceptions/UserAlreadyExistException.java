package com.hyperspacegamepanel.exceptions;

public class UserAlreadyExistException extends RuntimeException {

    String email;

    public UserAlreadyExistException(String email) {
        super(String.format("User with email address or username '%s' already exist", email));
        this.email = email;
    }

    
}
