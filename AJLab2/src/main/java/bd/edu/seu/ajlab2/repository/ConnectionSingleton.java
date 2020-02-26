/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab2.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seu
 */
public class ConnectionSingleton {

    private static ConnectionSingleton instance = new ConnectionSingleton();
    private static Connection connection;

    private static String user;
    private static String password;
    private static String hostname;
    private static String dbname;
    private static String url;

    private static void readConnectionParameters() {
        String dbconnectionPropertiesFilename = "dbconnection.properties";

        try (InputStream inputStream = ConnectionSingleton.class.getClassLoader().getResourceAsStream(dbconnectionPropertiesFilename)) {
            Properties properties = new Properties();

            if (properties != null && inputStream != null) {
                System.out.println("Reading from " + dbconnectionPropertiesFilename);
                properties.load(inputStream);
                user = properties.getProperty("user");
                password = properties.getProperty("password");
                hostname = properties.getProperty("hostname");
                dbname = properties.getProperty("dbname");
                url = "jdbc:mysql://" + hostname + "/" + dbname;
            } else {
                System.err.println("Properties/InputStream object is null");
            }

        } catch (IOException ex) {
            Logger.getLogger(ConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ConnectionSingleton() {
        readConnectionParameters();
        connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection OK");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
