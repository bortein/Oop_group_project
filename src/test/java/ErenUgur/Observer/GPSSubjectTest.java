package ErenUgur.Observer;

import ErenUgur.model.GPSLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class GPSSubjectTest {

    private GPSSubject subject;

    // Test observer that records if update was called
    static class TestObserver implements GPSObserver {
        boolean updated = false;
        GPSLocation receivedLocation = null;

        @Override
        public void update(GPSLocation location) {
            updated = true;
            receivedLocation = location;
        }
    }

    @BeforeEach
    void setUp() {
        subject = new GPSSubject();
    }

    @Test
    void testAddObserver() {
        TestObserver observer = new TestObserver();
        subject.addObserver(observer);
        // There is no direct getter to check list, so we test via notifyObservers:
        GPSLocation location = new GPSLocation(1, 0.0, 0.0, new Timestamp(System.currentTimeMillis()));
        subject.notifyObservers(location);

        assertTrue(observer.updated, "Observer should be notified after adding");
    }

    @Test
    void testRemoveObserver() {
        TestObserver observer = new TestObserver();
        subject.addObserver(observer);
        subject.removeObserver(observer);

        GPSLocation location = new GPSLocation(1, 0.0, 0.0, new Timestamp(System.currentTimeMillis()));
        subject.notifyObservers(location);

        assertFalse(observer.updated, "Observer should NOT be notified after removal");
    }

    @Test
    void testNotifyObserversMultiple() {
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        GPSLocation location = new GPSLocation(1, 10.0, 20.0, new Timestamp(System.currentTimeMillis()));
        subject.notifyObservers(location);

        assertTrue(observer1.updated, "First observer should be notified");
        assertTrue(observer2.updated, "Second observer should be notified");
        assertEquals(location, observer1.receivedLocation, "Observer1 should get correct location");
        assertEquals(location, observer2.receivedLocation, "Observer2 should get correct location");
    }
}
