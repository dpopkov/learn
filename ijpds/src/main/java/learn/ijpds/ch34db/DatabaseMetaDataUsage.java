package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DatabaseMetaDataUsage {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        new JdbcActor().act(connection -> {
            DatabaseMetaData dbMetaData = connection.getMetaData();
            System.out.println("dbMetaData.getURL() = " + dbMetaData.getURL());
            System.out.println("dbMetaData.getDatabaseProductName() = " + dbMetaData.getDatabaseProductName());
            System.out.println("dbMetaData.getDatabaseProductVersion() = " + dbMetaData.getDatabaseProductVersion());
            System.out.println("dbMetaData.getDriverName() = " + dbMetaData.getDriverName());
            System.out.println("dbMetaData.getDriverVersion() = " + dbMetaData.getDriverVersion());
            System.out.println("dbMetaData.getDriverMajorVersion() = " + dbMetaData.getDriverMajorVersion());
            System.out.println("dbMetaData.getDriverMinorVersion() = " + dbMetaData.getDriverMinorVersion());
            System.out.println("dbMetaData.getMaxConnections() = " + dbMetaData.getMaxConnections());
            System.out.println("dbMetaData.getMaxTableNameLength() = " + dbMetaData.getMaxTableNameLength());
            System.out.println("dbMetaData.getMaxColumnsInTable() = " + dbMetaData.getMaxColumnsInTable());
        });
    }
}
