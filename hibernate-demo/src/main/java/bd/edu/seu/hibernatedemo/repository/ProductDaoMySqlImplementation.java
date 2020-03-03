package bd.edu.seu.hibernatedemo.repository;

import bd.edu.seu.hibernatedemo.model.Product;
import bd.edu.seu.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class ProductDaoMySqlImplementation implements ProductDao {
    public List<Product> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Product ", Product.class);
        List<Product> resultList = q.getResultList();
        return resultList;
    }

    public Product save(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();

        // TODO got to fix the return
        return product;
    }
}
