package learn.ijpds.ch34db;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionConsumer {
    void accept(Connection connection) throws SQLException;
}
