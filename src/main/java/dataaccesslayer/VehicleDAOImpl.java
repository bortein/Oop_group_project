/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.VehicleDTO;

/**VehicleDAOImpl.java
 * This class implements the vehicleDAO interface to define CRUD operations for the Vehicle table of the publicfleet database
 * @author Patricia Sunday
 * @version 1.0
 * @see dataaccesslayer
 * @since Apache NetBeans IDE 21
 */
public class VehicleDAOImpl implements VehicleDAO {
    /**inserts a vehicle into the Vehicles database
     * @param vehicle the vehicle to register
     * @return whether the registration succeeded
     */
    @Override
    public boolean registerVehicle(VehicleDTO vehicle){
        String query = "INSERT INTO Vehicles(IDNumber, VehicleType, FuelType, ConsumptionRate, MaxPassengers, Route) VALUES(?, ?, ?, ?, ?, ?);";
        
        try(
            Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
        ){
            //set statement parameters
            ps.setString(1, vehicle.getNumber());
            ps.setString(2, vehicle.getType().toString());
            ps.setString(3, vehicle.getFuelType());
            ps.setDouble(4, vehicle.getConsumptionRate());
            ps.setInt(5, vehicle.getMaxPassengers());
            ps.setString(6, vehicle.getRoute());
            
            //execute insert & return true for successful insert if the corresponding row count is above 0
            if(ps.executeUpdate() > 0){
                return true;
            }
        }
        catch(SQLException e){e.printStackTrace();}
        
        return false;
    }
    
    /**updates a vehicle in the Vehicles database
     * @param vehicle the vehicle to update
     * @return whether the update succeeded
     */
    @Override
    public boolean updateVehicle(VehicleDTO vehicle){
        String query = "UPDATE Vehicles SET IDNumber = ?, VehicleType = ?, FuelType = ?, ConsumptionRate = ?, MaxPassengers = ?, Route = ? WHERE ID = ?";
        
        try(
            Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
        ){
            //set statement parameters
            ps.setString(1, vehicle.getNumber());
            ps.setString(2, vehicle.getType().toString());
            ps.setString(3, vehicle.getFuelType());
            ps.setDouble(4, vehicle.getConsumptionRate());
            ps.setInt(5, vehicle.getMaxPassengers());
            ps.setString(6, vehicle.getRoute());
            ps.setInt(7, vehicle.getId());
            
            //execute update & return true for successful update if the corresponding row count is above 0
            if(ps.executeUpdate() > 0){
                return true;
            }
        }
        catch(SQLException e){e.printStackTrace();}
        
        return false;
    }
    
    /**deletes a vehicle from the Vehicles database
     * @param vehicle the vehicle to delete
     * @return whether the deletion succeeded
     */
    @Override
    public boolean deleteVehicle(VehicleDTO vehicle){
        String query = "DELETE FROM Vehicles WHERE ID = ?";
        
        try(
            Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
        ){
            //set statement parameter
            ps.setInt(1, vehicle.getId());
            
            //execute delete & return true for successful delete if the corresponding row count is above 0
            if(ps.executeUpdate() > 0){
                return true;
            }
        }
        catch(SQLException e){e.printStackTrace();}
        
        return false;
    }
    
    /**retrieves all vehicles in the Vehicles database
     * @return the list of vehicles
     */
    @Override
    public List<VehicleDTO> getAllVehicles(){
        String query = "SELECT * FROM Vehicles";
        
        try(Connection conn = DataSource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();){
            
            List<VehicleDTO> vehicles = new ArrayList<VehicleDTO>();
            
//looping through result set to add vehicles to the arraylist
            while(rs.next()){
                //build a vehicle object and add it to list
                VehicleDTO vehicle = new VehicleDTO();
                vehicle.setId(rs.getInt("ID"));
                vehicle.setNumber(rs.getString("IDNumber"));
                vehicle.setType(VehicleDTO.VehicleType.valueOf(rs.getString("VehicleType")));
                vehicle.setFuelType(rs.getString("FuelType"));
                vehicle.setConsumptionRate(rs.getDouble("ConsumptionRate"));
                vehicle.setMaxPassengers(rs.getInt("MaxPassengers"));
                vehicle.setRoute(rs.getString("Route"));
                vehicles.add(vehicle);
            }
            
            return vehicles;
        }
        catch(SQLException e){e.printStackTrace();}
        
        return null;
    }
    
    /**retrieves a vehicle from the Vehicles database
     * @param vNum the number of the vehicle
     * @return the vehicle to retrieve
     */
    @Override
    public VehicleDTO getVehicleByNumber(String vNum){
        String query = "SELECT * FROM Vehicles WHERE IDNumber = ?";
        
        try(Connection conn = DataSource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(query);){
           
            ps.setString(1, vNum);
            
            try(ResultSet rs = ps.executeQuery();){
                //if a user with matching email was found
                if(rs.next()){
                    VehicleDTO foundVehicle = new VehicleDTO();
                    
                    //create user object using found user from query
                    foundVehicle.setId(rs.getInt("ID"));
                    foundVehicle.setNumber(rs.getString("IDNumber"));
                    foundVehicle.setType(VehicleDTO.VehicleType.valueOf(rs.getString("VehicleType"))); //get enum value from db to use corresponding enum of vehicledto 
                    foundVehicle.setFuelType(rs.getString("FuelType"));
                    foundVehicle.setConsumptionRate(rs.getDouble("ConsumptionRate"));
                    foundVehicle.setMaxPassengers(rs.getInt("MaxPassengers"));
                    foundVehicle.setRoute(rs.getString("Route"));
                    
                    return foundVehicle;
                }
            }
        }
        catch(SQLException e){e.printStackTrace();}
        
        return null;
    }
}
