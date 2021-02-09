package self.alg.graph.mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    // Kruskal's algorithm
    // Plam's algorithm
    // https://www.statisticshowto.com/minimum-spanning-tree/

    static class Graph {
        // Edge to represent an edge between two vertices
        static class Edge implements Comparable<Edge> {
            int src;
            int dst;
            int weight;

            @Override
            public int compareTo(Edge o) {
                return this.weight - o.weight;
            }
        }
    }

    public static void main(String[] args) {
        // Create edges and push them into pQueue
        PriorityQueue<Graph.Edge> pQueue = new PriorityQueue<>();
        // add edge 0-1
        Graph.Edge e1 = new Graph.Edge();
        e1.src = 0;
        e1.dst = 1;
        e1.weight = 10;

        // add edge 0-2
        Graph.Edge e2 = new Graph.Edge();
        e2.src = 0;
        e2.dst = 2;
        e2.weight = 6;

        // add edge 0-3
        Graph.Edge e3 = new Graph.Edge();
        e3.src = 0;
        e3.dst = 3;
        e3.weight = 5;

        // add edge 1-3
        Graph.Edge e4 = new Graph.Edge();
        e4.src = 1;
        e4.dst = 3;
        e4.weight = 15;

        // add edge 2-3
        Graph.Edge e5 = new Graph.Edge();
        e5.src = 2;
        e5.dst = 3;
        e5.weight = 4;

        pQueue.add(e1);
        pQueue.add(e2);
        pQueue.add(e3);
        pQueue.add(e4);
        pQueue.add(e5);

        List<Graph.Edge> edges = new ArrayList<>();
        while (!pQueue.isEmpty()) {
            Graph.Edge e = pQueue.poll();
            edges.add(e);
            if (detectCycle(edges)) {
                edges.remove(e);
            }
        }

        // print out each edge in MST
        for (Graph.Edge e: edges) {
            System.out.println("Edge: " + e.src + " --> " + e.dst + " | weight: " + e.weight);
        }
    }

    private static boolean detectCycle(List<Graph.Edge> edges) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Graph.Edge e: edges) {
            int srcRoot = find(hashMap, e.src);
            int dstRoot = find(hashMap, e.dst);

            if (srcRoot == dstRoot) {
                return true;
            }

            union(hashMap, e.src, e.dst);
        }

        return false;
    }

    private static int find(HashMap<Integer, Integer> hashMap, int vertex) {
        if (hashMap.getOrDefault(vertex, vertex) == vertex) {
            return vertex;
        }

        return find(hashMap, hashMap.get(vertex));
    }

    private static void union(HashMap<Integer, Integer> hashMap, int xVertex, int yVertex) {
        int xRoot = find(hashMap, xVertex);
        int yRoot = find(hashMap, yVertex);

        if (xRoot == yRoot) {
            return;
        }
        hashMap.put(xRoot, yRoot);
    }


}
