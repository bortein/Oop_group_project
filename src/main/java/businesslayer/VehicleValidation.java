/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import transferobjects.VehicleDTO;

/**VehicleValidation.java
 * This class validates input related to VehicleDTO objects based on the Vehicles table column constraints
 * @author Patricia Sunday
 * @version V1
 * @see businesslayer
 * @since Apache NetBeans IDE 21
 */
public class VehicleValidation {
    /**the max character length for IDNumber field*/
    private final int IDNUMBER_MAX = 45;
    
    /**the max character length for FuelType*/
    private final int FUELTYPE_MAX = 45;

    /**the max character length for Password field*/
    private final int ROUTE_MAX = 65;
    
    /**the end number in the range for consumption rate field*/
    private final double CONSUMPTIONRATE_MAX_RANGE = 99.99;
    
    /**the max amount of digits before the decimal for consumption rate field*/
    private final int CONSUMPTIONRATE_MAX_INTEGER = 2;
    
    /**the max amount of digits after the decimal for consumption rate field*/
    private final int CONSUMPTIONRATE_MAX_DECIMAL = 2;
    
    /**validates text/string input
     * @param value the string value to validate
     * @param field the field name for the value
     * @param maxLength the max character length for the field
     * @param nullable whether the value can be null
     * @throws ValidationException the exception to validate input
     */
    public void validateString(String value, String field, int maxLength, boolean nullable) throws ValidationException{
         //if value is null but field is non-nullable
        if(value == null && !nullable){
            throw new ValidationException("The " + field + " cannot be null");
        }
        
        if(value.isBlank() || value.isEmpty()){
            throw new ValidationException("The " + field + " cannot be empty or only have whitespaces");
        }
        
        if(value.length() > maxLength){
            throw new ValidationException(String.format("The " + "%s cannot exceed %d characters", field, maxLength));
        }        
    }
    
    /**validates numeric-decimal input
     * @param value the decimal value to validate
     * @param field the field name for the value
     * @param maxRange the maximum range for the DECIMAl type
     * @param maxIntDigits the maximum digits before the decimal
     * @param maxDecimalDigits the maximum digits after the decimal
     * @throws ValidationException the custom exception to validate input
     */
    public void validateDouble(double value, String field, double maxRange, int maxIntDigits, int maxDecimalDigits) throws ValidationException{
        //if value is invalid negative
        if(value < 0){
            throw new ValidationException(field + " cannot be less than zero");
        }
        
        String[] decimalParts = String.valueOf(value).split("\\.");
        //if the value exceeds the decimal digit constraints
        if(decimalParts[0].length() > maxIntDigits || decimalParts[1].length() > maxDecimalDigits){
            throw new ValidationException(field + " cannot have more than " + maxIntDigits + " before the decimal point and " + maxDecimalDigits + " after the decimal");
        }
            
        //if value exceeds defined decimal size constraints
        if(value > maxRange){
            throw new ValidationException(field + " cannot be more than " + maxRange);
        }
    }
    
    /**validates numeric-integer input
     * @param value the integer value to validate
     * @param field the field name for the value
     * @throws ValidationException the custom exception to validate input
     */
    public void validateInt(int value, String field) throws ValidationException{
        //if value is invalid negative
        if(value < 0){
            throw new ValidationException(field + " cannot be less than zero");
        }
    }
    
    /**validates a VehicleDTO object
     * @param vehicle the vehicle to validate
     * @throws ValidationException the exception to validate input
     */
    public void validateVehicle(VehicleDTO vehicle) throws ValidationException{
        //validate idnumber
        validateString(vehicle.getNumber(), "IDNumber", IDNUMBER_MAX, false);
        
        //validate fueltype
        validateString(vehicle.getFuelType(), "Fuel Type", FUELTYPE_MAX, false);
        
        //validate consumptionrate
        validateDouble(vehicle.getConsumptionRate(), "Consumption Rate", CONSUMPTIONRATE_MAX_RANGE, CONSUMPTIONRATE_MAX_INTEGER, CONSUMPTIONRATE_MAX_DECIMAL);
    
        //validate maxpassengers
        validateInt(vehicle.getMaxPassengers(), "Max Passengers");
        
        //validate route
        validateString(vehicle.getRoute(), "Route", ROUTE_MAX, false);
    }
}
