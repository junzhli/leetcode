package com.leetcode.friend_circles;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    // grouping problem: union find, linking to the same parent indicates the same group.
    // Union find problem: use Quick union (by linking two roots of nodes, setting one of root of node as another one's root
    // follow up: use Quick find (by connecting two nodes and changing all node's parent having one of these two nodes
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        for (int i = 0; i <parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i > j || M[i][j] == 0) {
                    continue;
                }

                union(parent, i , j);
            }
        }

        int res = 0;
        HashSet<Integer> group = new HashSet<>();
        for (int p: parent) {
            int root = find(parent, p);
            if (group.contains(root)) {
                continue;
            }

            res += 1;
            group.add(root);
        }

        return res;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return parent[x];
        }

        return find(parent, parent[x]);
    }

    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        parent[xRoot] = yRoot;
    }
}
