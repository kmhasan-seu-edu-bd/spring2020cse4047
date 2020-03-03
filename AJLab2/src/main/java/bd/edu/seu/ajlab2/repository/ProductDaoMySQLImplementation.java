/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab2.repository;

import bd.edu.seu.ajlab2.exception.ProductAlreadyExistsException;
import bd.edu.seu.ajlab2.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
        // TASK: Read the queries from product-sql.properties files
        // You can have a look at the ConnectionSingleton class to see how I did it for the dbconnection.properties
        // We only need to do this once, so implement this one as a Singleton
    }

    // TODO someday we will fix this with Optional
    public Product readProduct(int productId) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            
            
            // TASK: replace this query by the one you read from the properties file
//            String query = "SELECT * FROM product WHERE productId = " + productId;
            String query = QuerySingleton.getQuery("READ_BY_ID");

            // TASK (advanced): use a prepared statement instead of a statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);

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
            
            // TASK (advanced): use a prepared statement instead of a statement
            Statement statement = connection.createStatement();
            
            // TASK: replace this query by the one you read from the properties file
//            String query = "SELECT * FROM product";
            String query = QuerySingleton.getQuery("READ_ALL");
            
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

    @Override
    public Product createProduct(Product product) throws ProductAlreadyExistsException {
        try {
            Connection connection = ConnectionSingleton.getConnection();

            // TASK (advanced): use a prepared statement instead of a statement
            Statement statement = connection.createStatement();
            
            // TASK: replace this query by the one you read from the properties file
            String query = String.format("INSERT INTO product VALUES(%d, \"%s\", \"%s\", %f, %f, %f, %f, %b)",
                    product.getProductID(),
                    product.getProductName(),
                    product.getQuantityPerUnit(),
                    product.getUnitPrice(),
                    product.getUnitsInStock(),
                    product.getUnitsOnOrder(),
                    product.getReorderLevel(),
                    product.isDiscontinued());
            System.out.println("Query: " + query);
            int rowCount = statement.executeUpdate(query);
            System.out.println("Inserted " + rowCount + " rows");
            // TODO how can we tell the user that the insert operation failed?
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new ProductAlreadyExistsException(product);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProductDaoMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TASK: instead of returning null, return the Product that got inserted into the DB
        return null;
    }

    @Override
    public List<Product> deleteAll() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "DELETE FROM product";
            int rowCount = statement.executeUpdate(query);
            System.out.println("Deleted " + rowCount + " rows");
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProductDaoMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TASK: instead of returning null, return all the products that got deleted
        return null;
    }
    
}











