/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab2.exception;

import bd.edu.seu.ajlab2.model.Product;

/**
 *
 * @author kmhasan
 */
public class ProductAlreadyExistsException extends Exception {
    private Product product;

    public ProductAlreadyExistsException(Product product) {
        super(String.format("Product (%d: %s) already exists", product.getProductID(), product.getProductName()));
        this.product = product;
    }
}
