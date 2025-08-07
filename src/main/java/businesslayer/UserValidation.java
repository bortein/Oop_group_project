/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import transferobjects.UserDTO;

/**UserValidation.java
 * This class validates input for UserDTO objects based on the Users table column constraints
 * @author Patricia Sunday
 * @version V1
 * @see businesslayer
 * @since Apache NetBeans IDE 21
 */
public class UserValidation {
    /**the max character length for FullName field*/
    private final int FULLNAME_MAX = 250;
    
    /**the max character length for Email field*/
    private final int EMAIL_MAX = 254;

    /**the max character length for Password field*/
    private final int PASSWORD_MAX = 65;
    
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
    
    /**validates a UserDTO object
     * @param user the user to validate
     * @throws ValidationException the exception to validate input
     */
    public void validateUser(UserDTO user) throws ValidationException{
        //validate full name
        validateString(user.getName(), "Full Name", FULLNAME_MAX, false);
        
        //validate email address
        validateString(user.getEmail(), "Email", EMAIL_MAX, false);
        
        //validate password
        validateString(user.getPassword(), "Password", PASSWORD_MAX, false);
    }
}
