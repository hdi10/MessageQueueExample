import core.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Dastekin created on 18.12.2022 the PersonRowMapperTest-Class inside the package - PACKAGE_NAME
 */

public class PersonRowMapperTest {

    @Test
    public void testMappingRow() {
        Person expected = new Person("John","Doe");

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("first_name",expected.getFirstName());
        data.put("last_name",expected.getLastName());
        MockSingleRowResultSet rs = new MockSingleRowResultSet();
        rs.addExpectedNamedValues(data);

        Assertions.assertEquals(expected,
                new PersonRowMapper().mapRow(rs,1));

    }
}
