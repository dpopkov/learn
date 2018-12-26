/*
A level-order traversal, also known as a breadth-first search,
visits each level of a tree's nodes from left to right, top to bottom.
You are given a pointer, , pointing to the root of a binary search tree.
Complete the levelOrder function provided in your editor so that it
prints the level-order traversal of the binary search tree.
 */
package learn.hackerrank.java.days30.d23;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BstLevelOrder {
    public static void main(String[] args) {
        Solution.main(args);
    }
}

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    static void levelOrder(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node n = queue.remove();
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
                System.out.print(n.data + " ");
            }
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data <= root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}
