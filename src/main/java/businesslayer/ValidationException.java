/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

/**ValidationException.java
 * This class extends the Exception class to build an exception for invalid data input
 * @author Patricia Sunday
 * @version V1
 * @see businesslayer
 * @since Apache NetBeans IDE 21
 */
public class ValidationException extends Exception{
     /**Throws validation exception with default message*/
    public ValidationException(){
        super("The data input is invalid");
    }
    
    /**Throws validation exception with custom message
     @param message the message to use*/
    public ValidationException(String message){
        super(message);
    }
}
