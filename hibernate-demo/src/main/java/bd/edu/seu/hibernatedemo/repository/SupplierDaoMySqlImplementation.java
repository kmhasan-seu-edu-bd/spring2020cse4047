package bd.edu.seu.hibernatedemo.repository;

import bd.edu.seu.hibernatedemo.model.Supplier;
import bd.edu.seu.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class SupplierDaoMySqlImplementation implements SupplierDao {
    public List<Supplier> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Supplier ", Supplier.class);
        List<Supplier> resultList = q.getResultList();
        return resultList;
    }

    public Supplier save(Supplier supplier) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(supplier);
        session.getTransaction().commit();

        // TODO got to fix the return
        return supplier;
    }
}
