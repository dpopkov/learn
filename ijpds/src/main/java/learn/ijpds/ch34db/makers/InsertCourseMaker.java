package learn.ijpds.ch34db.makers;

import learn.ijpds.ch34db.model.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertCourseMaker extends InsertMaker {
    private static final String COURSE_ID = "(\\d{5})";
    private static final String SUBJECT_ID = "([A-Z]{4})";
    private static final String COURSE_NUMBER = "(\\d{4})";
    private static final String TITLE = "(?<title>(\\w+\\s+)*\\w+)";
    private static final String NUM_OF_CREDITS = "(?<numOfCredits>\\d+)";
    private static final String REGEX = String.join("\\s+", COURSE_ID, SUBJECT_ID, COURSE_NUMBER, TITLE, NUM_OF_CREDITS);
    private static final Pattern pattern = Pattern.compile(REGEX);

    public InsertCourseMaker() {
        super("Course");
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: InsertCourseMaker source target");
            return;
        }
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        List<String> lines = Files.readAllLines(source);
        List<String> sqlLines = new ArrayList<>();
        InsertCourseMaker maker = new InsertCourseMaker();
        List<String> columns = Arrays.asList("courseId", "subjectId", "courseNumber", "title", "numOfCredits");
        lines.forEach(line -> {
            Course st = maker.parse(line);
            String sql = maker.toInsert(st, columns);
            sqlLines.add(sql);
        });
        Files.write(target, sqlLines);
    }

    public String toInsert(Course course, List<String> columns) {
        StringBuilder builder = prependInsertColumns(columns);
        builder.append(wrap(course.getCourseId()));
        builder.append(", ");
        builder.append(wrap(course.getSubjectId()));
        builder.append(", ");
        builder.append(wrap(course.getCourseNumber()));
        builder.append(", ");
        builder.append(wrap(course.getTitle()));
        builder.append(", ");
        builder.append(wrap(course.getNumOfCredits()));
        builder.append(");");
        return builder.toString();
    }

    public Course parse(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return new Course(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    matcher.group("title"),
                    matcher.group("numOfCredits")
            );
        }
        return new Course();
    }
}
