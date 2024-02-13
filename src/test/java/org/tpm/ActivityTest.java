package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {
    private Activity activity;
    private GoldPassenger goldPassenger;
    private StandardPassenger standardPassenger;
    private PremiumPassenger premiumPassenger;

    @BeforeEach
    void setUp() {
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
        goldPassenger = new GoldPassenger("John Doe", "1", 200.0);
        standardPassenger = new StandardPassenger("Jane Doe", "2", 200.0);
        premiumPassenger = new PremiumPassenger("Bob Smith", "3");
    }

    @Test
    void testConstructor() {
        assertEquals("Hiking", activity.getName());
        assertEquals("Mountain hiking", activity.getDescription());
        assertEquals(100.0, activity.getCost());
        assertEquals(2, activity.getCapacity());
    }

    @Test
    void testAddPassenger() {
        assertTrue(activity.addPassenger(goldPassenger));
        assertEquals(1, activity.nofSpacesAvailable());

        assertTrue(activity.addPassenger(standardPassenger));
        assertEquals(0, activity.nofSpacesAvailable());

        assertFalse(activity.addPassenger(premiumPassenger));
    }

    @Test
    void testAddNullPassenger() {
        assertThrows(IllegalArgumentException.class, () -> activity.addPassenger(null));
    }

    @Test
    void testNofSpacesAvailable() {
        assertEquals(2, activity.nofSpacesAvailable());
        activity.addPassenger(goldPassenger);
        assertEquals(1, activity.nofSpacesAvailable());
    }

    @Test
    void testEquals() {
        Activity activity2 = new Activity("Hiking", "Mountain hiking", 100.0, 2);
        assertEquals(activity, activity2);

        Activity activity3 = new Activity("Swimming", "Swimming in the sea", 50.0, 3);
        assertNotEquals(activity, activity3);
    }
}