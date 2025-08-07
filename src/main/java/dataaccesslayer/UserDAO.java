/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataaccesslayer;

import transferobjects.UserDTO;

/**UserDAO.java
 * This interface declares some CRUD methods for records in the Users table of the PublicFleet db
 * @author Patricia Sunday
 * @version 1.0
 * @see dataaccesslayer
 * @since Apache NetBeans IDE 21
 */
public interface UserDAO {
    /**inserts a user into the Users database
     * @param user the user to register
     * @return whether the registration succeeded
     */
    public boolean registerUser(UserDTO user);
    
    /**to retrieve a user by their email
     * @param email the email for the user to retrieve
     * @return the user to retrieve
     */
    public UserDTO getUserByEmail(String email);

    /**validates a user's login by input email & password
     * @param email the input email
     * @param pass the input password
     * @return the user found from successful validation, or null if unsuccessful
     */
    public UserDTO validateLogin(String email, String pass);
}
