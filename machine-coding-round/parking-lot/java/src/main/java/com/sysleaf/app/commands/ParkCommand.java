package com.sysleaf.app.commands;

import java.security.InvalidParameterException;

import com.sysleaf.app.domain.VehicleType;
import com.sysleaf.app.handler.CommandHandler;

public class ParkCommand implements Command {

    CommandHandler commandHandler;

    public ParkCommand(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public String helpText() {
        return "park_vehicle <vehicle_type> <reg_no> <color>";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        if (params.length != 3) {
            throw new InvalidParameterException(String.format("Expected format: %s", this.helpText()));
        }

        VehicleType vehicleType = VehicleType.valueOf(params[0]);
        String regNo = params[1];
        String color = params[2];

        this.commandHandler.parkVehicle(vehicleType, regNo, color);

    }

}
