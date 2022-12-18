import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;

/**
 * Dastekin created on 18.12.2022 the PersonRowMapper-Class inside the package - PACKAGE_NAME
 */

public class PersonRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws Exception{
        return new Person(rs.getString("first_name"),
                          rs.getString("last_name"));
    }

    @Override
    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
