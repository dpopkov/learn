package learn.ijpds.ch34db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class FindGradeAbstract implements GradeReader, Closeable {
    private Connection connection;

    public FindGradeAbstract() throws SQLException, IOException, ClassNotFoundException {
        initializeConnection();
    }

    private void initializeConnection() throws ClassNotFoundException, IOException, SQLException {
        JdbcUtil.loadDriver();
        connection = JdbcUtil.connectToDb();
    }

    protected Connection getConnection() {
        return connection;
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
