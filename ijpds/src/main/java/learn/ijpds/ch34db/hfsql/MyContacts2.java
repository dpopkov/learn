package learn.ijpds.ch34db.hfsql;

import learn.ijpds.ch34db.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Reads data from my_contacts2 table.
 */
public class MyContacts2 {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        JdbcUtil.loadMysqlDriver();
        try (Connection connection = JdbcUtil.connectToMysqlDb(Database.NAME)) {
            Statement statement = connection.createStatement();
            String sql = "select contact_id, last_name, first_name from my_contacts2";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                System.out.printf("%2d: %s %s%n", id, firstName, lastName);
            }
        }
    }
}
