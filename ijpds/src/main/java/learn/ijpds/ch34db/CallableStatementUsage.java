package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CallableStatementUsage {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Scanner in = new Scanner(System.in);
        JdbcUtil.loadMysqlDriver();
        try (Connection connection = JdbcUtil.connectToMysqlDb("ijpds")) {
            CallableStatement callableStatement = connection.prepareCall(
                    "{? = call studentFound(?, ?)}");
            System.out.print("Enter student's first name: ");
            String firstName = in.nextLine();
            System.out.print("Enter student's last name: ");
            String lastName = in.nextLine();
            callableStatement.setString(2, firstName);
            callableStatement.setString(3, lastName);
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            if (callableStatement.getInt(1) >= 1) {
                System.out.printf("%s %s is in the database%n", firstName, lastName);
            } else {
                System.out.printf("%s %s is not in the database%n", firstName, lastName);
            }
        }
    }
}
