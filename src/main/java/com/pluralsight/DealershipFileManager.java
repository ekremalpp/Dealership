package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    private String filePath;

    public DealershipFileManager(String filePath) {
        this.filePath = filePath;
    }

    // Method to read the dealership data from the file
    public Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read the first line for dealership info
            if (line != null) {
                String[] parts = line.split("\\|");
                String name = parts[0].trim();
                String address = parts[1].trim();
                String phone = parts[2].trim();
                dealership = new Dealership(name, address, phone);

                // Read the rest of the lines for vehicle info
                while ((line = br.readLine()) != null) {
                    String[] vehicleParts = line.split("\\|");
                    Vehicle vehicle = new Vehicle(
                            Integer.parseInt(vehicleParts[0].trim()),
                            Integer.parseInt(vehicleParts[1].trim()),
                            vehicleParts[2].trim(),
                            vehicleParts[3].trim(),
                            vehicleParts[4].trim(),
                            vehicleParts[5].trim(),
                            Integer.parseInt(vehicleParts[6].trim()),
                            Double.parseDouble(vehicleParts[7].trim())
                    );
                    dealership.addVehicle(vehicle); // Adding vehicle to the dealership
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;
    }

    // Method to save the dealership data to the file
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) { // Overwrite mode
            // Write dealership info
            writer.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());
            writer.newLine();

            // Write vehicle info
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}

