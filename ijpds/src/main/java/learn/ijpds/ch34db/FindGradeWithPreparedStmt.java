package learn.ijpds.ch34db;

import java.io.IOException;
import java.sql.*;

public class FindGradeWithPreparedStmt extends FindGradeAbstract {
    private static final String SQL = "select firstName, mi, lastName, title, grade "
            + "from Student, Enrollment, Course "
            + "where Enrollment.courseId = Course.courseId "
            + "and Student.ssn = ? and Enrollment.courseId = ?";

    private PreparedStatement statement;

    public FindGradeWithPreparedStmt() throws SQLException, IOException, ClassNotFoundException {
        super();
        statement = getConnection().prepareStatement(SQL);
    }

    @Override
    public String readGrade(String ssn, String courseId) throws SQLException {
        statement.setString(1, ssn);
        statement.setString(2, courseId);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return String.format("%s %s %s's grade on course '%s' is %s",
                    result.getString(1), result.getString(2),
                    result.getString(3), result.getString(4),
                    result.getString(5));
        } else {
            return "Not found";
        }
    }
}
