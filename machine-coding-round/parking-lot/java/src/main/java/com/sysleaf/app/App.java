package com.sysleaf.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.sysleaf.app.client.Client;
import com.sysleaf.app.client.ClientFactory;
import com.sysleaf.app.commands.CommandFactory;
import com.sysleaf.app.handler.CommandHandler;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        CommandHandler commandHandler = new CommandHandler();
        CommandFactory commandFactory = CommandFactory.init(commandHandler);
        try {
            Client client = ClientFactory.buildClient(args, commandFactory);
            client.handleInput();
        } catch (FileNotFoundException e) {
            System.out.println("given file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
