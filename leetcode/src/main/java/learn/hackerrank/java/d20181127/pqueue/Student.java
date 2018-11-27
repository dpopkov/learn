package learn.hackerrank.java.d20181127.pqueue;

public class Student {
    private int id;
    private String name;
    /** Cumulative Grade Point Average (CGPA). */
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    public static Student create(int id, String name, double cgpa) {
        return new Student(id, name, cgpa);
    }

    public static java.util.Comparator<Student> getComparatorByGpaNameId() {
        return new ComparatorByGpaNameId();
    }

    private static class ComparatorByGpaNameId implements java.util.Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int rst = Double.compare(s2.getCGPA(), s1.getCGPA());
            if (rst != 0) {
                return rst;
            }
            rst = s1.getName().compareTo(s2.getName());
            if (rst != 0) {
                return rst;
            }
            return Integer.compare(s1.getID(), s2.getID());
        }
    }
}
