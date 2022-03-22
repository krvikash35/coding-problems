package com.sysleaf.app.commands;

import java.util.HashMap;
import java.util.Map;

import com.sysleaf.app.exceptions.CommandNotFoundException;
import com.sysleaf.app.handler.CommandHandler;

public class CommandFactory {
    Map<String, Command> commands;

    private CommandFactory() {
        this.commands = new HashMap<>();
    }

    public static CommandFactory init(CommandHandler commandHandler) {
        CommandFactory cf = new CommandFactory();
        cf.commands.put("create_parking_lot", new CreateParkingLotCommand(commandHandler));
        cf.commands.put("park_vehicle", new ParkCommand(commandHandler));
        return cf;
    }

    public void executeCommand(String name, String[] args) {
        if (this.commands.containsKey(name)) {
            this.commands.get(name).execute(args);
        } else {
            throw new CommandNotFoundException(name);
        }
    }

}
