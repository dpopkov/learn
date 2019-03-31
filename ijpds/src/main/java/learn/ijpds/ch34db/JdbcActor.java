package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcActor {
    public JdbcActor() throws ClassNotFoundException {
        JdbcUtil.loadMysqlDriver();
    }

    public void act(ConnectionConsumer connectionConsumer) throws IOException, SQLException {
        try (Connection connection = JdbcUtil.connectToMysqlDb()) {
            connectionConsumer.accept(connection);
        }
    }
}
