package org.tpm;

import java.util.List;
import java.util.Scanner;

public class UserInteraction {
    private Scanner scanner = new Scanner(System.in);
    private TravelPackage travelPackage;
    private List<Passenger> passengers;

    public UserInteraction(TravelPackage travelPackage, List<Passenger> passengers) {
        this.travelPackage = travelPackage;
        this.passengers = passengers;
    }

    public void start() {
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Print itinerary");
            System.out.println("2. Print Passenger list");
            System.out.println("3. Print passenger details");
            System.out.println("4. Print activities with available spaces");
            System.out.println("5. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    Display.itinerary(travelPackage);
                    break;
                case "2":
                    Display.passengerList(travelPackage);
                    break;
                case "3":
                    while(true) {
                        System.out.println("Please select a passenger:");
                        for (int i = 0; i < passengers.size(); i++) {
                            System.out.println((i + 1) + ". " + passengers.get(i).getName());
                        }
                    
                        int passengerIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consume the newline character
                    
                        if (passengerIndex >= 0 && passengerIndex < passengers.size()) {
                            Display.details(passengers.get(passengerIndex));
                            break;
                        }
                        else {
                            System.out.println("Invalid passenger number, please try again.");
                        }
                    }
                    break;
                case "4":
                    Display.spaceAvailableActivities();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, Please try again.");
                    break;
            }
            System.out.println();
        }
    }
}