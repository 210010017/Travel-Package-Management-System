package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumPassengerTest {
    private PremiumPassenger premiumPassenger;
    private Activity activity;
    private TravelPackage travelPackage; // new field
    private Destination destination; // new field

    @BeforeEach
    void setUp() {
        premiumPassenger = new PremiumPassenger("John Doe", "1");
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
        destination = new Destination("Destination 1"); // initialize the new field
        travelPackage = new TravelPackage("Package 1", 2); // initialize the new field
        travelPackage.addDestination(destination);
        premiumPassenger.addToOptedPackages(travelPackage);
        activity.setParentDestination(destination);
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", premiumPassenger.getName());
        assertEquals("1", premiumPassenger.getPassengerNumber());
        assertEquals(-1, premiumPassenger.getBalance());
        assertTrue(premiumPassenger.getOptedActivities().isEmpty());
    }

    @Test
    void testSignUpForActivity() {
        assertTrue(premiumPassenger.signUpForActivity(activity));
        assertEquals(1, premiumPassenger.getOptedActivities().size());
        assertTrue(premiumPassenger.getOptedActivities().contains(activity));
    }

    @Test
    void testSignUpForActivityNotInPackage() {
        Activity outsideActivity = new Activity("Swimming", "Swimming in the sea", 50.0, 2);
        assertThrows(IllegalArgumentException.class, () -> premiumPassenger.signUpForActivity(outsideActivity));
    }

    @Test
    void testSignUpForActivityWithFullCapacity() {
        Activity fullActivity = new Activity("Swimming", "Swimming in the sea", 50.0, 0);
        Destination destination = new Destination("Destination 2");
        TravelPackage travelPackage = new TravelPackage("Package 2", 2);
        travelPackage.addDestination(destination);
        premiumPassenger.addToOptedPackages(travelPackage);
        fullActivity.setParentDestination(destination);
        assertFalse(premiumPassenger.signUpForActivity(fullActivity));
        assertTrue(premiumPassenger.getOptedActivities().isEmpty());
    }

    @Test
    void testSignUpForNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> premiumPassenger.signUpForActivity(null));
    }

    @Test
    void testEntryFee() {
        assertEquals(0, premiumPassenger.entryFee(activity));
    }

    @Test
    void testEntryFeeForNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> premiumPassenger.entryFee(null));
    }
}