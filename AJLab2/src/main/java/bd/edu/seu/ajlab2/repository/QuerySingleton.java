/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab2.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seu
 */
public class QuerySingleton {
    private static QuerySingleton instance = new QuerySingleton();
    private static Properties properties;
    
    private static void readQueryParameters() {
        String productQueryFilename = "product-sql.properties";

        try (InputStream inputStream = ConnectionSingleton.class.getClassLoader().getResourceAsStream(productQueryFilename)) {
            properties = new Properties();

            if (properties != null && inputStream != null) {
                System.out.println("Reading from " + productQueryFilename);
                properties.load(inputStream);
            } else {
                System.err.println("Properties/InputStream object is null");
            }

        } catch (IOException ex) {
            Logger.getLogger(ConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getQuery(String queryName) {
        return properties.getProperty(queryName);
    }
    
    private QuerySingleton() {
        readQueryParameters();
    }
    
}
