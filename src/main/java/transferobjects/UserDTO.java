/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferobjects;

/**UserDTO.java
 * This class stores data for users in the Users table of the PublicFleet database
 * @author Patricia Sunday
 * @version 1.0
 * @see transferobjects
 * @since Apache NetBeans IDE 21
 */
public class UserDTO {
    /**the primary key/user id*/
    private int id;
    
    /**the user's full name*/
    private String name;
    
    /**the user email credential*/
    private String email;
    
    /**the user password credential*/
    private String password;
    
    /**the type of user (either operator or manager)*/
    private UserType type;
    
    /**Represents the type of user. Its constants are operator and manager as those are the only acceptable user types.
     * Used for role-based access control functionality
     */
    public enum UserType{
       OPERATOR,
       MANAGER 
    }

    /**getter for id
     * @return the user's id
     */
    public int getId() {
        return id;
    }

    /**setter for id
     * @param id the user's id to set
     */  
    public void setId(int id) {
        this.id = id;
    }

    /**getter for email
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**setter for email
     * @param email the user's email to set
     */    
    public void setEmail(String email) {
        this.email = email;
    }

    /**getter for password
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**setter for password
     * @param pass the user's password to set
     */    
    public void setPassword(String pass) {
        this.password = pass;
    }

    /**getter for type
     * @return the user's type 
     */    
    public UserType getType() {
        return type;
    }

    /**setter for type
     * @param type the user's type to set
     */    
    public void setType(UserType type) {
        this.type = type;
    }

    /**
     * the user's full name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * the user's full name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
