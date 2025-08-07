/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**DataSource.java
 * This class creates a connection to the database. It also creates a singleton for this class which the connection to publicfleets
 * can be accessed through
 * @author Patricia Sunday
 * @version 1.0
 * @see transferobjects
 * @since Apache NetBeans IDE 21
 */
public class DataSource {
    /**the database username*/
    private String username;
    
    /**the database password*/
    private String password;
    
    /**the database url*/
    private String url;
    
    /**the singleton for DataSource*/
    private static DataSource instance;
    
    /**to initialize data source instance variables using the load properties method*/
    private DataSource(){
        loadPropDetails();
        
        //to load driver before getting connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**to load database properties based on properties file
     */
    private void loadPropDetails(){
        Properties props = new Properties();
        try(InputStream in = getClass().getClassLoader().getResourceAsStream("database.properties");){
            props.load(in);

            //storing db url & credentials in instance variables
            this.url = props.getProperty("jdbc.url");
            this.username = props.getProperty("jdbc.username");
            this.password = props.getProperty("jdbc.password");
        }
        catch(IOException e){e.printStackTrace();}
    }
    
    /**to retrieve the database connection using database properties
     * @return the database connection
     */
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
    /**to retrieve the singleton for this class through which the database connection will be accessed
     * @return the DataSource singleton
     */
    public static synchronized DataSource getInstance(){
        //create new singleton if one doesnt exist
        if(instance == null){
          instance = new DataSource();
        }
        return instance;
    }
}
