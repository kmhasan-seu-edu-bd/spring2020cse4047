/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1.repository;

import bd.edu.seu.ajlab1.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seu
 */
public class ProductDaoMySQLImplementation implements ProductDao {

    public ProductDaoMySQLImplementation() {
    }

    // TODO someday we will fix this with Optional
    public Product readProduct(int productId) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            
            Statement statement = connection.createStatement();
            
            String query = "SELECT * FROM product WHERE productId = " + productId;
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                String quantityPerUnit = resultSet.getString("quantityPerUnit");
                double unitPrice = resultSet.getDouble("unitPrice");
                double unitsInStock = resultSet.getDouble("unitsInStock");
                double unitsOnOrder = resultSet.getDouble("unitsOnOrder");
                double reorderLevel = resultSet.getDouble("reorderLevel");
                boolean discontinued = resultSet.getBoolean("discontinued"); 
                
                Product product = new Product(id, 
                        productName, 
                        quantityPerUnit,
                        unitPrice,
                        unitsInStock,
                        unitsOnOrder,
                        reorderLevel,
                        discontinued);
                
                return product;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public List<Product> readAll() {
        List<Product> productList = new ArrayList<>();
        
        try {
            Connection connection = ConnectionSingleton.getConnection();
            
            Statement statement = connection.createStatement();
            
            String query = "SELECT * FROM product";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int productId = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                String quantityPerUnit = resultSet.getString("quantityPerUnit");
                double unitPrice = resultSet.getDouble("unitPrice");
                double unitsInStock = resultSet.getDouble("unitsInStock");
                double unitsOnOrder = resultSet.getDouble("unitsOnOrder");
                double reorderLevel = resultSet.getDouble("reorderLevel");
                boolean discontinued = resultSet.getBoolean("discontinued"); 
                
                Product product = new Product(productId, 
                        productName, 
                        quantityPerUnit,
                        unitPrice,
                        unitsInStock,
                        unitsOnOrder,
                        reorderLevel,
                        discontinued);
                
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productList;
    }
    
}











