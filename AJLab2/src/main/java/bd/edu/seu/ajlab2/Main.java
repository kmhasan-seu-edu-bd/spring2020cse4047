/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab2;

import bd.edu.seu.ajlab2.model.Product;
import bd.edu.seu.ajlab2.service.ProductService;
import java.util.List;

/**
 *
 * @author kmhasan
 */
public class Main {
    private ProductService productService;
    
    public Main() {
        productService = new ProductService();
        
        productService.readAll()
                .stream()
                .forEach(System.out::println);
        System.out.println("Total products: " + productService.readAll().size());
        
        System.out.println("Searching for product: " + 1);
        System.out.println(productService.readProduct(1));
        
        System.out.println("Discontinued products: " + productService.findAllDiscontinuedProducts().size());
       
        // TODO add necessary lines to produce outputs for the other service methods
        List<Product> productsToBeReorderedList = productService.findProductsThatNeedToBeReordered();
        System.out.println("Products to be reordered");
        productsToBeReorderedList.stream().forEach(System.out::println);
    }
    
    public static void main(String args[]) {
        new Main();
    }
}
