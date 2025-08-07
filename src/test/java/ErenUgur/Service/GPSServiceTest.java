package ErenUgur.Service;

import service.GPSService;
import transferObjects.GPSLocation;
import observer.GPSObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

public class GPSServiceTest {

    private GPSService gpsService;

    @BeforeEach
    public void setUp() {
        gpsService = new GPSService();
    }

    @Test
    public void testSaveLocationReturnsCorrectData() {
        GPSLocation location = gpsService.saveLocation(123, 45.0, 90.0);

        assertEquals(123, location.getVehicleId());
        assertEquals(45.0, location.getLatitude());
        assertEquals(90.0, location.getLongitude());
        assertNotNull(location.getTimestamp());
    }

    @Test
    public void testGetLocationsByVehicleIdReturnsList() {
        List<GPSLocation> locations = gpsService.getLocationsByVehicleId(123);
        assertNotNull(locations);
        // Optionally add more assertions depending on test DB state
    }

    @Test
    public void testObserverNotifiedOnLocationSave() {
        AtomicBoolean wasNotified = new AtomicBoolean(false);

        GPSObserver testObserver = location -> wasNotified.set(true);
        gpsService.addObserver(testObserver);

        gpsService.saveLocation(321, 12.34, 56.78);

        assertTrue(wasNotified.get(), "Observer should be notified");
    }
}
