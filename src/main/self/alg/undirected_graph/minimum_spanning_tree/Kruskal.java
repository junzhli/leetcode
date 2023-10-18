package self.alg.undirected_graph.minimum_spanning_tree;

import self.alg.union_find.DetectCycle;

import java.util.*;

public class Kruskal {
    static class Edge {
        int src;
        int dst;
        int weight = 4;
        Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    static HashSet<Edge> kruskal(Edge[] edges, int vertices) {
        PriorityQueue<Edge> sortedQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });
        sortedQueue.addAll(new ArrayList<>(Arrays.asList(edges)));

        int[] parent = new int[vertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        HashSet<Edge> settledEdges = new HashSet<>();
        while(!sortedQueue.isEmpty()) {
            Edge minWeightEdge = sortedQueue.poll();
            System.out.println("Min weight edge: " + minWeightEdge.weight);
//            union(parent, minWeightEdge.src, minWeightEdge.dst);
            int rootSrc = findRoot(parent, minWeightEdge.src);
            int rootDst = findRoot(parent, minWeightEdge.dst);
            if (rootSrc == rootDst) { // detect cycle
                continue;
            }
//            if (detectCycle(parent, settledEdges, vertices)) {
//                continue;
//            }
            settledEdges.add(minWeightEdge);
            union(parent, minWeightEdge.src, minWeightEdge.dst);
        }

        return settledEdges;
    }

    public static boolean detectCycle(int[] parent, HashSet<Edge> edges, int vertices) {
        for (Edge e: edges) {
            if (findRoot(parent, e.src) == findRoot(parent, e.dst)) {
                return true;
            }
            union(parent, e.src, e.dst);
        }

        return false;
    }

    static int findRoot(int[] parent, int x) {
        if (parent[x] == x) {
            return parent[x];
        }

        parent[x] = findRoot(parent, parent[x]); // using union by rank/height, t.c. improved to o (log n)
        return parent[x];
    }

    static void union(int[] parent, int x, int y) {
        int xRoot = findRoot(parent, x);
        int yRoot = findRoot(parent, y);

        parent[xRoot] = yRoot;
    }

    public static void main(String[] args) {
        Edge edge0 = new Edge(0, 1, 4);
        Edge edge1 = new Edge(1, 2, 8);
        Edge edge2 = new Edge(1, 7, 11);
        Edge edge3 = new Edge(0, 7, 8);
        Edge edge4 = new Edge(1, 2, 8);
        Edge edge5 = new Edge(2, 8, 2);
        Edge edge6 = new Edge(8, 6, 6);
        Edge edge7 = new Edge(8, 7, 7);
        Edge edge8 = new Edge(7, 6, 1);
        Edge edge9 = new Edge(6, 5, 2);
        Edge edge10 = new Edge(5, 2, 4);
        Edge edge11 = new Edge(2, 3, 7);
        Edge edge12 = new Edge(3, 5, 14);
        Edge edge13 = new Edge(5, 4, 10);
        Edge edge14 = new Edge(4, 3, 9);
        List<Edge> edgesList = List.of(edge0, edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10, edge11, edge12, edge13, edge14);
        // https://devqa.io/convert-list-to-array-in-java/
        Edge[] edges = edgesList.toArray(new Edge[edgesList.size()]);
        HashSet<Edge> mst = kruskal(edges, 9);

        for (Edge e: edges) {
            System.out.println(String.format("%d <-> %d, weight = %d", e.src, e.dst, e.weight));
        }
    }

}
