package com.sysleaf.app.domain;

public class Ticket {
    String parkingLotId;
    int floorNumber;
    int slotNumber;

    Ticket(String parkingLotId, int floorNumber, int slotNumber) {
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
    }
}