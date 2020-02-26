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
public class ProductDoesNotExistException extends Exception {
    private Product product;

    public ProductDoesNotExistException(Product product) {
        super(String.format("Product (%d: %s) does not exist", product.getProductID(), product.getProductName()));
        this.product = product;
    }

    public ProductDoesNotExistException(int productId) {
        super(String.format("Product (%d) does not exist", productId));
        this.product = null;
    }
}
