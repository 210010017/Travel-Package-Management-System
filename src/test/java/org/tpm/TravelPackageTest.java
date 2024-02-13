package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelPackageTest {
    private TravelPackage travelPackage;
    private Destination destination;
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        travelPackage = new TravelPackage("Adventure", 2);
        destination = new Destination("Mountain");
        passenger = new TestPassenger("John Doe", "1", 200.0);
    }

    @Test
    void testConstructor() {
        assertEquals("Adventure", travelPackage.getName());
        assertEquals(2, travelPackage.getCapacity());
        assertTrue(travelPackage.getDestinations().isEmpty());
        assertTrue(travelPackage.getPassengers().isEmpty());
    }

    @Test
    void testAddDestination() {
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getDestinations().size());
        assertTrue(travelPackage.getDestinations().contains(destination));
    }

    @Test
    void testAddNullDestination() {
        assertThrows(IllegalArgumentException.class, () -> travelPackage.addDestination(null));
    }

    @Test
    void testAddPassenger() {
        assertTrue(travelPackage.addPassenger(passenger));
        assertEquals(1, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger));
    }

    @Test
    void testAddPassengerWithFullCapacity() {
        travelPackage.addPassenger(passenger);
        Passenger passenger2 = new TestPassenger("Jane Doe", "2", 200.0);
        travelPackage.addPassenger(passenger2);
        Passenger passenger3 = new TestPassenger("Bob Doe", "3", 200.0);
        assertFalse(travelPackage.addPassenger(passenger3));
        assertEquals(2, travelPackage.getPassengers().size());
    }

    @Test
    void testAddNullPassenger() {
        assertThrows(IllegalArgumentException.class, () -> travelPackage.addPassenger(null));
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