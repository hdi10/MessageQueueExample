import core.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.mockito.internal.util.MockUtil.createMock;

/**
 * Dastekin created on 18.12.2022 the JdbcPersonDaoTest-Class inside the package - PACKAGE_NAME
 */

public class JdbcPersonDaoTest {

    @Test
    public void testFindByLastNameGoodTest1(){
        DataSource dataSource = createMock(DataSource.class);
        Connection connection = createMock(Connection.class);
        expect(dataSource.getConnection()).andReturn(connection);
        String sql= "SELECT * FROM people WHERE last_name = ?";
        PreparedStatement statement =
                createMock(PreparedStatement.class);
        expect(connection.prepareStatement(sql)).andReturn(statement);
    statement.setString(1,"Smith");

        MockMultiRowResultSet resultSet = new MockMultiRowResultSet();
        String[] columns = new String[] {"first_name", "last_name"};
        resultSet.setupColumnNames(columns);
        List<Person> smiths = createListOfPeopleWithLastname("Smith");
        resultSet.setupRows(convertIntoResultSetArray(smiths));
        expect(statement.executeQuery()).andReturn(resultSet);

        resultSet.setExpectedCloseCalls(1);
        statement.close();
        connection.close();

        replay(dataSource,connection,statement);

        JdbcPersonDao dao = new JdbcPersonDao();
        dao.setDatasource(dataSource);
        List<Person> people = dao.findByLastname("Smith");
        Assertions.assertEquals(smiths,people);
        verify(dataSource,connection,statement);
        resultSet.verify();

    private List<Person> createListOfPeopleWithLastname(String lastname);
        List<Person> expected = new ArrayList<Person>();
        expected.add(new Person("Alice",lastname);
        expected.add(new Person("Billy",lastname);
        expected.add(new Person("Clark",lastname);

        return expected;

    }

    private Object[][] asResultSetArray(List<Person> people) {
        Object[][] array = new Object[people.size()][2];
        for (int i = 0; i < array.length; i++) {
            Person person = people.get(i);
            array[i] = new Object[] {
                    person.getFirstname(),
                    person.getLastname()    };
            }
            return array;
        }
    }



}
