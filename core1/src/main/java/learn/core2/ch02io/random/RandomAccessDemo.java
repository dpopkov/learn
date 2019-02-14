package learn.core2.ch02io.random;

import learn.core1.ch04.Employee;
import learn.core1.ch04.EmployeeIO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessDemo {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Tester", 71_000, 1987, 12, 15);
        staff[1] = new Employee("Harry Cracker", 51_000, 1989, 10, 1);
        staff[2] = new Employee("Tony Hacker", 41_000, 1990, 3, 15);
        String fileName = "io-data/employee.dat";
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for (Employee e : staff) {
                EmployeeIO.writeData(out, e);
            }
        }
        try (RandomAccessFile in = new RandomAccessFile(fileName, "r")) {
            int arraySize = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = readReversed(arraySize, in);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    private static Employee[] readReversed(int arraySize, RandomAccessFile in) throws IOException {
        Employee[] array = new Employee[arraySize];
        for (int i = array.length - 1; i >= 0; i--) {
            in.seek(i * Employee.RECORD_SIZE);
            array[array.length - 1 - i] = EmployeeIO.readData(in);
        }
        return array;
    }
}
