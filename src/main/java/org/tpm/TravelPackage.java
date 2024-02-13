package org.tpm;

import java.util.HashSet;
import java.util.Set;

public class TravelPackage {
    private String name;
    private int capacity;
    private Set<Destination> destinations;
    private Set<Passenger> passengers;

    public TravelPackage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.destinations = new HashSet<>();
        this.passengers = new HashSet<>();
    }

    public void addDestination(Destination destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination cannot be null");
        }
        destinations.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger cannot be null");
        }
        if (passengers.size() < capacity) {
            passengers.add(passenger);
            return true;
        }
        else{
            System.out.println("Reached max passenger capacity of travel pack, this passenger can't be added");
            return false;
        }
    }

    // getters
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<Destination> getDestinations() {
        return destinations;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }
}       