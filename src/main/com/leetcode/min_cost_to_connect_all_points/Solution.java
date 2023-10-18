package com.leetcode.min_cost_to_connect_all_points;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    // Kruskal
    // Mainly focus on all edges in the graph
    // Step by step to consume the current lowest weight edge in the unsettled queue
    // To avoid cycles and revisiting node, we have to keep track of each parent of all visited vertices
    // t.c.
//    public int minCostConnectPoints(int[][] points) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[2] - o2[2];
//            }
//        });
//
//
//        // create all possible edges connecting each point
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                pq.offer(new int[] {i, j, getDistance(i, j, points)});
//            }
//        }
//
//
//        int[] parent = new int[points.length];
//        for (int i = 0; i < points.length; i++) {
//            parent[i] = i;
//        }
//        int cost = 0;
//
//        while (!pq.isEmpty()) {
//            int[] edge = pq.poll();
//            int x = edge[0];
//            int y = edge[1];
//            int distance = edge[2];
//
//            if (sameRoot(x, y, parent)) { // we got a cycle
//                continue;
//            }
//
//            union(x, y, parent);
//            cost += distance;
//
//        }
//
//        return cost;
//    }
//
//    private void union(int x, int y, int[] parent) {
//        int xR = findRoot(x, parent);
//        int yR = findRoot(y, parent);
//        parent[xR] = yR;
//    }
//
//    private boolean sameRoot(int x, int y, int[] parent) {
//        int xR = findRoot(x, parent);
//        int yR = findRoot(y, parent);
//        return xR == yR;
//    }
//
//    private int findRoot(int x, int[] parent) {
//        if (parent[x] == x) {
//            return x;
//        }
//
//        parent[x] = findRoot(parent[x], parent);
//        return parent[x];
//    }
//
//    private int getDistance(int x, int y, int[][] points) {
//        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
//    }



    // Prim algorithm
    // althrough we process with vertices, but we actually visit vertices based on currently collected adjs (edges) for all visited vertices
    // so we still have focus on collected edges in our iteractions
    // t.c. V (vertice) E (edge) ==> V log E
    public int minCostConnectPoints(int[][] points) {
        // int[] --> [0] x point [1] y point [2] distance between x and y
        // we assume x as the starting node, y as the adj of x
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        // select node 0 as starting point, it connects to any other node than itself
        for (int i = 1; i < points.length; i++) {
            pq.offer(new int[]{0, i, getDistance(0, i, points)});
        }

        int cost = 0;

        boolean[] visited = new boolean[points.length];
        visited[0] = true;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int x = edge[0];
            int y = edge[1];
            int distance = edge[2];

            if (visited[y]) {
                continue;
            }

            visited[y] = true;
            cost += distance;

            for (int i = 0; i < points.length; i++) {
                if (i == y) {
                    continue;
                }

                if (!visited[i]) {
                    pq.offer(new int[] {y, i, getDistance(y, i, points)});
                }
            }
        }

        return cost;
    }

    private int getDistance(int x, int y, int[][] points) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}
