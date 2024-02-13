package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardPassengerTest {
    private StandardPassenger standardPassenger;
    private Activity activity;

    @BeforeEach
    void setUp() {
        standardPassenger = new StandardPassenger("John Doe", "1", 200.0);
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", standardPassenger.getName());
        assertEquals("1", standardPassenger.getPassengerNumber());
        assertEquals(200.0, standardPassenger.getBalance());
        assertTrue(standardPassenger.getActivities().isEmpty());
    }

    @Test
    void testSignUpForActivity() {
        assertTrue(standardPassenger.signUpForActivity(activity));
        assertEquals(1, standardPassenger.getActivities().size());
        assertTrue(standardPassenger.getActivities().contains(activity));
        assertEquals(100.0, standardPassenger.getBalance());
    }

    @Test
    void testSignUpForActivityWithInsufficientBalance() {
        standardPassenger = new StandardPassenger("John Doe", "1", 50.0);
        assertFalse(standardPassenger.signUpForActivity(activity));
        assertTrue(standardPassenger.getActivities().isEmpty());
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