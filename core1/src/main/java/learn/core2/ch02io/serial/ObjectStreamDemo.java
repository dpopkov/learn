package learn.core2.ch02io.serial;

import learn.core1.ch04.Employee;
import learn.core1.ch05.Manager;

import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee harry = new Employee("Harry Hacker", 50_000, 1989, 10, 1);
        Manager carl = new Manager("Carl Cracker", 80_000, 1987, 12, 15);
        carl.setSecretary(harry);
        Manager tony = new Manager("Tony Tester", 40_000, 1990, 3, 15);
        tony.setSecretary(harry);
        Employee[] staff = new Employee[3];
        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;
        String filename = "io-data/employee.dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            out.writeObject(staff);
        }
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            Employee[] newStaff = (Employee[]) in.readObject();
            newStaff[1].raiseSalary(10);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }
}
