package transferObjects;

import java.sql.Timestamp;

/**
 * Model class representing a GPS location log entry.
 */
public class GPSLocation {
    private int logId;
    private int vehicleId;
    private double latitude;
    private double longitude;
    private Timestamp timestamp;

    // Constructor for retrieving from DB
    public GPSLocation(int logId, int vehicleId, double latitude, double longitude, Timestamp timestamp) {
        this.logId = logId;
        this.vehicleId = vehicleId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    // Constructor for saving new entry (logId not yet known)
    public GPSLocation(int vehicleId, double latitude, double longitude, Timestamp timestamp) {
        this.vehicleId = vehicleId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public int getLogId() { return logId; }
    public int getVehicleId() { return vehicleId; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public Timestamp getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("GPSLocation{logId=%d, vehicleId=%d, lat=%.5f, lon=%.5f, timestamp=%s}",
                logId, vehicleId, latitude, longitude, timestamp.toString());
    }
}