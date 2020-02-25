/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1.repository;

import bd.edu.seu.ajlab1.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author seu
 */
public class ProductDaoMySQLImplementationTest {

    private ProductDao productDao;

    public ProductDaoMySQLImplementationTest() {
        productDao = new ProductDaoMySQLImplementation();
    }

    @BeforeEach
    public void deleteAll() {
        System.out.println("Calling delete all");
        productDao.deleteAll();
    }
    
    @Test
    public void testReadProduct() {
    }

    @Test
    public void testReadAll() {
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product(
                56,
                "Casio G-Shock",
                "1 per box",
                10_000,
                15,
                19,
                5,
                false);
        productDao.createProduct(product);
        Product productFromDatabase = productDao.readProduct(56);
        
        Assertions.assertEquals(product.getProductID(), productFromDatabase.getProductID());
        Assertions.assertEquals(product.getProductName(), productFromDatabase.getProductName());
        Assertions.assertEquals(product.getQuantityPerUnit(), productFromDatabase.getQuantityPerUnit());
        Assertions.assertEquals(product.getUnitPrice(), productFromDatabase.getUnitPrice());
        Assertions.assertEquals(product.getUnitsInStock(), productFromDatabase.getUnitsInStock());
        Assertions.assertEquals(product.getUnitsOnOrder(), productFromDatabase.getUnitsOnOrder());
        Assertions.assertEquals(product.getReorderLevel(), productFromDatabase.getReorderLevel());
        Assertions.assertEquals(product.isDiscontinued(), productFromDatabase.isDiscontinued());
        deleteAll();
    }

}









