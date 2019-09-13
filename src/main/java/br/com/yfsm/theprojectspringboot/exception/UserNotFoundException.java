package br.com.yfsm.theprojectspringboot.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Could not find User");
    }
}
