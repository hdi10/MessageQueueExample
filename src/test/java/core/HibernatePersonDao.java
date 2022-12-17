/**
 * Dastekin created on 18.12.2022 the HibernatePersonDao-Class inside the package - core
 */
package core;

import core.interfaces.PersonDao;

import java.util.List;

public class HibernatePersonDao implements PersonDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Person> findbyLastName(String lastname) {
        //Session session = sessionFactory
        query.setParameter
        return query.list();
    }
}
