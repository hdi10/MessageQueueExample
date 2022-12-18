/**
 * Dastekin created on 18.12.2022 the HibernatePersonDao-Class inside the package - core
 */
package core;

import core.interfaces.PersonDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import javax.management.Query;
import java.util.List;

public class HibernatePersonDao implements PersonDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Person> findbyLastName(String lastname) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Person p where p.lastname = :lastname";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("lastname",lastname);
        return query.list();
    }

    @Override
    public Person find(Integer id) {
        return null;
    }

    @Override
    public void save(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public List<Person> findByLastname(String lastname) {
        return null;
    }


}
