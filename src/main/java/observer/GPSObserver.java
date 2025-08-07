// GPSObserver.java
package observer;

import transferObjects.GPSLocation;

public interface GPSObserver {
    void update(GPSLocation location);
}
