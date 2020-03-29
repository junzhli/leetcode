package com.leetcode.copy_list_with_random_pointer;

import java.util.*;

public class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap<>(); // Mapping table: ori -> copy-ori
        Node n = head;

        // 1. create copies without next and random-pointer
        while (n != null) {
            nodeMap.put(n, new Node(n.val));
            n = n.next;
        }

        // 2. assign next and random-pointer
        n = head;
        while (n != null) {
            Node _n = nodeMap.get(n);
            _n.next = nodeMap.get(n.next);
            _n.random = nodeMap.get(n.random);
            n = n.next;
        }

        return nodeMap.get(head);
    }
}
