package bd.edu.seu.hibernatedemo.repository;

import bd.edu.seu.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public interface GenericDao<TYPE, ID> {
    List<TYPE> findAll();
    TYPE findById(ID id);
    TYPE save(TYPE type);
    void deleteById(ID id);
    void deleteAll();
    TYPE update(ID id, TYPE type);
}
