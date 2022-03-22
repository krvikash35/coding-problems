package com.sysleaf.app.domain;

public class Vehicle {
    private String registrationNumber;
    private String color;
    private VehicleType type;

    public Vehicle(String registrationNumber, String color, VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
    }

    public VehicleType getType() {
        return this.type;
    }
}
