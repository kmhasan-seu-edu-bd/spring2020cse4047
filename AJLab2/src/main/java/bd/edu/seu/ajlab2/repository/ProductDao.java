/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab2.repository;

import bd.edu.seu.ajlab2.exception.ProductAlreadyExistsException;
import bd.edu.seu.ajlab2.model.Product;
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
    
    // TASK: implement all the methods
    // Add appropriate throws Exception classes for each method and update the implementations
    default public Product createProduct(Product product) throws ProductAlreadyExistsException { return null;}
    default public List<Product> createProducts(List<Product> productList) { return null; }
    default public Product deleteProduct(int productId) { return null;}
    default public Product updateProduct(int productId, Product product) { return null; }
    default public List<Product> deleteAll() { return null; }
}






