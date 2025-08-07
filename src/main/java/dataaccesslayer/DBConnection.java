package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){throw new SQLException("MySQL Driver not found. Make sure mysql-connector-j is in WEB-INF/lib.", e);}
        
        String url = "jdbc:mysql://localhost:3306/OOPProject";
        String user = "cst8288";
        String password = "cst8288";
        
        return DriverManager.getConnection(url, user, password);
    }
}