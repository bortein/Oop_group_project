// GPSObserver.java
package ErenUgur.Observer;

import model.GPSLocation;

public interface GPSObserver {
    void update(GPSLocation location);
}
