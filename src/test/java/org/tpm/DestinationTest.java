package org.tpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DestinationTest {
    private Destination destination;
    private Activity activity;

    @BeforeEach
    void setUp() {
        destination = new Destination("Mountain");
        activity = new Activity("Hiking", "Mountain hiking", 100.0, 2);
    }

    @Test
    void testConstructor() {
        assertEquals("Mountain", destination.getName());
        assertTrue(destination.getActivities().isEmpty());
    }

    @Test
    void testAddActivity() {
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity));
        assertEquals(destination, activity.getParentDestination());
    }

    @Test
    void testAddNullActivity() {
        assertThrows(IllegalArgumentException.class, () -> destination.addActivity(null));
    }

    @Test
    void testAddDuplicateActivity() {
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());

        Activity activity2 = new Activity("Hiking", "Mountain hiking", 100.0, 2);
        destination.addActivity(activity2);
        assertEquals(1, destination.getActivities().size());
    }

    @Test
    void testEquals() {
        Destination destination2 = new Destination("Mountain");
        assertEquals(destination, destination2);

        Destination destination3 = new Destination("Beach");
        assertNotEquals(destination, destination3);
    }
}