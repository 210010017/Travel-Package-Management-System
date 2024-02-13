package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {
    private Passenger passenger;
    private Activity activity;

    @BeforeEach
    void setUp() {
        passenger = new TestPassenger("John Doe", "1", 200.0);
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", passenger.getName());
        assertEquals("1", passenger.getPassengerNumber());
        assertEquals(200.0, passenger.getBalance());
        assertTrue(passenger.getActivities().isEmpty());
    }

    @Test
    void testAddActivity() {
        passenger.addActivity(activity);
        assertEquals(1, passenger.getActivities().size());
        assertTrue(passenger.getActivities().contains(activity));
    }

    @Test
    void testAddNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> passenger.addActivity(null));
    }

    @Test
    void testEquals() {
        Passenger passenger2 = new TestPassenger("John Doe", "1", 200.0);
        assertEquals(passenger, passenger2);

        Passenger passenger3 = new TestPassenger("Jane Doe", "2", 200.0);
        assertNotEquals(passenger, passenger3);
    }

    private static class TestPassenger extends Passenger {
        public TestPassenger(String name, String passengerNumber, double balance) {
            super(name, passengerNumber, balance);
        }

        @Override
        public boolean signUpForActivity(Activity activity) {
            return false;
        }

        @Override
        public double entryFee(Activity activity) {
            return 0;
        }
    }
}