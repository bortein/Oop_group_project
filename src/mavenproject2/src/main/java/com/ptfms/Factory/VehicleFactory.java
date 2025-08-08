package com.ptfms.Factory;

import com.ptfms.builder.VehicleBuilder;
import com.ptfms.model.Vehicle;

public class VehicleFactory {
    public static Vehicle create(String type, String id) {
        switch(type) {
            case "DieselBus" -> {
                return new VehicleBuilder(id)
                        .type(type)
                        .fuel("Diesel")
                        .consumption(0.5)
                        .capacity(50)
                        .build();
            }
            case "ElectricLightRail" -> {
                return new VehicleBuilder(id)
                        .type(type)
                        .fuel("Electric")
                        .consumption(2.0)
                        .capacity(200)
                        .build();
            }
            default -> throw new IllegalArgumentException("Unknown type");
        }
        // add others…
            }
}