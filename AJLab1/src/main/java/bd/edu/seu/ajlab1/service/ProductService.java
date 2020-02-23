/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1.service;

import bd.edu.seu.ajlab1.model.Product;
import bd.edu.seu.ajlab1.repository.ProductDao;
import bd.edu.seu.ajlab1.repository.ProductDaoCsvImplementation;
import bd.edu.seu.ajlab1.repository.ProductDaoMySQLImplementation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author kmhasan
 */
public class ProductService {
    
    private ProductDao productDao;
    
    public ProductService() {
        // we can switch out the implementation just by changing one line here
        // that's the beauty of using DAO pattern here
//        productDao = new ProductDaoCsvImplementation();
        productDao = new ProductDaoMySQLImplementation();
    }

    public List<Product> readAll() {
        return productDao.readAll();
    }
    
    public Product readProduct(int productId) {
        return productDao.readProduct(productId);
    }
    
    // a sample implementation
    public List<Product> findAllDiscontinuedProducts() {
        List<Product> productList = productDao.readAll()
                .stream()
                .filter(Product::isDiscontinued)
                .collect(Collectors.toList());
        return productList;
    }

    // TODO write your code here
    public List<Product> findProductsThatNeedToBeReordered() {
        List<Product> productList = productDao.readAll()
                .stream()
                .filter(product -> product.getUnitsInStock() < product.getReorderLevel())
                .collect(Collectors.toList());
        return productList;
    }

    // TODO write your code here
    public List<Product> getProductListSortedByUnitPrice() {
        List<Product> productList = productDao.readAll();
        /*        productList.sort((p1, p2) -> {
            int price1 = (int) (p1.getUnitPrice() * 1000);
            int price2 = (int) (p2.getUnitPrice() * 1000);
            return price1 - price2;
        });*/
 /*
        Collections.sort(productList, (p1, p2) -> {
            int price1 = (int) (p1.getUnitPrice() * 1000);
            int price2 = (int) (p2.getUnitPrice() * 1000);
            return price1 - price2;
        });*/
        productList = productList
                .stream()
                .sorted(Comparator.comparing(Product::getUnitPrice))
                .collect(Collectors.toList());
        return productList;
    }

    // TODO write your code here
    public List<Product> getProductListSortedByProductName() {
        List<Product> productList = productDao.readAll()
                .stream()
                .parallel()
                .sorted(Comparator.comparing(Product::getProductName)
                        .thenComparing(Product::getUnitPrice))
                .collect(Collectors.toList());
        return productList;
    }

    // TODO write your code here
    public double getTotalPriceOfProductsInStock() {
        return 0;
    }
}
