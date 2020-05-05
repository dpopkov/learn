package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class E0804ComputeHours {

    private static class Employee {
        private final int id;

        private int hours;

        public Employee(int id) {
            this.id = id;
        }

        public Employee(int id, int[] hoursArray) {
            this(id);
            for (int h : hoursArray) {
                addHours(h);
            }
        }

        public int getHours() {
            return hours;
        }

        public void addHours(int h) {
            hours += h;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", hours=" + hours + '}';
        }
    }

    public static void main(String[] args) {
        String inputHours = "0 2 4 3 4 5 8 8\n1 7 3 4 3 3 4 4\n2 3 3 4 3 3 2 2\n3 9 3 4 7 3 4 1\n4 3 5 4 3 6 3 8\n"
                + "5 3 4 4 6 3 4 4\n6 3 7 4 8 3 8 4\n7 6 3 5 9 2 7 9";
        String[] lines = inputHours.split("\n");
        Employee[] employees = new Employee[lines.length];
        for (int i = 0; i < lines.length; i++) {
            int[] employeeHours = ArrayUtils.parseToIntArray(lines[i]);
            employees[i] = new Employee(i, employeeHours);
        }
        Arrays.sort(employees, Comparator.comparingInt(Employee::getHours));
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
