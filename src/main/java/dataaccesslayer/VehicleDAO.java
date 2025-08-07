/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import transferobjects.VehicleDTO;

/**VehicleDAO.java
 * This interface declares CRUD methods for records in the Vehicles table of the PublicFleet db
 * @author Patricia Sunday
 * @version 1.0
 * @see dataaccesslayer
 * @since Apache NetBeans IDE 21
 */
public interface VehicleDAO {
   /**inserts a vehicle into the Vehicles database
     * @param vehicle the vehicle to register
     * @return whether the registration succeeded
     */
    public boolean registerVehicle(VehicleDTO vehicle);
    
    /**updates a vehicle in the Vehicles database
     * @param vehicle the vehicle to update
     * @return whether the update succeeded
     */
    public boolean updateVehicle(VehicleDTO vehicle);
    
     /**deletes a vehicle from the Vehicles database
     * @param vehicle the vehicle to delete
     * @return whether the deletion succeeded
     */
    public boolean deleteVehicle(VehicleDTO vehicle);
    
    /**retrieves all vehicles in the Vehicles database
     * @return the list of vehicles
     */
    public List<VehicleDTO> getAllVehicles();
    
    /**retrieves a vehicle from the Vehicles database
     * @param vNum the number of the vehicle
     * @return the vehicle to retrieve
     */
    public VehicleDTO getVehicleByNumber(String vNum);
}
