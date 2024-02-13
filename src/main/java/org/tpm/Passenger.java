package org.tpm;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Passenger {
    private String name;
    private String passengerNumber;

    protected double balance;

    private Set<Activity> activities; // keeps track of signed up activities of this passenger

    public Passenger(String name, String passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.activities = new HashSet<>();
    }

    public abstract boolean signUpForActivity(Activity activity);

    public abstract double entryFee(Activity activity);


    public void addActivity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }
        activities.add(activity);
    }

    //getters
    public String getName() {
        return name;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public double getBalance() {
        return balance;
    }


    public Set<Activity> getActivities() {
        return activities;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Passenger passenger = (Passenger) obj;
        return Objects.equals(passengerNumber, passenger.passengerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerNumber);
    }
}