package com.sysleaf.app.domain;

public class ParkingSlot {
    VehicleType vechicleType;
    int id;
    int floorNumber;
    Vehicle vehicle;

    public ParkingSlot(VehicleType vehicleType, int id, int floorNumber) {
        this.vechicleType = vehicleType;
        this.id = id;
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

}
