package com.sysleaf.app.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Arrays;

import com.sysleaf.app.commands.CommandFactory;
import com.sysleaf.app.exceptions.CommandNotFoundException;

public class Client {
    private BufferedReader inputReader;
    private CommandFactory commandFactory;

    public Client(BufferedReader inputReader, CommandFactory commandFactory) {
        this.inputReader = inputReader;
        this.commandFactory = commandFactory;
    }

    public void handleInput() throws IOException {
        try {
            while (true) {
                String inputLine = this.inputReader.readLine();

                if (inputLine == null || inputLine.equalsIgnoreCase("exit")) {
                    break;
                }

                inputLine = inputLine.trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                this.processLine(inputLine);

            }
        } finally {
            inputReader.close();
        }

    }

    private void processLine(String inputLine) {
        String[] inputChunks = inputLine.split(" ");
        String command = inputChunks[0];
        String[] params = Arrays.copyOfRange(inputChunks, 1, inputChunks.length);
        try {

            commandFactory.executeCommand(command, params);
        } catch (CommandNotFoundException | InvalidParameterException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
