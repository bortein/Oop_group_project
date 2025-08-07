package com.ptfms.business.observer;

import com.ptfms.model.Vehicle;
import java.util.Observable;
import java.util.Observer;

public abstract class MaintenanceAlertObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        // 1. Cast the Observable to your Vehicle type
        if (o instanceof Vehicle) {  
        } else {  
            return;
        }
        Vehicle v = (Vehicle) o;

        // 2. Ensure the payload is a String
        if (!(arg instanceof String)) {
            return;
        }
        String message = (String) arg;

        // 3. Use whichever getter actually exists on Vehicle
        //    I’ll call it getId() here—you can swap in your real method name
        System.out.printf("ALERT for Vehicle %s: %s%n",v.getId(),message);

        handleAlert(v, message);
    }

    private void handleAlert(Vehicle v, String message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}