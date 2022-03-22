package com.sysleaf.app.handler;

import com.sysleaf.app.domain.ParkingLot;
import com.sysleaf.app.domain.Vehicle;
import com.sysleaf.app.domain.VehicleType;
import com.sysleaf.app.exceptions.ParkingLotFullException;

public class CommandHandler {
    ParkingLot parkingLot;

    public void createParkingLot(String parkingLotId, int numberOfFloor, int numberOfSlotPerFloor) {

        this.parkingLot = new ParkingLot(parkingLotId, numberOfFloor, numberOfSlotPerFloor);
    }

    public void parkVehicle(VehicleType vehicleType, String regNo, String color) {
        Vehicle vehicle = new Vehicle(regNo, color, vehicleType);
        try {
            this.parkingLot.park(vehicle);
            System.out.println(String.format("park_vehicle %s %s %s", vehicleType, regNo, color));

        } catch (ParkingLotFullException e) {
            System.out.println(e.getMessage());
        }
    }

    public void unparkVehicle() {

    }

    public void displayFreeSlotCount() {

    }

    public void displayFreeSlots() {

    }

    public void displayOccupiedSlots() {

    }

}
