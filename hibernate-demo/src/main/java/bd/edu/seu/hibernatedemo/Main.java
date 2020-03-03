package bd.edu.seu.hibernatedemo;

import bd.edu.seu.hibernatedemo.model.Product;
import bd.edu.seu.hibernatedemo.model.Supplier;
import bd.edu.seu.hibernatedemo.repository.*;

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

    Supplier createSupplier(int id, String name, String address) {
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setName(name);
        supplier.setAddress(address);
        return supplier;
    }

    public Main() {
        Product product1 = createProduct(896, "OnePlus 5T", 50_000, 5);
        Product product2 = createProduct(998, "Casio G-Shock", 20_000, 10);
        //System.out.println(product1);

        Supplier supplier1 = createSupplier(12, "John Doe", "Somewhere");
        Supplier supplier2 = createSupplier(13, "Jane Doe", "Nowhere");

        product1.setSupplierList(List.of(supplier1, supplier2));

        SupplierDao supplierDao = new SupplierDaoMySqlImplementation();
        GenericDao productDao = new ProductDaoMySqlImplementation();

        supplierDao.save(supplier1);
        supplierDao.save(supplier2);
        productDao.save(product1);
        productDao.save(product2);

        List<Product> productList = productDao.findAll();
        productList.stream().forEach(System.out::println);
    }

    public static void main(String args[]) {
        new Main();
    }
}
