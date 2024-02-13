package org.tpm;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Passenger {
    private String name;
    private String passengerNumber;

    protected double balance;

    private Set<Activity> optedActivities; // keeps track of signed up activities of this passenger
    protected Set<TravelPackage> optedPackages; // keeps track of opted travel packages of this passenger

    public Passenger(String name, String passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.optedActivities = new HashSet<>();
        this.optedPackages = new HashSet<>();
    }

    public abstract boolean signUpForActivity(Activity activity);

    public abstract double entryFee(Activity activity);


    public void addToOptedActivities(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }
        optedActivities.add(activity);
    }

    public void addToOptedPackages(TravelPackage pack) {
        if (pack == null) {
            throw new IllegalArgumentException("opted pack cannot be null");
        }
        optedPackages.add(pack);
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


    public Set<Activity> getOptedActivities() {
        return optedActivities;
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
        return Objects.equals(getPassengerNumber(), passenger.getPassengerNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassengerNumber());
    }
}