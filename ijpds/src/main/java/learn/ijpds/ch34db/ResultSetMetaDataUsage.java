package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataUsage {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        new JdbcActor().act(connection -> {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from enrollment");
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    System.out.printf("%-12s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
        });
    }
}
