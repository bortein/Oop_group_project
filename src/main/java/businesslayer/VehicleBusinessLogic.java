package businesslayer;

import dataaccesslayer.VehicleDAO;
import dataaccesslayer.VehicleDAOImpl;
import java.util.List;
import transferobjects.VehicleDTO;

/**VehicleBusinessLogic.java
 * This class enforces the business logic for CRUD operations on the Vehicles table. It includes vehicle validation before operations to avoid errors.
 * @author Patricia Sunday
 * @version V1
 * @see businesslayer
 * @since Apache NetBeans IDE 21
 */
public class VehicleBusinessLogic {
    /**to store vehicledao implementation*/
    private final VehicleDAO dao;
    
    /**to store object for vehicle validation*/
    private final VehicleValidation validation;
   
    /**the max character length for IDNumber field*/
    private final int IDNUMBER_MAX = 45;
    
    /**initializes dao and validation*/
    public VehicleBusinessLogic(){
        this.dao = new VehicleDAOImpl();
        this.validation = new VehicleValidation();
    }
    
    /**inserts a vehicle into the Vehicles database
     * @param vehicle the vehicle to register
     * @return whether the registration succeeded
     * @throws ValidationException the exception to validate input
     */
    public boolean registerVehicle(VehicleDTO vehicle) throws ValidationException{
        validation.validateVehicle(vehicle);
        return dao.registerVehicle(vehicle);
    }
    
    /**updates a vehicle in the Vehicles database
     * @param vehicle the vehicle to update
     * @return whether the update succeeded
     * @throws ValidationException the exception to validate input
     */
    public boolean updateVehicle(VehicleDTO vehicle)throws ValidationException{
        validation.validateVehicle(vehicle);
        return dao.updateVehicle(vehicle);
    }    
     /**deletes a vehicle from the Vehicles database
     * @param vehicle the vehicle to delete
     * @return whether the deletion succeeded
     * @throws ValidationException the exception to validate input
     */
    public boolean deleteVehicle(VehicleDTO vehicle) throws ValidationException{
        validation.validateVehicle(vehicle);
        return dao.deleteVehicle(vehicle);
    }
    
    /**retrieves all vehicles in the Vehicles database
     * @return the list of vehicles
     */
    public List<VehicleDTO> getAllVehicles(){
        return dao.getAllVehicles();
    }
    
    /**retrieves a vehicle from the Vehicles database
     * @param vNum the number of the vehicle
     * @return the vehicle to retrieve
     * @throws ValidationException the exception to validate input
     */
    public VehicleDTO getVehicleByNumber(String vNum) throws ValidationException{
        validation.validateString(vNum, "IDNumber", IDNUMBER_MAX, false);
        return dao.getVehicleByNumber(vNum);
    }
}
