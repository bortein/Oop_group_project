package com.ptfms.business.observer;

import com.ptfms.model.Component;

public interface ComponentSubject {
    void register(MaintenanceAlertObserver observer);
    void unregister(MaintenanceAlertObserver observer);
    void notifyObservers();

    public static class MaintenanceAlertObserver {

        public MaintenanceAlertObserver() {
        }

        public void update(Component aThis) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}