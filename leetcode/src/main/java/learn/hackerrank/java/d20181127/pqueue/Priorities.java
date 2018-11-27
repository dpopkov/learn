package learn.hackerrank.java.d20181127.pqueue;

import java.util.ArrayList;
import java.util.List;

public class Priorities {
    public List<Student> getStudents(List<String> events) {
        java.util.PriorityQueue<Student> queue = new java.util.PriorityQueue<>(Student.getComparatorByGpaNameId());
        Student student;
        for (String event : events) {
            String[] tokens = event.split("\\s+");
            if ("ENTER".equals(tokens[0])) {
                double cgpa = Double.parseDouble(tokens[2]);
                int id = Integer.parseInt(tokens[3]);
                student = Student.create(id, tokens[1], cgpa);
                queue.add(student);
            } else {
                queue.poll();
            }
        }
        List<Student> result = new ArrayList<>();
        while ((student = queue.poll()) != null) {
            result.add(student);
        }
        return result;
    }
}
