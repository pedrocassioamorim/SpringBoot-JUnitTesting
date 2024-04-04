package org.bootcampspringboot.junitandmockito.services.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
