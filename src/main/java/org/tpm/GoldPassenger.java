package org.tpm;

public class GoldPassenger extends Passenger {
    public GoldPassenger(String name, String passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    @Override
    public boolean signUpForActivity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }

        boolean withinPack = false;
        for(var pack : this.optedPackages){
            if (pack.getDestinations().contains(activity.getParentDestination())) {
                withinPack = true;
                break;
            } 
        }
        if (!withinPack) {
            throw new IllegalArgumentException("Activity must belong to opted travel package");
        }

        if (balance >= entryFee(activity) && activity.addPassenger(this)) {
            this.addToOptedActivities(activity);
            balance -= entryFee(activity);
            return true;
        }
        return false;
    }

    @Override
    public double entryFee(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }
        double discountedCost = activity.getCost() * 0.9;
        return discountedCost;
    } 
}