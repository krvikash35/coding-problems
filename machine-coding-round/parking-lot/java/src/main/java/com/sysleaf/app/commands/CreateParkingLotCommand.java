package com.sysleaf.app.commands;

import java.security.InvalidParameterException;

import com.sysleaf.app.handler.CommandHandler;

public class CreateParkingLotCommand implements Command {
    CommandHandler commandHandler;

    public CreateParkingLotCommand(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public String helpText() {
        return "create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        if (params.length != 3) {
            throw new InvalidParameterException(String.format("Expected format: %s", this.helpText()));
        }

        try {
            String parkingLotId = params[0];
            int numOfFloor = Integer.parseInt(params[1]);
            int numOfSlotPerFloor = Integer.parseInt(params[2]);
            this.commandHandler.createParkingLot(parkingLotId, numOfFloor, numOfSlotPerFloor);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("<no_of_floors> and <no_of_slots_per_floor> must be integer");
        }

    }

}
