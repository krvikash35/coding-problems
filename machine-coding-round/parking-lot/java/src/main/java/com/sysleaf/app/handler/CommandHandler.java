package com.sysleaf.app.handler;

import com.sysleaf.app.domain.ParkingLot;
import com.sysleaf.app.domain.Ticket;
import com.sysleaf.app.domain.Vehicle;
import com.sysleaf.app.domain.VehicleType;
import com.sysleaf.app.exceptions.ParkingLotFullException;

public class CommandHandler {
    ParkingLot parkingLot;

    public void createParkingLot(String parkingLotId, int numberOfFloor, int numberOfSlotPerFloor) {

        this.parkingLot = new ParkingLot(parkingLotId, numberOfFloor, numberOfSlotPerFloor);
        System.out.println(String.format("Created parking lot with %d floors and %d slots per floor", numberOfFloor,
                numberOfSlotPerFloor));
    }

    public void parkVehicle(VehicleType vehicleType, String regNo, String color) {
        Vehicle vehicle = new Vehicle(regNo, color, vehicleType);
        try {
            Ticket ticket = this.parkingLot.park(vehicle);
            System.out.println(String.format("Parked vehicle. Ticket ID: %s", ticket.getId()));

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
