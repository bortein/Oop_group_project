package com.ptfms.factory;

import com.ptfms.model.Vehicle;
import com.ptfms.builder.VehicleBuilder;

public class VehicleFactory {

    /**
     * Create a Vehicle of the given type and id.Supported types:
   - DieselBus
   - ElectricLightRail
   - DieselLightRail
   - DieselElectricTrain
     * @param type
     * @param id
     * @return 
     */
    public static Vehicle create(String type, String id) {
        return switch (type) {
            case "DieselBus" -> new VehicleBuilder(id)
                    .type(type)
                    .fuel("Diesel")
                    .consumption(0.5)
                    .capacity(50)
                    .build();

            case "ElectricLightRail" -> new VehicleBuilder(id)
                    .type(type)
                    .fuel("Electric")
                    .consumption(2.0)
                    .capacity(200)
                    .build();

            case "DieselElectricTrain" -> new VehicleBuilder(id)
                    .type(type)
                    .fuel("Diesel-Electric")
                    .consumption(3.5)   // adjust value as needed
                    .capacity(400)     // adjust seating capacity
                    .build();

            default -> throw new IllegalArgumentException(
                    "Unknown vehicle type: " + type
            );
        };
    }
}