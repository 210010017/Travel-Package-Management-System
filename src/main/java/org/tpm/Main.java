package org.tpm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some activities
        Activity activity1 = new Activity("Skiing", "Skiing in the mountains", 100.0, 10);
        Activity activity2 = new Activity("Hiking", "Hiking in the forest", 50.0, 20);

        // Create a destination and add the activities to it
        Destination destination = new Destination("Mountain Resort");
        destination.addActivity(activity1);
        destination.addActivity(activity2);

        // Create some passengers
        StandardPassenger passenger1 = new StandardPassenger("John", "1", 200.0);
        GoldPassenger passenger2 = new GoldPassenger("Jane", "2", 300.0);
        PremiumPassenger passenger3 = new PremiumPassenger("Joe", "3");

        // Create a travel package and add the destination and passengers to it
        TravelPackage travelPackage = new TravelPackage("Winter Adventure", 5);
        travelPackage.addDestination(destination);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        // Sign up the passengers for some activities
        passenger1.signUpForActivity(activity1);
        passenger2.signUpForActivity(activity2);
        passenger3.signUpForActivity(activity1);
        passenger3.signUpForActivity(activity2);


        // To avoid user interaction, comment the below lines and uncomment all the Display lines present below

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passenger1);
        passengers.add(passenger2);
        passengers.add(passenger3);
        var userInteraction = new UserInteraction(travelPackage, passengers);
        userInteraction.start();


        // Display.itinerary(travelPackage);
        // Display.passengerList(travelPackage);
        // Display.details(passenger1);
        // Display.details(passenger2);
        // Display.details(passenger3);
        // Display.spaceAvailableActivities();
    }
}