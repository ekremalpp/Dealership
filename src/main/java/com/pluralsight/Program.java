package com.pluralsight;

public class Program {
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        // Application is starting
        System.out.println("Welcome to the Dealership Management System!");

        // Create a user interface object
        UserInterface userInterface = new UserInterface();

        // Display the user menu
        userInterface.display();

        // Application exit message
        System.out.println("Thank you for using the Dealership Management System. Goodbye!");
    }
}

