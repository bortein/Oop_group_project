/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import transferobjects.UserDTO;

/**UserDAOImpl.java
 * This class implements the UserDAO interface to define some CRUD operations for the Users table of the publicfleet database
 * @author Patricia Sunday
 * @version 1.0
 * @see dataaccesslayer
 * @since Apache NetBeans IDE 21
 */
public class UserDAOImpl implements UserDAO {
    /**inserts a user into the Users database
     * @param user the user to register
     * @return whether the registration succeeded
     */
    @Override
    public boolean registerUser(UserDTO user){
        String query = "INSERT INTO Users(FullName, Email, Password, UserType) VALUES(?, ?, ?, ?)";
        
        //using preparedstatement to create insert query
        try(Connection conn = DataSource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(query)){
            
            //set prepared statement parameters
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, (user.getType()).toString());
            
            //execute insert & return true for successful insert if the corresponding row count is above 0
            if(ps.executeUpdate() > 0){
                return true;
            }
        }
        catch(SQLException e){e.printStackTrace();}
        
        return false;
    }
    
    /**to retrieve a user by their email
     * @param email the email for the user to retrieve
     * @return the user to retrieve
     */
    @Override
    public UserDTO getUserByEmail(String email){
        String query = "SELECT * FROM Users WHERE Email = ?";
        UserDTO foundUser = new UserDTO();
        
        try(Connection conn = DataSource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(query);){
            ps.setString(1, email);
            
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    //create user object using found user from query
                    foundUser.setId(rs.getInt("ID"));
                    foundUser.setName(rs.getString("FullName"));
                    foundUser.setPassword(rs.getString("Password"));
                    foundUser.setType(UserDTO.UserType.valueOf(rs.getString("UserType"))); //get enum value from db to use corresponding enum of userdto 
                }
            }
        }
        catch(SQLException e){e.printStackTrace();}
        
        return null;
    }
    
    /**validates a user's login by input email & password
     * @param email the input email
     * @param pass the input password
     * @return the user found from successful validation, or null if unsuccessful
     */
    @Override
    public UserDTO validateLogin(String email, String pass){
        String query = "SELECT * FROM Users WHERE Email = ? AND Password = ?";
        
        try(Connection conn = DataSource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(query);){
            
            ps.setString(1, email);
            ps.setString(2, pass);
            
            try(ResultSet rs = ps.executeQuery();){
                //if a user with matching credentials was found, store it as an object
                if(rs.next()){
                   UserDTO foundUser = new UserDTO();
                    
                    //create user object using found user from query
                    foundUser.setId(rs.getInt("ID"));
                    foundUser.setName(rs.getString("FullName"));
                    foundUser.setPassword(rs.getString("Password"));
                    foundUser.setType(UserDTO.UserType.valueOf(rs.getString("UserType"))); //get enum value from db to use corresponding enum of userdto 
                    
                    return foundUser;
                }
            }
        }
        catch(SQLException e){e.printStackTrace();}
         
        return null;
    }
}
