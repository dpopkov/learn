package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Arrays;
import java.util.Comparator;

public class E0803GradeExam {

    public static void main(String[] args) {
        char[][] answers = {{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
        {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
        {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
        {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

        class Student {
            private final int id;
            private int score;

            public Student(int id) {
                this.id = id;
                score = 0;
            }

            public void incrementScore() {
                score++;
            }

            public int getScore() {
                return score;
            }

            @Override
            public String toString() {
                return "Student{id=" + id + ", score=" + score + '}';
            }
        }

        Student[] students = new Student[answers.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i);
        }

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j]) {
                    students[i].incrementScore();
                }
            }
        }
        Arrays.sort(students, Comparator.comparingInt(Student::getScore).reversed());
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
