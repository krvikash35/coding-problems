package com.sysleaf.app.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.sysleaf.app.commands.CommandFactory;

public class ClientFactory {
    public static Client buildClient(String[] args, CommandFactory commandFactory) throws FileNotFoundException {
        if (args.length == 0) {
            return new Client(new BufferedReader(new InputStreamReader(System.in)), commandFactory);
        } else {
            return new Client(new BufferedReader(new FileReader(args[0])), commandFactory);
        }
    }
}
