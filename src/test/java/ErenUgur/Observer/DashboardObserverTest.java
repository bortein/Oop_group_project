package ErenUgur.Observer;

import observer.DashboardObserver;
import transferObjects.GPSLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DashboardObserverTest {

    private DashboardObserver dashboardObserver;

    @BeforeEach
    void setUp() {
        dashboardObserver = new DashboardObserver();
    }

    @Test
    void testUpdate() {
        // Create a valid GPSLocation object (adjust constructor args to your actual model)
        GPSLocation location = new GPSLocation(
            1,       // logId
            101,     // vehicleId
            45.4215, // latitude
            -75.6999,// longitude
            new java.sql.Timestamp(System.currentTimeMillis())
        );

        // Call update with a valid location (not null)
        dashboardObserver.update(location);

        // If update method does not return anything,
        // you might want to check some side effect or at least assert no exceptions

        assertTrue(true, "Update method completed without exceptions");
    }
}
