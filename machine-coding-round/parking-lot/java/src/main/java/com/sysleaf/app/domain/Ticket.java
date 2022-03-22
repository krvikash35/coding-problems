package com.sysleaf.app.domain;

public class Ticket {
    String parkingLotId;
    int floorNumber;
    int slotNumber;
    String id;

    public Ticket(String parkingLotId, int floorNumber, int slotNumber) {
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.id = parkingLotId + "_" + floorNumber + "_" + slotNumber;
    }

    public String getId() {
        return id;
    }
}