package self.alg.binary_tree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * dfs
 *
 * Depth First Traversals:
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 *
 * refer to https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 *
 */
public class Solution {
    /**
     * traversal of binary trees through dfs using recursion
     */

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    /**
     * using iteration with the help of stack
     *
     */

    public void binaryTreeInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.val);

            curr = curr.right;
        }
    }

    public void binaryTreePreOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                System.out.println(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }

                curr = curr.left;
            }

            if (stack.size() > 0) {
                curr = stack.pop();
            }
        }
    }

    public void binaryTreePostOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (true) {
            if (curr != null) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                stack.push(curr);
                curr = curr.left;
                continue;
            }

            if (stack.empty()) {
                return;
            }
            curr = stack.pop();
            if (curr.right != null && stack.size() > 0 && curr.right == stack.peek()) {
                stack.pop();
                stack.push(curr);
                curr = curr.right;
            } else {
                System.out.println(curr.val);
                curr = null;
            }
        }
    }

    /**
     * using recursion
     */

//    public void binaryTreeInOrder(Node n) {
//        if (n == null) {
//            return;
//        }
//
//        binaryTreeInOrder(n.left);
//        System.out.println(n.val);
//        binaryTreeInOrder(n.right);
//    }
//
//    public void binaryTreePreOrder(Node n) {
//        if (n == null) {
//            return;
//        }
//
//        System.out.println(n.val);
//        binaryTreePreOrder(n.left);
//        binaryTreePreOrder(n.right);
//    }
//
//    public void binaryTreePostOrder(Node n) {
//        if (n == null) {
//            return;
//        }
//
//        binaryTreePostOrder(n.left);
//        binaryTreePostOrder(n.right);
//        System.out.println(n.val);
//    }
}
