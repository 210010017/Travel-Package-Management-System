package org.tpm;

public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, String passengerNumber) {
        super(name, passengerNumber, -1);
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

        if(activity.addPassenger(this)) {
            this.addToOptedActivities(activity);
            return true;
        }
        return false;
    }

    @Override
    public double entryFee(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }
        return 0;
    }
}