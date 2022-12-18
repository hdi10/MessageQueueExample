import core.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.internal.util.MockUtil.createMock;

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

@Test
    public  void testFindLastname() throws Exception {
    String hql = "from Person p where p.lastname = :lastname";
    String lastname = "Smith";

    List<Person> theSmiths = new ArrayList<Person>();
    theSmiths.add(new Person("Alice",lastname);
    theSmiths.add(new Person("Billy",lastname);
    theSmiths.add(new Person("Clark",lastname);

}


}

