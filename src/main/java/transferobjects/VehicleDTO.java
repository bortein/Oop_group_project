/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferobjects;

/**VehicleDTO.java
 * This class stores data for vehicles in the Vehicles table of the PublicFleet database
 * @author Patricia Sunday
 * @version 1.0
 * @see transferobjects
 * @since Apache NetBeans IDE 21
 */
public class VehicleDTO {
    /**the primary key/vehicle id*/
    private int id;
    
    /**the unique vehicle number*/
    private String number;
    
    /**the type of vehicle*/
    private VehicleType type;
    
    /**the type of fuel*/
    private String fuelType;
    
    /**the vehicle's fuel consumption rate*/
    private double consumptionRate;
    
    /**the maximum amount of passengers that can fit in the vehicle*/
    private int maxPassengers;
    
    /**the vehicle's current route*/
    private String route;
    
    /**Represents the type of vehicle. Its constants are diesel bus, electric light rail, and diesel electric train
     */
    public enum VehicleType{
        DIESEL_BUS,
        ELECTRIC_LIGHT_RAIL,
        DIESEL_ELECTRIC_TRAIN
    }

    /**
     * getter for the primary key/vehicle id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * setter for the primary key/vehicle id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for the unique vehicle number
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * setter for the unique vehicle number
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * getter for the type of vehicle
     * @return the type
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * setter for the type of vehicle
     * @param type the type to set
     */
    public void setType(VehicleType type) {
        this.type = type;
    }

    /**
     * getter for the type of fuel
     * @return the fuelType
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * setter for the type of fuel
     * @param fuelType the fuelType to set
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * getter for the vehicle's fuel consumption rate
     * @return the consumptionRate
     */
    public double getConsumptionRate() {
        return consumptionRate;
    }

    /**
     * setter for the vehicle's fuel consumption rate
     * @param consumptionRate the consumptionRate to set
     */
    public void setConsumptionRate(double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    /**
     * getter for the maximum amount of passengers that can fit in the vehicle
     * @return the maxPassengers
     */
    public int getMaxPassengers() {
        return maxPassengers;
    }

    /**
     * setter for the maximum amount of passengers that can fit in the vehicle
     * @param maxPassengers the maxPassengers to set
     */
    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    /**
     * getter for the vehicle's current route
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * setter for the vehicle's current route
     * @param route the route to set
     */
    public void setRoute(String route) {
        this.route = route;
    }    
    
}
