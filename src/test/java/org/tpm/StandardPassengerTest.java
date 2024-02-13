package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardPassengerTest {
    private StandardPassenger standardPassenger;
    private Activity activity;
    private TravelPackage travelPackage; // new field
    private Destination destination; // new field

    @BeforeEach
    void setUp() {
        standardPassenger = new StandardPassenger("John Doe", "1", 200.0);
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
        destination = new Destination("Destination 1"); // initialize the new field
        travelPackage = new TravelPackage("Package 1", 2); // initialize the new field
        travelPackage.addDestination(destination);
        standardPassenger.addToOptedPackages(travelPackage);
        activity.setParentDestination(destination);
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", standardPassenger.getName());
        assertEquals("1", standardPassenger.getPassengerNumber());
        assertEquals(200.0, standardPassenger.getBalance());
        assertTrue(standardPassenger.getOptedActivities().isEmpty());
    }

    @Test
    void testSignUpForActivity() {
        assertTrue(standardPassenger.signUpForActivity(activity));
        assertEquals(1, standardPassenger.getOptedActivities().size());
        assertTrue(standardPassenger.getOptedActivities().contains(activity));
        assertEquals(100.0, standardPassenger.getBalance());
    }

    @Test
    void testSignUpForActivityNotInPackage() {
        Activity outsideActivity = new Activity("Swimming", "Swimming in the sea", 50.0, 2);
        assertThrows(IllegalArgumentException.class, () -> standardPassenger.signUpForActivity(outsideActivity));
    }

    @Test
    void testSignUpForActivityWithInsufficientBalance() {
        standardPassenger = new StandardPassenger("John Doe", "1", 50.0);
        Destination destination = new Destination("Destination 2");
        TravelPackage travelPackage = new TravelPackage("Package 2", 2);
        travelPackage.addDestination(destination);
        standardPassenger.addToOptedPackages(travelPackage);
        activity.setParentDestination(destination);
        assertFalse(standardPassenger.signUpForActivity(activity));
        assertTrue(standardPassenger.getOptedActivities().isEmpty());
        assertEquals(50.0, standardPassenger.getBalance());
    }

    @Test
    void testSignUpForNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> standardPassenger.signUpForActivity(null));
    }

    @Test
    void testEntryFee() {
        assertEquals(100.0, standardPassenger.entryFee(activity));
    }

    @Test
    void testEntryFeeForNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> standardPassenger.entryFee(null));
    }
}