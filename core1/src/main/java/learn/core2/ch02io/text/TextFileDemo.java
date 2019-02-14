package learn.core2.ch02io.text;

import learn.core1.ch04.Employee;
import learn.core1.ch04.EmployeeIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.function.Consumer;

public class TextFileDemo {
    private static final String FIELD_SEPARATOR = "|";
    private static final String SEPARATOR_REGEX = "\\" + FIELD_SEPARATOR;

    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Hacker", 75_000, 1987, 12, 15);
        staff[1] = new Employee("Harry Cracker", 50_000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40_000, 1990, 3, 15);
        String fileName = "io-data/employee.dat";
        try (PrintWriter out = new PrintWriter(fileName, StandardCharsets.UTF_8)) {
            writeData(staff, out);
        }
        try (Scanner in = new Scanner(new FileInputStream(fileName), StandardCharsets.UTF_8)) {
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    private static void writeData(Employee[] employees, PrintWriter out) {
        out.println(employees.length);
        Consumer<String> consumer = out::println;
        for (Employee e : employees) {
            EmployeeIO.printTo(e, consumer, FIELD_SEPARATOR);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = EmployeeIO.readFrom(in, SEPARATOR_REGEX);
        }
        return employees;
    }
}
