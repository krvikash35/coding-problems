package com.sysleaf.app.domain;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

import com.sysleaf.app.exceptions.ParkingLotFullException;

import java.util.Set;

public class ParkingLot {
    String id;
    int numberOfSlotPerFloor;
    int numberOfFloor;
    SortedSet<ParkingSlot> availableSlot = new TreeSet<>();
    Set<ParkingSlot> occupiedSlots = new HashSet<>();

    public ParkingLot(String id, int numberOfFloor, int numberOfSlotPerFloor) {
        this.id = id;
        this.numberOfFloor = numberOfFloor;
        this.numberOfSlotPerFloor = numberOfSlotPerFloor;

        for (int i = 0; i < numberOfFloor; i++) {
            int floorNumber = i + 1;
            for (int j = 0; j < numberOfSlotPerFloor; j++) {
                int slotNumber = j + 1;
                VehicleType slotType;
                if (j == 0) {
                    slotType = VehicleType.TRUCK;
                } else if (j == 1 || j == 2) {
                    slotType = VehicleType.BIKE;
                } else {
                    slotType = VehicleType.CAR;
                }
                ParkingSlot slot = new ParkingSlot(slotType, slotNumber, floorNumber);
                this.availableSlot.add(slot);
            }
        }

    }

    public Ticket park(Vehicle vehicle) {
        if (this.isFull(vehicle.getType())) {
            throw new ParkingLotFullException();
        }

        ParkingSlot slot = this.getAvailableSlot(vehicle.getType());
        slot.Park(vehicle);
        this.availableSlot.remove(slot);
        this.occupiedSlots.add(slot);
        return new Ticket(this.id, slot.floorNumber, slot.slotNumber);
    }

    public void unPark(String ticketId) {

    }

    public ParkingSlot getAvailableSlot(VehicleType vechicleType) {
        return this.availableSlot.stream().filter(s -> s.vechicleType == vechicleType).findFirst()
                .get();

    }

    public boolean isFull(VehicleType vehicleType) {
        try {
            this.getAvailableSlot(vehicleType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}