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
        assertTrue(goldPassenger.getActivities().isEmpty());
    }

    @Test
    void testSignUpForActivity() {
        assertTrue(goldPassenger.signUpForActivity(activity));
        assertEquals(1, goldPassenger.getActivities().size());
        assertTrue(goldPassenger.getActivities().contains(activity));
        assertEquals(110.0, goldPassenger.getBalance());
    }

    @Test
    void testSignUpForActivityWithInsufficientBalance() {
        goldPassenger = new GoldPassenger("John Doe", "1", 50.0);
        assertFalse(goldPassenger.signUpForActivity(activity));
        assertTrue(goldPassenger.getActivities().isEmpty());
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