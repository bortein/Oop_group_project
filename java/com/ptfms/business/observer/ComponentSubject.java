package com.ptfms.business.observer;

public interface ComponentSubject {
    void register(MaintenanceAlertObserver observer);
    void unregister(MaintenanceAlertObserver observer);
    void notifyObservers();
}