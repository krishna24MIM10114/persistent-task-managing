package com.vit.car_rental;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();

        // Sample cars (later we will load from CSV file)
        cars.add(new Car(1, "Honda City", "Sedan", 2020, 1500, true));
        cars.add(new Car(2, "Mahindra Thar", "SUV", 2023, 2500, true));
        cars.add(new Car(3, "Maruti Swift", "Hatchback", 2019, 1000, true));

        while (true) {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. View Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Enter option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Cars:");
                    for (Car c : cars) {
                        System.out.println(c);
                    }
                    break;

                case 2:
                    System.out.print("Enter Car ID to Rent: ");
                    int rentId = sc.nextInt();
                    for (Car c : cars) {
                        if (c.getId() == rentId) {
                            if (c.isAvailable()) {
                                c.setAvailable(false);
                                System.out.println("Car Rented Successfully!");
                            } else {
                                System.out.println("Car is already rented!");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Car ID to Return: ");
                    int returnId = sc.nextInt();
                    for (Car c : cars) {
                        if (c.getId() == returnId) {
                            if (!c.isAvailable()) {
                                c.setAvailable(true);
                                System.out.println("Car Returned Successfully!");
                            } else {
                                System.out.println("Car was not rented.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
}
    