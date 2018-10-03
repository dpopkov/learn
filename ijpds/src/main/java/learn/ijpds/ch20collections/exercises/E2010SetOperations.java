/* 20.10
Perform set operations on priority queues.
Given two stacks of subjects, find the subjects that are
1) only present in the first stack;
2) only present in the second stack;
3) present in both stacks.
 */
package learn.ijpds.ch20collections.exercises;

import java.util.*;

public class E2010SetOperations {
    public static void main(String[] args) {
        Deque<String> st1 = new ArrayDeque<>();
        st1.push("Chemistry");
        st1.push("Mathematics");
        st1.push("Biology");
        st1.push("English");
        Deque<String> st2 = new ArrayDeque<>();
        st2.push("Biology");
        st2.push("English");
        st2.push("Geography");
        st2.push("Physics");

        List<String> in1st = new ArrayList<>();
        List<String> in2nd = new ArrayList<>();
        List<String> inBoth = new ArrayList<>();

        PriorityQueue<String> q1 = new PriorityQueue<>(st1);
        PriorityQueue<String> q2 = new PriorityQueue<>(st2);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            classify(q1, q2, in1st, in2nd, inBoth);
        }
        System.out.println("In 1st:");
        System.out.println(in1st);
        System.out.println("In 2nd:");
        System.out.println(in2nd);
        System.out.println("In both:");
        System.out.println(inBoth);
    }

    private static void classify(PriorityQueue<String> q1, PriorityQueue<String> q2,
                                 List<String> in1st, List<String> in2nd, List<String> inBoth) {
        String s1 = q1.peek();
        String s2 = q2.peek();
        if (s1 == null && s2 != null) {
            in2nd.add(s2);
            q2.poll();
        } else if (s1 != null && s2 == null) {
            in1st.add(s1);
            q1.poll();
        } else if (s1 != null) {
            if (s1.compareTo(s2) < 0) {
                in1st.add(s1);
                q1.poll();
            } else if (s1.compareTo(s2) > 0) {
                in2nd.add(s2);
                q2.poll();
            } else {
                inBoth.add(s1);
                q1.poll();
                q2.poll();
            }
        }
    }
}
