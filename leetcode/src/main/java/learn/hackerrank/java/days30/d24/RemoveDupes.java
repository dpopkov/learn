package learn.hackerrank.java.days30.d24;

import java.util.Scanner;

/*
A removeDuplicates function is declared in your editor, which takes a pointer
to the  node of a linked list as a parameter.
Complete removeDuplicates so that it deletes any duplicate nodes from the list
and returns the head of the updated list.
 */
public class RemoveDupes {
    public static void main(String[] args) {
        Solution.main(args);
    }
}

class Node {
    final int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public static Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        Node n = head;
        while (n.next != null) {
            boolean duplicate = false;
            Node c = head;
            while (c != n.next) {
                if (c.data == n.next.data) {
                    duplicate = true;
                    break;
                } else {
                    c = c.next;
                }
            }
            if (duplicate) {
                Node dupe = n.next;
                n.next = dupe.next;
                dupe.next = null;
            } else {
                n = n.next;
            }
        }
        return head;
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null) {
            head = p;
        } else if (head.next == null) {
            head.next = p;
        } else {
            Node start = head;
            while (start.next != null) {
                start = start.next;
            }
            start.next = p;
        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);
    }
}