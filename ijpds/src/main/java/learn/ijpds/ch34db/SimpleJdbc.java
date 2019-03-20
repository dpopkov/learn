package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SimpleJdbc {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        loadDriver();
        Connection connection =connectToDb();
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

    private static Connection connectToDb() throws IOException, SQLException {
        Properties props = new Properties();
        props.load(SimpleJdbc.class.getResourceAsStream("/db.properties"));
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ijpds",
                props.getProperty("username"), props.getProperty("password"));
        System.out.println("Database connected.");
        return connection;
    }

    private static void loadDriver() throws ClassNotFoundException {
        final String mySqlDriver = "com.mysql.jdbc.Driver";
        Class clazz = Class.forName(mySqlDriver);
        System.out.println("Loaded driver class: " + clazz);
    }
}
