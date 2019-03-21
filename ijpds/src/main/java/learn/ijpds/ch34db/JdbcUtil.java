package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private JdbcUtil() {
    }

    static Connection connectToDb() throws IOException, SQLException {
        Properties props = new Properties();
        props.load(SimpleJdbc.class.getResourceAsStream("/db.properties"));
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ijpds",
                props.getProperty("username"), props.getProperty("password"));
        System.out.println("Database connected.");
        return connection;
    }

    static void loadDriver() throws ClassNotFoundException {
        final String mySqlDriver = "com.mysql.jdbc.Driver";
        Class.forName(mySqlDriver);
    }
}
