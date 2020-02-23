/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1.repository;

import bd.edu.seu.ajlab1.model.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author kmhasan
 */
public class ProductDaoCsvImplementation implements ProductDao {

    private final String CSV_FILENAME = "products.csv";

    @Override
    public List<Product> readAll() {
        try {
            List<Product> productList = Files.lines(Paths.get(CSV_FILENAME))
                    .map(this::getProduct)
                    .filter(product -> product != null)
                    .collect(Collectors.toList());
            return productList;
        } catch (IOException ex) {
            Logger.getLogger(ProductDaoCsvImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Product getProduct(String line) {
        if (line.startsWith("p"))
            return null;
        
        String[] tokens = line.split("\\,");
        
        int productId = Integer.parseInt(tokens[0]);
        String productName = tokens[1];
        String quantityPerUnit = tokens[4];
        double unitPrice = Double.parseDouble(tokens[5]);
        double unitsInStock = Double.parseDouble(tokens[6]);
        double unitsOnOrder = Double.parseDouble(tokens[7]);
        double reorderLevel = Double.parseDouble(tokens[8]);
        boolean discontinued = tokens[9].charAt(0) == '1';
        
        Product product = new Product(productId, 
                productName, 
                quantityPerUnit, 
                unitPrice, 
                unitsInStock, 
                unitsOnOrder, 
                reorderLevel, 
                discontinued);
        return product;
    }
}
