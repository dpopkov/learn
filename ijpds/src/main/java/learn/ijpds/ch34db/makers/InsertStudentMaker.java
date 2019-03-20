package learn.ijpds.ch34db.makers;

import learn.ijpds.ch34db.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertStudentMaker extends InsertMaker {

    private static final String REGEX = "(\\d{9})\\s+(\\w+)\\s+(\\w)\\s+(\\w+)\\s(\\d{10})\\s+(\\d{4}-\\d{2}-\\d{2}|null)\\s+(\\d{2,4}(\\s+\\w+)+\\.?)\\s+(?<zipCode>\\d{5})\\s+(?<deptID>\\w{2,4})";
    private static final Pattern pattern = Pattern.compile(REGEX);

    public InsertStudentMaker() {
        super("Student");
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: InsertStudentMaker source target");
            return;
        }
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        List<String> lines = Files.readAllLines(source);
        List<String> sqlLines = new ArrayList<>();
        InsertStudentMaker maker = new InsertStudentMaker();
        List<String> columns = Arrays.asList("ssn", "firstName", "mi", "lastName", "phone", "birthDate", "street", "zipCode", "deptID");
        lines.forEach(line -> {
            Student st = maker.parse(line);
            String sql = maker.toInsert(st, columns);
            sqlLines.add(sql);
        });
        Files.write(target, sqlLines);
    }

    public String toInsert(Student student, List<String> columns) {
        StringBuilder builder = prependInsertColumns(columns);
        builder.append(wrap(student.getSsn()));
        builder.append(", ");
        builder.append(wrap(student.getFirstName()));
        builder.append(", ");
        builder.append(wrap(student.getMi()));
        builder.append(", ");
        builder.append(wrap(student.getLastName()));
        builder.append(", ");
        builder.append(wrap(student.getPhone()));
        builder.append(", ");
        builder.append(wrap(student.getBirthDate()));
        builder.append(", ");
        builder.append(wrap(student.getStreet()));
        builder.append(", ");
        builder.append(wrap(student.getZipCode()));
        builder.append(", ");
        builder.append(wrap(student.getDeptID()));
        builder.append(");");
        return builder.toString();
    }

    public Student parse(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            String birthDay = matcher.group(6);
            return new Student(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    matcher.group(4),
                    matcher.group(5),
                    (birthDay.equals("null") ? null : birthDay),
                    matcher.group(7),
                    matcher.group("zipCode"),
                    matcher.group("deptID")
            );
        }
        return new Student();
    }
}
