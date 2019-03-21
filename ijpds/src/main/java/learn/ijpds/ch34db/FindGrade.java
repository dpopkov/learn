package learn.ijpds.ch34db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindGrade implements Closeable {
    private Statement statement;
    private Connection connection;

    public FindGrade() throws SQLException, IOException, ClassNotFoundException {
        initializeDb();
    }

    private void initializeDb() throws ClassNotFoundException, IOException, SQLException {
        JdbcUtil.loadDriver();
        connection = JdbcUtil.connectToDb();
        statement = connection.createStatement();
    }

    public String readGrade(String ssn, String courseId) throws SQLException {
        String query = String.format("select firstName, mi, lastName, title, grade "
                + "from Student, Enrollment, Course where Student.ssn = Enrollment.ssn "
                + "and Enrollment.courseId = Course.courseId "
                + "and Student.ssn = '%s' and "
                + "Enrollment.courseId = '%s'", ssn, courseId);
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            return String.format("%s %s %s's grade on course '%s' is %s",
                    result.getString(1), result.getString(2),
                    result.getString(3), result.getString(4),
                    result.getString(5));
        } else {
            return "Not found";
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FindGrade ssn gradeId");
            return;
        }
        String ssn = args[0];
        String gradeId = args[1];
        try (FindGrade findGrade = new FindGrade()) {
            String result = findGrade.readGrade(ssn, gradeId);
            System.out.println(result);
        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }
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
