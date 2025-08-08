package com.ptfms.builder;
import com.ptfms.model.Vehicle;

public class VehicleBuilder {
    private final Vehicle vehicle;
    public VehicleBuilder(String id) {
        vehicle = new Vehicle(id);
    }
    public VehicleBuilder type(String type) { vehicle.setType(type); return this; }
    public VehicleBuilder fuel(String fuel) { vehicle.setFuelType(fuel); return this; }
    public VehicleBuilder consumption(double rate) { vehicle.setConsumptionRate(rate); return this; }
    public VehicleBuilder capacity(int max) { vehicle.setMaxPassengers(max); return this; }
    public VehicleBuilder route(String route) { vehicle.setCurrentRoute(route); return this; }
    public Vehicle build() { return vehicle; }
}
