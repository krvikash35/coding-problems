package com.sysleaf.app.commands;

import java.security.InvalidParameterException;

public interface Command {
    String helpText();

    void execute(String[] params) throws InvalidParameterException;

}
