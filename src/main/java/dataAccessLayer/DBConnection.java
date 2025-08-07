package dataAccessLayer;

import java.sql.*;

/**
 * Provides a connection to the MySQL database.
 */
public class DBConnection {

    /**
     * Returns a connection to the project database.
     *
     * @return a MySQL database connection
     * @throws SQLException if the driver is not found or connection fails
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found. Make sure mysql-connector-j is in WEB-INF/lib.", e);
        }
       //You need to configure url user and the password
        String url = "jdbc:mysql://localhost:3306/javaprojectgroupkapoorsidhu?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "cst8288";
        String password = "cst8288";

        return DriverManager.getConnection(url, user, password);
    }
}