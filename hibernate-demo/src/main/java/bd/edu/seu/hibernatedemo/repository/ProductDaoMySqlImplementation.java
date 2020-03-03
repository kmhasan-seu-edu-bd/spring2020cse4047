package bd.edu.seu.hibernatedemo.repository;

import bd.edu.seu.hibernatedemo.model.Product;
import bd.edu.seu.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class ProductDaoMySqlImplementation implements GenericDao<Product> {
    // REMOVE THIS ONE BY WRITING DEFAULT IMPLEMENTATION OF FINDALL
    public List<Product> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Product ", Product.class);
        List<Product> resultList = q.getResultList();
        return resultList;
    }
}
