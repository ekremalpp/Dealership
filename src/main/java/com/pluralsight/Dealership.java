package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    //dealer information
    private String name;
    private String address;
    private String phone;
    private List<Vehicle>inventory;

    //Constructor


    public Dealership(String name, String address, String phone, List<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }
    // Add a new vehicle inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    // Remove a vehicle from inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
    //Search methods
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return null;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        return null;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

}
