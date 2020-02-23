/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1.repository;

import bd.edu.seu.ajlab1.model.Product;
import java.util.List;

/**
 *
 * @author kmhasan
 */
public interface ProductDao {
    public List<Product> readAll();
    
    default public Product readProduct(int productId) {
        for (Product product : readAll())
            if (product.getProductID() == productId)
                return product;
        return null;
    }
    
    public void createProduct(Product product);
    public void deleteProduct(int productId);
    public void updateProduct(int productId, Product product);
}
// Singleton design pattern
// TODO advanced
// 1. restore the .csv file in a mysql database
// 2. write a ProductDaoMySQLImplementation that reads from the database instead of the csv file






