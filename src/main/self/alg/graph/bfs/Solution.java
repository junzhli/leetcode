package self.alg.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        public Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v,int w)
        {
            adj[v].add(w);
        }
    }

    // refer to https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
    public void bfsUsingQueue(Graph g, int startV) {
        boolean[] visited = new boolean[g.V];

        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> adj[] = g.adj;
        visited[startV] = true;
        queue.add(startV);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println("v: " + v);

            LinkedList<Integer> adjacent = adj[v];
            for (int a: adjacent) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }



}
