// GPSService.java
package ErenUgur.Service;

import dataAccessLayer.DBConnection;
import model.GPSLocation;
import ErenUgur.Observer.GPSSubject;
import ErenUgur.DAO.GPSDAO;
import java.time.LocalDateTime;

public class GPSService {
    private GPSDAO gpsDAO = new GPSDAO();
    private GPSSubject gpsSubject = new GPSSubject();

    public void addObserver(ErenUgur.Observer.GPSObserver observer) {
        gpsSubject.addObserver(observer);
    }

    public void updateLocation(int vehicleId, double lat, double lon) {
        GPSLocation location = new GPSLocation(vehicleId, lat, lon, LocalDateTime.now());
        gpsDAO.saveLocation(location);
        gpsSubject.notifyObservers(location);
    }
}
