package org.tpm;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Destination {
    private String name;
    private Set<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new HashSet<>();
    }

    public void addActivity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }
        boolean isAdded = activities.add(activity);
        if (isAdded) {
            activity.setParentDestination(this);
        }
    }

    // getters
    public String getName() {
        return name;
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
        Destination destination = (Destination) obj;
        return Objects.equals(name, destination.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}