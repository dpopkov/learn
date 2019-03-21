package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.*;

public class SimpleJdbc {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        JdbcUtil.loadDriver();
        Connection connection = JdbcUtil.connectToDb();
        Statement statement = connection.createStatement();
        String sql = "select firstName, mi, lastName from Student where lastName = 'Smith'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.printf("%s\t%s\t%s%n", resultSet.getString(1),
                    resultSet.getString(2), resultSet.getString(3));
        }
        connection.close();
        System.out.println("Connection closed.");
    }

}
