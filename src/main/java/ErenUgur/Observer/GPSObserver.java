// GPSObserver.java
package ErenUgur.Observer;

import ErenUgur.model.GPSLocation;

public interface GPSObserver {
    void update(GPSLocation location);
}
