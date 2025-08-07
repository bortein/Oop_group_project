package ErenUgur.Test;

import ErenUgur.Observer.*;
import ErenUgur.Service.GPSService;
import ErenUgur.model.GPSLocation;

import java.sql.Timestamp;

/**
 * Test class to simulate GPS updates and observer notifications.
 */
public class ObserverTest {
    public static void main(String[] args) {
        GPSService gpsService = new GPSService();

        // Register observer
        GPSObserver dashboardObserver = new DashboardObserver();
        gpsService.addObserver(dashboardObserver);

        // Simulate GPS updates
        gpsService.saveLocation(101, 45.4215, -75.6990);
        gpsService.saveLocation(202, 45.4240, -75.6950);
    }
}