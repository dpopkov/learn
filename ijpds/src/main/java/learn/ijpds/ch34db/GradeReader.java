package learn.ijpds.ch34db;

import java.sql.SQLException;

public interface GradeReader {
    String readGrade(String ssn, String courseId) throws SQLException;
}
