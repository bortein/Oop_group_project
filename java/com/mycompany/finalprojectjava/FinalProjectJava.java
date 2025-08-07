package com.mycompany.finalprojectjava;

import com.ptfms.model.Component;
import com.ptfms.model.Vehicle;

public class FinalProjectJava {
    public static void main(String[] args) {
        // Create components
        Component engine = new Component(1, "Engine", 5000);
        Component tire   = new Component(2, "Tire",   2000);
        Component brake  = new Component(3, "Brake",  3000);

        // Build the vehicle
        Vehicle car = new VehicleBuilder()
            .setId(1001)
            .setMake("Bus")
            .setModel("Bus")
            .addComponent(engine)
            .addComponent(tire)
            .addComponent(brake)
            .build();

        // Print it out
        System.out.println(car);
    }
}