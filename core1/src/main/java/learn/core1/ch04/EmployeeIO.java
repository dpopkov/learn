package learn.core1.ch04;

import learn.core2.ch02io.random.DataIO;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Contains methods for input and output of {@link Employee} objects.
 */
public class EmployeeIO {
    public static void printTo(Employee e, Consumer<String> out, String fieldSeparator) {
        out.accept(e.getId() + fieldSeparator + e.getName() + fieldSeparator + e.getSalary() + fieldSeparator + e.getHireDay());
    }

    public static Employee readFrom(Scanner in, String separatorRegex) {
        String line = in.nextLine();
        String[] tokens = line.split(separatorRegex);
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        double salary = Double.parseDouble(tokens[2]);
        LocalDate hireDate = LocalDate.parse(tokens[3]);
        return new Employee(id, name, salary, hireDate);
    }

    public static void writeData(DataOutput out, Employee e) throws IOException {
        out.writeInt(e.getId());
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());
        LocalDate hireDate = e.getHireDay();
        out.writeInt(hireDate.getYear());
        out.writeInt(hireDate.getMonthValue());
        out.writeInt(hireDate.getDayOfMonth());
    }

    public static Employee readData(DataInput in) throws IOException {
        int id = in.readInt();
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(id, name, salary, LocalDate.of(y, m, d));
    }
}
