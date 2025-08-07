// GPSLocation.java
package model;

import java.time.LocalDateTime;

public class GPSLocation {
    private int vehicleId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;

    public GPSLocation(int vehicleId, double latitude, double longitude, LocalDateTime timestamp) {
        this.vehicleId = vehicleId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public int getVehicleId() { return vehicleId; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public LocalDateTime getTimestamp() { return timestamp; }
}