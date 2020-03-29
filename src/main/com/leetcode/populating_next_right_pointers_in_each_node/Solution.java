package com.leetcode.populating_next_right_pointers_in_each_node;

import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

//        int depth = getDepth(root);
        Node curr = root;
        for (int i = 0; curr != null; i++, curr = curr.left) {
            LinkedList<Node> nodesSeq = new LinkedList<>();
            getLevelNodesInRevOrder(root, i, nodesSeq);
            Node prev = null;
            for (Node n: nodesSeq) {
                if (prev == null) {
                    prev = n;
                    continue;
                }

                n.next = prev;
                prev = n;
            }
        }

        return root;
    }

//    private int getDepth(Node node) {
//        if (node == null) {
//            return 0;
//        }
//
//        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
//    }

    private void getLevelNodesInRevOrder(Node node, int level, LinkedList<Node> res) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            res.add(node);
        }

        getLevelNodesInRevOrder(node.right, level - 1, res);
        getLevelNodesInRevOrder(node.left, level - 1, res);
    }
}
