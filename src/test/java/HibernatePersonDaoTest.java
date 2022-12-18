import core.HibernatePersonDao;
import core.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.cfgxml.internal.CfgXmlAccessServiceImpl;
import org.hibernate.classic.Session;
import org.hibernate.classic.SessionFactory;
import static org.easymock.EasyMock.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.management.Query;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
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

    expect(factory.getCurrentSession()).andReturn(session);
    expect(session.createQuery(hql)).andReturn((org.hibernate.Query) query);
    expect(query.setParameter("lastname",
            lastname)).andReturn(theSmiths);
    replay(factory,session,query);

    HibernatePersonDao dao = new HibernatePersonDao();
    dao.setSessionFactory(factory);
    Assertions.assertEquals(theSmiths,dao.findbyLastName(lastname));

    verify(factory,session,query);
}

@Test
    public void gutTest1() throws SQLException {
    DataSource dataSource = createMock(DataSource.class);
    Connection connection = createMock(Connection.class);
    expect(dataSource.getConnection()).andReturn(connection);
    String sql= "SELECT * FROM people WHERE last_name = ?";
    PreparedStatement statement = createMock(PreparedStatement.class);
    expect(connection.prepareStatement(sql)).andReturn(statement);

    MockMultiRowResultSet resultSet = new MockMultiRowResultSet();
    String[] columns = new String[] {"first_name", "last_name"};
    resultSet.setupColumnNames(columns);
    List<Person> smiths = createListOfPeopleWithLastname("Smith");
    resultSet.setupRows(convertIntoResultSetArray(smiths));
    expect(statement.executeQuery()).andReturn(resultSet);
    }



    @Test
    public void testFindByLastNameReturnsEmptyListUponException()
            throws Exception {
        String hql = "from Person p where p.lastname = :lastname";
        String name = "Smith";
        HibernateException hibernateError = new HibernateException("");

        expect(factory.getCurrentSession()).andReturn(session);
        expect(session.createQuery(hql)).andReturn(query);
        expect(query.setParameter("lastname",name)).andReturn(query);
        expect(query.list()).andThrow(hibernateError);

        replay(factory,session,query);

        HibernatePersonDao dao = new HibernatePersonDao();

        dao.setSessionFactory(factory);
        try {
            dao.findbyLastName(name);
            fail( "should ' ve thrown an exception*");

        }catch (RuntimeException expected){
            Assertions.assertSame(hibernateError,expected.getCause());
        }

        verify(factory,session,query);
    }
}



