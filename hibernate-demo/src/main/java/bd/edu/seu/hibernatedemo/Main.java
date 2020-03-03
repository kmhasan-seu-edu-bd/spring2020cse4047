package bd.edu.seu.hibernatedemo;

import bd.edu.seu.hibernatedemo.model.Product;
import bd.edu.seu.hibernatedemo.repository.ProductDao;
import bd.edu.seu.hibernatedemo.repository.ProductDaoMySqlImplementation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private Product createProduct(int id, String name, double price, double stock) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPricePerUnit(price);
        product.setUnitsInStock(stock);
        product.setDiscontinued(false);
        product.setSupplierList(new ArrayList<>());
        return product;
    }

    public Main() {
        Product product1 = createProduct(896, "OnePlus 5T", 50_000, 5);
        Product product2 = createProduct(998, "Casio G-Shock", 20_000, 10);
        //System.out.println(product1);

        ProductDao productDao = new ProductDaoMySqlImplementation();

        productDao.save(product1);
        productDao.save(product2);

        List<Product> productList = productDao.findAll();
        productList.stream().forEach(System.out::println);
    }

    public static void main(String args[]) {
        new Main();
    }
}
