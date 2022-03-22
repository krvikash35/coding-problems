package com.sysleaf.app.domain;

public class ParkingSlot implements Comparable<ParkingSlot> {
    VehicleType vechicleType;
    int slotNumber;
    int floorNumber;
    Vehicle vehicle;

    public ParkingSlot(VehicleType vehicleType, int slotNumber, int floorNumber) {
        this.vechicleType = vehicleType;
        this.slotNumber = slotNumber;
        this.floorNumber = floorNumber;
        this.vehicle = null;
    }

    public void Park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void UnPark() {
        this.vehicle = null;
    }

    public boolean isOccupied() {
        return this.vehicle != null;
    }

    @Override
    public int compareTo(ParkingSlot o) {
        return this.slotNumber - o.slotNumber;
    }

}
