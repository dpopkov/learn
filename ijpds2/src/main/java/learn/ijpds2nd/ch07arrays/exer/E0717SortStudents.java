package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

import java.util.Arrays;

public class E0717SortStudents {
    private static class Student implements Comparable<Student> {
        private final String name;
        private final int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public static Student of(String name, int score) {
            return new Student(name, score);
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.score, other.score);
        }

        @Override
        public String toString() {
            return "Student{" + name + ", " + score + '}';
        }
    }

    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int n = in.requestInt("Enter number of students");
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter name and score of student #%d: ", i);
            String name = in.next();
            int score = in.nextInt();
            students[i] = Student.of(name, score);
        }
        Arrays.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
