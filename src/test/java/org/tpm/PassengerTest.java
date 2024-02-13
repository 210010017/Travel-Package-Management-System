package org.tpm;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {
    private Passenger passenger;
    private Activity activity;
    private TravelPackage travelPackage; // new field

    @BeforeEach
    void setUp() {
        passenger = new TestPassenger("John Doe", "1", 200.0);
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
        travelPackage = new TravelPackage("Package 1", 2); // initialize the new field
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", passenger.getName());
        assertEquals("1", passenger.getPassengerNumber());
        assertEquals(200.0, passenger.getBalance());
        assertTrue(passenger.getOptedActivities().isEmpty());
    }

    @Test
    void testAddToOptedActivities() {
        passenger.addToOptedActivities(activity);
        assertEquals(1, passenger.getOptedActivities().size());
        assertTrue(passenger.getOptedActivities().contains(activity));
    }

    @Test
    void testAddNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> passenger.addToOptedActivities(null));
    }

    @Test
    void testAddToOptedPackages() { // new test
        passenger.addToOptedPackages(travelPackage);
        assertEquals(1, ((TestPassenger) passenger).getOptedPackages().size());
        assertTrue(((TestPassenger) passenger).getOptedPackages().contains(travelPackage));
    }

    @Test
    void testAddNullPackage() { // new test
        assertThrows(IllegalArgumentException.class, () -> passenger.addToOptedPackages(null));
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

        public Set<TravelPackage> getOptedPackages() {
            return this.optedPackages;
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