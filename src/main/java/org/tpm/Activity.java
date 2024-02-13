package org.tpm;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;

    private Set<Passenger> passengers; // tracks the passengers who all signed up for this activity
    private Destination parentDestination; // stores the destination to which this activity belongs
    private static Set<Activity> allActivities = new HashSet<>(); // stores all the instances created of Activity class

    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.passengers = new HashSet<>();
        allActivities.add(this);
    }


    public boolean addPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("passenger cannot be null");
        }
        if (passengers.size() < capacity) {
            passengers.add(passenger);
            return true;
        }
        else{
            System.out.println("Reached max passenger capacity of this activity, this passenger can't be signed up");
            return false;
        }
    }


    public void setParentDestination(Destination destination) {
        parentDestination = destination;
    }

    public int nofSpacesAvailable() {
        return (capacity-passengers.size());
    }

    // getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }


    public Destination getParentDestination() {
        return parentDestination;
    }

    public static Set<Activity> getAllActivities() {
        return allActivities;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Activity activity = (Activity) obj;
        return  Objects.equals(name, activity.name) && Double.compare(activity.cost, cost) == 0 &&
                capacity == activity.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, capacity);
    }
}