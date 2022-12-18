/**
 * Dastekin created on 18.12.2022 the HibernatePersonDao-Class inside the package - core
 */
package core;

import core.interfaces.PersonDao;

import javax.management.Query;
import java.util.List;

public class HibernatePersonDao<SessionFactory> implements PersonDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Person> findbyLastName(String lastname) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Person p where p.lastname = :lastname";
        Query query = session.createQuery(hql);
        query.setParameter("lastname",lastname);
        return query.list();
    }
}
