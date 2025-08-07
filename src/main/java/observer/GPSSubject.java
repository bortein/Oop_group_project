// GPSSubject.java
package observer;

import observer.GPSObserver;
import transferObjects.GPSLocation;
import java.util.ArrayList;
import java.util.List;

public class GPSSubject {
    private List<GPSObserver> observers = new ArrayList<>();

    public void addObserver(GPSObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GPSObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(GPSLocation location) {
        for (GPSObserver observer : observers) {
            observer.update(location);
        }
    }
}
