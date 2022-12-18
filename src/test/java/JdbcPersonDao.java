import core.Person;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Dastekin created on 18.12.2022 the JdbcPersonDao-Class inside the package - PACKAGE_NAME
 */

public class JdbcPersonDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Person> findByLastname(String lastname) {
        try {
            Connection conn = dataSource.getConnection();
            String sql = "SELECT * FROM people WHERE last_name = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, lastname);
            ResultSet resultSet = statement.executeQuery();
            List<Person> people = new ArrayList<Person>();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                people.add(new Person(firstName,lastName));
            }
            resultSet.close();
            statement.close();
            conn.close();
            return people;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }


///////////////////////////// Other PersonDao methods in progress building
}
}
