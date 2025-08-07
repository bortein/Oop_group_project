/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.UserDAO;
import dataaccesslayer.UserDAOImpl;
import transferobjects.UserDTO;

/**UserBusinessLogic.java
 * This class enforces the business logic for operations on the Users table. It includes user validation before operations to avoid errors.
 * @author Patricia Sunday
 * @version V1
 * @see businesslayer
 * @since Apache NetBeans IDE 21
 */
public class UserBusinessLogic {
    /**to store userdao implementation*/
    private final UserDAO dao;
    
    /**to store object for user validation*/
    private final UserValidation validation;
    
    /**the max character length for Email field*/
    private final int EMAIL_MAX = 254;

    /**the max character length for Password field*/
    private final int PASSWORD_MAX = 65;
   
    /**initializes dao and validation*/
    public UserBusinessLogic(){
        this.dao = new UserDAOImpl();
        this.validation = new UserValidation();
    }
    
    /**inserts a user into the Users database
     * @param user the user to register
     * @return whether the registration succeeded
     * @throws ValidationException the exception to validate input
     */
    public boolean registerUser(UserDTO user) throws ValidationException{
        validation.validateUser(user);
        return dao.registerUser(user);
    }
    
    /**validates a user's login by input email & password
     * @param email the input email
     * @param pass the input password
     * @return the user found from successful validation, or null if unsuccessful
     * @throws ValidationException the exception to validate input
     */
    public UserDTO validateLogin(String email, String pass) throws ValidationException{
        //validate email address
        validation.validateString(email, "Email", EMAIL_MAX, false);
        
        //validate password
        validation.validateString(pass, "Password", PASSWORD_MAX, false);
        
        return dao.validateLogin(email, pass);
    }
}
