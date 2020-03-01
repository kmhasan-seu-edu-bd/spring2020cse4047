package bd.edu.seu.hibernatedemo.repository;

import bd.edu.seu.hibernatedemo.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
    public Product findById(long id);
    public Product save(Product product);
}
