package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    @Test
    public void addVehicle_VehicleNotInInventory_VehicleAddedSuccessfully() {
        // Arrange
        Dealership dealership = new Dealership("My Dealership", "123 Main St", "555-1234");
        Vehicle vehicle = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Red", 15000, 25000.0);

        // Act
        dealership.addVehicle(vehicle);

        // Assert
        assertEquals(1, dealership.getAllVehicles().size());
        assertEquals(vehicle, dealership.getAllVehicles().get(0));
    }

    @Test
    public void removeVehicle_VehicleInInventory_VehicleRemovedSuccessfully() {
        // Arrange
        Dealership dealership = new Dealership("My Dealership", "123 Main St", "555-1234");
        Vehicle vehicle = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Red", 15000, 25000.0);
        dealership.addVehicle(vehicle);

        // Act
        dealership.removeVehicle(vehicle);

        // Assert
        assertEquals(0, dealership.getAllVehicles().size());
    }
}