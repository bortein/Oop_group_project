// DashboardObserver.java
package ErenUgur.Observer;

import model.GPSLocation;

public class DashboardObserver implements GPSObserver {
    @Override
    public void update(GPSLocation location) {
        System.out.println("Dashboard updated: Vehicle " + location.getVehicleId() +
                " at [" + location.getLatitude() + ", " + location.getLongitude() + "]");
    }
}
