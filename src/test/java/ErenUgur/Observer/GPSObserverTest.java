package ErenUgur.Observer;

import observer.GPSObserver;
import transferObjects.GPSLocation;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class GPSObserverTest {

    // Simple test implementation of GPSObserver
    static class TestObserver implements GPSObserver {
        boolean updated = false;
        GPSLocation receivedLocation = null;

        @Override
        public void update(GPSLocation location) {
            updated = true;
            receivedLocation = location;
        }
    }

    @Test
    void testObserverUpdateCalled() {
        TestObserver observer = new TestObserver();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        GPSLocation location = new GPSLocation(1, 12.34, 56.78, now);

        // Call update
        observer.update(location);

        // Verify update was called and data passed correctly
        assertTrue(observer.updated, "Observer should be marked updated");
        assertEquals(location, observer.receivedLocation, "Observer should receive correct location");
    }
}
