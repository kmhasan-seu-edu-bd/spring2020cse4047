package bd.edu.seu.hibernatedemo.repository;

import bd.edu.seu.hibernatedemo.model.Product;
import bd.edu.seu.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class GenericDaoSqlImplementation<TYPE, ID> implements GenericDao<TYPE, ID> {
    private Class<TYPE> aClass;

    public GenericDaoSqlImplementation(Class<TYPE> aClass) {
        this.aClass = aClass;
    }

    @Override
    public List<TYPE> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From " + aClass.getSimpleName(), aClass);
        List<TYPE> resultList = q.getResultList();
        return resultList;
    }

    @Override
    public TYPE findById(ID id) {
        // TODO write implementation for this one
        return null;
    }

    @Override
    public void deleteById(ID id) {
        // TODO write this one
    }

    @Override
    public void deleteAll() {
        // TODO write this one
    }

    @Override
    public TYPE update(ID id, TYPE type) {
        // TODO write this one
        return null;
    }

    @Override
    public TYPE save(TYPE type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(type);
        session.getTransaction().commit();

        // TODO advanced: fix this one by returning serialized version of it
        return type;
    }
}
