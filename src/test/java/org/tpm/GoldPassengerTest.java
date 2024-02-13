package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoldPassengerTest {
    private GoldPassenger goldPassenger;
    private Activity activity;

    @BeforeEach
    void setUp() {
        goldPassenger = new GoldPassenger("John Doe", "1", 200.0);
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", goldPassenger.getName());
        assertEquals("1", goldPassenger.getPassengerNumber());
        assertEquals(200.0, goldPassenger.getBalance());
        assertTrue(goldPassenger.getOptedActivities().isEmpty());
    }

    @Test
    void testSignUpForActivity() {
        TravelPackage travelPackage = new TravelPackage("Package 1",2);
        Destination destination = new Destination("Destination 1");
        activity.setParentDestination(destination);
        travelPackage.addDestination(destination);
        goldPassenger.addToOptedPackages(travelPackage);

        assertTrue(goldPassenger.signUpForActivity(activity));
        assertEquals(1, goldPassenger.getOptedActivities().size());
        assertTrue(goldPassenger.getOptedActivities().contains(activity));
        assertEquals(110.0, goldPassenger.getBalance());
    }

    @Test
    void testSignUpForActivityWithInsufficientBalance() {
        goldPassenger = new GoldPassenger("John Doe", "1", 50.0);
        TravelPackage travelPackage = new TravelPackage("Package 1",2);
        Destination destination = new Destination("Destination 1");
        activity.setParentDestination(destination);
        travelPackage.addDestination(destination);
        goldPassenger.addToOptedPackages(travelPackage);

        assertFalse(goldPassenger.signUpForActivity(activity));
        assertTrue(goldPassenger.getOptedActivities().isEmpty());
        assertEquals(50.0, goldPassenger.getBalance());
    }

    @Test
    void testSignUpForNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> goldPassenger.signUpForActivity(null));
    }

    @Test
    void testEntryFee() {
        assertEquals(90.0, goldPassenger.entryFee(activity));
    }

    @Test
    void testEntryFeeForNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> goldPassenger.entryFee(null));
    }
}