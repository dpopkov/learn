package learn.ijpds2nd.ch10oop;

public class CourseUsage {
    public static void main(String[] args) {
        Course ds = new Course("Data Structures");
        Course db = new Course("Database Systems");
        ds.addStudent("Peter Jones");
        ds.addStudent("Kim Smith");
        ds.addStudent("Anne Kennedy");
        db.addStudent("Peter Jones");
        db.addStudent("Steve Smith");
        System.out.printf("Number of students in '%s': %d%n", ds.getName(), ds.getNumberOfStudents());
        for (String s : ds) {
            System.out.print(s + ", ");
        }
        System.out.println();
        String[] dbStudents = db.getStudents();
        System.out.printf("Number of students in '%s': %d%n", db.getName(), db.getNumberOfStudents());
        for (String s : dbStudents) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }
}
