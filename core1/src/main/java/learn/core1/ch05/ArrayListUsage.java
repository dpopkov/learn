package learn.core1.ch05;

import learn.core1.ch04.Employee;

import java.util.ArrayList;

/**
 * Demonstrates the ArrayList class.
 */
public class ArrayListUsage {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker", 75_000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50_000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40_000, 1990, 3, 15));

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.println(e);
        }

        EmployeeDB db = new EmployeeDB();
        db.warning();
        /* Do not do that! */
        db.update(staff);
        /*
        for (Employee e : staff) {  // java.lang.ClassCastException
            System.out.println(e);
        }
        */

        /* Do not do that! */
        @SuppressWarnings("unchecked")
        ArrayList<Employee> result = (ArrayList<Employee>)db.find("NotEmployee");
        System.out.println("Found " + result.size() + " query results. Do not look at it! It's dangerous!");
        /*
        for (Employee e : result) {     // java.lang.ClassCastException
            System.out.println(e);
        }
        */
    }

    /**
     * Wrong class for producing exceptions.
     */
    private static class EmployeeDB {
        private ArrayList list;

        @SuppressWarnings("unchecked")  // I need an exception
        void update(ArrayList list) {
            this.list = list;
            this.list.add("NotEmployee");
        }

        void warning() {
            System.out.println("Do not use EmployeeDB for Employees!");
        }

        @SuppressWarnings("unchecked")  // I need an exception
        ArrayList find(String query) {
            ArrayList result = new ArrayList();
            for (Object element : list) {
                if (element.toString().contains(query)) {
                    result.add(element);
                }
            }
            return result;
        }
    }
}
