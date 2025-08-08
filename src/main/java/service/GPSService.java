package service;

import dataAccessLayer.GPSDAO;
import transferObjects.GPSLocation;
import observer.GPSObserver;
import observer.GPSSubject;

import java.sql.Timestamp;
import java.util.List;

/**
 * Service class for handling GPS location updates and observer notifications.
 */
public class GPSService {

    private final GPSDAO gpsDAO = new GPSDAO();
    private final GPSSubject gpsSubject = new GPSSubject();

    public void addObserver(GPSObserver observer) {
        gpsSubject.addObserver(observer);
    }

    public void removeObserver(GPSObserver observer) {
        gpsSubject.removeObserver(observer);
    }

    public GPSLocation saveLocation(int vehicleId, double latitude, double longitude) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GPSLocation location = new GPSLocation(vehicleId, latitude, longitude, timestamp);
        gpsDAO.saveLocation(location);
        gpsSubject.notifyObservers(location);
        return location;
    }

    public List<GPSLocation> getLocationsByVehicleId(int vehicleId) {
        return gpsDAO.getLocationsByVehicleId(vehicleId);
    }
}