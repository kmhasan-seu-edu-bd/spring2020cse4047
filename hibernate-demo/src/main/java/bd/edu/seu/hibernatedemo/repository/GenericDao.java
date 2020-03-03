package bd.edu.seu.hibernatedemo.repository;

import bd.edu.seu.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public interface GenericDao<TYPE> {
    List<TYPE> findAll();

    default TYPE save(TYPE type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(type);
        session.getTransaction().commit();

        // TODO got to fix the return
        return type;
    }
}
