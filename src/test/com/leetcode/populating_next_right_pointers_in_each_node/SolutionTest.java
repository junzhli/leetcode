package com.leetcode.populating_next_right_pointers_in_each_node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void connect() {
        Solution sol = new Solution();
        Node leftSubT = new Node(2, new Node(4), new Node(5), null);
        Node rightSubT = new Node(3, new Node(6), new Node(7), null);
        Node root = new Node(1, leftSubT, rightSubT, null);
        sol.connect(root);
        printLevelNodes(root);
    }

    private void printLevelNodes(Node root) {
        Node curr = root;
        while (curr != null) {
            Node curr2 = curr;
            while (curr2 != null) {
                System.out.println(curr2.val);
                curr2 = curr2.next;
            }
            System.out.println("#");
            curr = curr.left;
        }
    }
}