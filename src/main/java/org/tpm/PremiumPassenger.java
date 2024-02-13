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
        if(activity.addPassenger(this)) {
            this.addActivity(activity);
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