package com.leetcode.minimum_height_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/minimum-height-trees/submissions/986586328/
// t.c. o(n)
// t.c. o(n)

// follow up: https://www.geeksforgeeks.org/longest-path-in-a-directed-acyclic-graph-dynamic-programming/
public class Solution {
    class Node {
        int val;
        List<Node> adjacent;

        Node(int val) {
            this.val = val;
            this.adjacent = new ArrayList<>();
        }

        void add(Node node) {
            this.adjacent.add(node);
        }
    }

    // handle edges, e.g. with only one node, two nodes connected
    // to find the middle nodes, we have to leave at least two nodes unvisited
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0 || n == 1) {
            return Arrays.asList(0);
        }

        if (n == 2) {
            return Arrays.asList(0,1);
        }

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        // calculate innodes, to disconnect each other later, mainly used to detect leaves in the first place
        int[] innodes = new int[n];

        for (int[] e: edges) {
            Node a = nodes[e[0]];
            Node b = nodes[e[1]];
            a.add(b);
            b.add(a);
            innodes[a.val]++;
            innodes[b.val]++;
        }

        // push all leaves to queue, assume there's no cycle, we are gonna operate through queue at max n times, the remaining nodes in queue are all middle nodes, which are the answers
        ArrayDeque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (innodes[i] == 1) {
                deque.offer(nodes[i]);
            }
        }

        while (n > 2) {
            int processed = deque.size(); // leaves, indicates we'll start visiting leaf nodes and leave the last two nodes which are middle nodes in the longest path

            n = n - processed;

            while(!deque.isEmpty() && processed > 0) {
                Node node = deque.poll();
                processed--;

                for (Node adj: node.adjacent) {

                    innodes[adj.val]--;

                    if (innodes[adj.val] == 1) {
                        deque.offer(nodes[adj.val]);
                    }
                }
            }
        }


        ArrayList<Integer> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            res.add(deque.pop().val);
        }
        return res;
    }
}
