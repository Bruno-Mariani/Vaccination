package com.zup.vaccination.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User was not found");
    }
}