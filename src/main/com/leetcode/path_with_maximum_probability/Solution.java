package com.leetcode.path_with_maximum_probability;

import java.util.*;

// https://leetcode.com/problems/path-with-maximum-probability/description/
public class Solution {
    // dijkstra algo. is mainly used to find ALL shortest path from source to destinationS
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] max = new double[n];
        int[] parent = new int[n];
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(parent, Integer.MIN_VALUE);

        // add all adjs to vertices
        HashMap<Integer, List<int[]>> adjs = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            int src= e[0];
            int dst = e[1];
            List<int[]> srcL;
            List<int[]> dstL;

            srcL = adjs.getOrDefault(src, new ArrayList<>());
            int[] item = new int[]{src, dst, i};
            srcL.add(item);
            adjs.putIfAbsent(src, srcL);

            dstL = adjs.getOrDefault(dst, new ArrayList<>());
            int[] item2 = new int[]{dst, src, i};
            dstL.add(item2);
            adjs.putIfAbsent(dst, dstL);
        }

        // use priority queue to sort in accending order by its min value
        // simple queue is not feasible due to the reason that it has to traverse all adjs of current node instead of getting to the one that could make us get to end sooner
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Double.compare(max[i2],max[i1]);
            }
        });

        // start with start_node, set min 0 to itself
        max[start_node] = 1;
        queue.offer(start_node);

        // won't visit visited node, visited node already included in result
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr]) {
                continue;
            }

            if (curr == end_node) {
                break;
            }

            HashSet<Integer> nexts = new HashSet<>();

            List<int[]> adj = adjs.getOrDefault(curr, new ArrayList<>());
            for (int[] a: adj) {
                int dst = a[1];
                if (visited[dst]) {
                    continue;
                }

                double weight = succProb[a[2]];
                double newDistance = max[curr] * weight;
                if (newDistance > max[dst]) {
                    max[dst] = newDistance;
                    parent[dst] = curr;
                    nexts.add(dst);
                }
            }

            for (Integer next: nexts) {
                queue.remove(next);
                queue.offer(next);
            }

            visited[curr] = true;
        }

        if (max[end_node] == Integer.MIN_VALUE) {
            return 0.0;
        }
        return max[end_node];
    }
}
