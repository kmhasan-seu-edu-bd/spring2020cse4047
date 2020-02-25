/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seu
 */
public class ConnectionSingleton {
    private static ConnectionSingleton instance = new ConnectionSingleton();
    private static Connection connection;
    
    private ConnectionSingleton() {
        // TODO see how Property files are used in Java
        String hostname = "123.200.8.61";
        String dbname = "productdb";
        String url = "jdbc:mysql://" + hostname + "/" + dbname;
        String user = "cse4047";
        String password = "Lazy_Day_33";

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
