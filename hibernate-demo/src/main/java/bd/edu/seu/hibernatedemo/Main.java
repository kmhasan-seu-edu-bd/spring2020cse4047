package bd.edu.seu.hibernatedemo;

import bd.edu.seu.hibernatedemo.model.Product;
import bd.edu.seu.hibernatedemo.repository.ProductDao;
import bd.edu.seu.hibernatedemo.repository.ProductDaoMySqlImplementation;

public class Main {
    public Main() {
        Product product = new Product(896, "OnePlus 5T", 50_000, 5);
        System.out.println(product);

        ProductDao productDao = new ProductDaoMySqlImplementation();
        productDao.save(product);
    }

    public static void main(String args[]) {
        new Main();
    }
}
