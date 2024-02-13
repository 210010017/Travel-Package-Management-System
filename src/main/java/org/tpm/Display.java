package org.tpm;

public class Display {
    public static void itinerary(TravelPackage travelPackage) {
        System.out.println("Travel Pack: " + travelPackage.getName());
        for(var destination : travelPackage.getDestinations()) {
            System.out.println("|- Destination: " + destination.getName());
            for(var activity : destination.getActivities()) {
                System.out.println("  |- Activity: " + activity.getName());
                System.out.println("    |- cost: " + activity.getCost());
                System.out.println("    |- capacity: " + activity.getCapacity());
                System.out.println("    |- description: " + activity.getDescription());
            }
        }
    } 


    public static void passengerList(TravelPackage travelPackage) {
        System.out.println("Travel Pack: " + travelPackage.getName());
        System.out.println("Travel pack's passenger capacity: " + travelPackage.getCapacity());
        System.out.println("no. of passengers enrolled: " + travelPackage.getPassengers().size());
        System.out.println("list of enrolled passengers with their numbers: ");
        for(var passenger : travelPackage.getPassengers()) {
            System.out.println(" " + passenger.getName() + " - " + passenger.getPassengerNumber());
        }
    }


    public static void details(Passenger passenger) {
        System.out.println("Passenger name: " + passenger.getName());
        System.out.println("Passenger number: " + passenger.getPassengerNumber());
        if(passenger.getBalance()!=-1){
            System.out.println("Balance: " + passenger.getBalance());
        }
        System.out.println("signed up activity -- at destination -- price paid :");
        for(var activity : passenger.getOptedActivities()) {
            System.out.println("    " + activity.getName() + " -- " + activity.getParentDestination().getName() + " -- " + passenger.entryFee(activity) + "    ");
        }
    }


    public static void spaceAvailableActivities() {
        System.out.println("activity -- no. of spaces available :" );
        for(var activity : Activity.getAllActivities()) {
            if(activity.nofSpacesAvailable() > 0){
                System.out.println("  " + activity.getName() + " -- " + activity.nofSpacesAvailable() + "    ");
            }
        }
    }
}
