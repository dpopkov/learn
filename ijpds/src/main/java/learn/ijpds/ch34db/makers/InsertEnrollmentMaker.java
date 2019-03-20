package learn.ijpds.ch34db.makers;

import learn.ijpds.ch34db.model.Enrollment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertEnrollmentMaker extends InsertMaker {
    private static final String SSN = "(\\d{9})";
    private static final String COURSE_ID = "(\\d{5})";
    private static final String DATE_REGISTERED = "(\\d{4}-\\d{2}-\\d{2})";
    private static final String GRADE = "(\\w)";
    private static final String REGEX = String.join("\\s+", SSN, COURSE_ID, DATE_REGISTERED, GRADE);
    private static final Pattern pattern = Pattern.compile(REGEX);

    public InsertEnrollmentMaker() {
        super("Enrollment");
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: InsertEnrollmentMaker source target");
            return;
        }
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        List<String> lines = Files.readAllLines(source);
        List<String> sqlLines = new ArrayList<>();
        InsertEnrollmentMaker maker = new InsertEnrollmentMaker();
        List<String> columns = Arrays.asList("ssn", "courseId", "dateRegistered", "grade");
        lines.forEach(line -> {
            Enrollment enrollment = maker.parse(line);
            String sql = maker.toInsert(enrollment, columns);
            sqlLines.add(sql);
        });
        Files.write(target, sqlLines);
    }

    public String toInsert(Enrollment enrollment, List<String> columns) {
        StringBuilder builder = prependInsertColumns(columns);
        builder.append(wrap(enrollment.getSsn()));
        builder.append(", ");
        builder.append(wrap(enrollment.getCourseId()));
        builder.append(", ");
        builder.append(wrap(enrollment.getDateRegistered()));
        builder.append(", ");
        builder.append(wrap(enrollment.getGrade()));
        builder.append(");");
        return builder.toString();
    }

    public Enrollment parse(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return new Enrollment(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    matcher.group(4)
            );
        }
        return new Enrollment();
    }
}
