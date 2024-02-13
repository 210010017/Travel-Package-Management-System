package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumPassengerTest {
    private PremiumPassenger premiumPassenger;
    private Activity activity;

    @BeforeEach
    void setUp() {
        premiumPassenger = new PremiumPassenger("John Doe", "1");
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", premiumPassenger.getName());
        assertEquals("1", premiumPassenger.getPassengerNumber());
        assertEquals(-1, premiumPassenger.getBalance());
        assertTrue(premiumPassenger.getActivities().isEmpty());
    }

    @Test
    void testSignUpForActivity() {
        assertTrue(premiumPassenger.signUpForActivity(activity));
        assertEquals(1, premiumPassenger.getActivities().size());
        assertTrue(premiumPassenger.getActivities().contains(activity));
    }

    @Test
    void testSignUpForActivityWithFullCapacity() {
        Activity fullActivity = new Activity("Swimming", "Swimming in the sea", 50.0, 0);
        assertFalse(premiumPassenger.signUpForActivity(fullActivity));
        assertTrue(premiumPassenger.getActivities().isEmpty());
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