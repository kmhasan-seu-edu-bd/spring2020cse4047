package bd.edu.seu.hibernatedemo.repository;

import bd.edu.seu.hibernatedemo.model.Supplier;

import java.util.List;

public interface SupplierDao {
    public List<Supplier> findAll();
    public Supplier save(Supplier supplier);
}
