package com.sysleaf.app.exceptions;

public class CommandNotFoundException extends RuntimeException {
    private String name;

    public CommandNotFoundException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "Command " + this.name + " not found";
    }

}
