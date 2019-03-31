package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindUserTables {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        new JdbcActor().act(connection -> {
            DatabaseMetaData dbMetaData = connection.getMetaData();
            ResultSet rsTables = dbMetaData.getTables(null, null, null,
                    new String[] {"TABLE"});
            System.out.println("User tables:");
            while (rsTables.next()) {
                System.out.println(rsTables.getString("TABLE_NAME"));
            }
        });
    }
}
