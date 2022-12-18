import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;

import javax.management.Query;

/**
 * Dastekin created on 18.12.2022 the HibernatePersonDaoTest-Class inside the package - PACKAGE_NAME
 */

public class HibernatePersonDaoTest {

private SessionFactory factory;
private Session session;
private Query query;

@BeforeAll
    public void setUp() {
    factory = createMock(SessionFactory.class);
    session = createMock(Session.class);
    query = createMock(Query.class);

}
}
