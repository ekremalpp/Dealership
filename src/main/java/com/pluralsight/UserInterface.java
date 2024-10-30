package com.pluralsight;
import java.util.List;
import java.util.Scanner;
public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        init();
    }

    // Initializes the dealership object from the file
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager("dealership.csv"); //
        this.dealership = fileManager.getDealership();
    }

    // Displays the menu and processes user commands
    public void display() {
        while (true) {
            System.out.println("\n Dealership Menu ");
            System.out.println("1. Find vehicles by price range");
            System.out.println("2. Find vehicles by make/model");
            System.out.println("3. Find vehicles by year range");
            System.out.println("4. Find vehicles by color");
            System.out.println("5. Find vehicles by mileage range");
            System.out.println("6. Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7. List all vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("99. Quit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "99":
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.printf("VIN: %d, Year: %d, Make: %s, Model: %s, Type: %s, Color: %s, Odometer: %d, Price: %.2f\n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            }
        }
    }

    // Method to filter by price
    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);

    }
    // Method to filter by make/model
    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);

    }
    // Method to filter by year
    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int minYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum year: ");
        int maxYear = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);

    }
    // Method to filter by color
    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);

    }
    // Method to filter by year
    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int minMileage = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum mileage: ");
        int maxMileage = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicles);

    }
    // Method to filter by type
    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);

    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Vehicle Type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Odometer Reading: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully.");


    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }

    }
