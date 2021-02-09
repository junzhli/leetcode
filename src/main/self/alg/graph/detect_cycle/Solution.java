package self.alg.graph.detect_cycle;

import java.util.Arrays;

// Union find, Quick union: https://medium.com/@gxyou45/algorithm%E6%99%AE%E6%9E%97%E6%96%AF%E9%A0%93%E8%AA%B2%E7%A8%8B%E5%AD%B8%E7%BF%92%E7%AD%86%E8%A8%981-union-find-5af7911ca5ef
// Disjoint set, union find, quick union: https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/
public class Solution {
    static class Edge {
        int src, dst;

        public Edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    static class Graph {
        int vertices;
        int added;
        Edge[] edges;

        public Graph(int vertices, int edges) {
            this.vertices = vertices;
            this.edges = new Edge[edges];
            this.added = 0;
        }

        public void addEdge(int src, int dst) {
            if (added == this.edges.length) {
                throw new IllegalArgumentException("number of edges has exceeded the max size defined in constructor");
            }
            this.edges[added++] = new Edge(src, dst);
        }

        public boolean hasCycle() {
            int[] parent = new int[this.vertices];
            Arrays.fill(parent, -1);

            for (int i = 0; i < this.added; i++) {
                // make a union of two vertices if cycle is not detected
                int x = find(parent, this.edges[i].src);
                int y = find(parent, this.edges[i].dst);

                if (x == y && x != -1) {
                    return true;
                }
                union(parent, this.edges[i].src, this.edges[i].dst);
            }

            return false;
        }

        private int find(int[] parent, int x) {
            if (parent[x] == -1) {
                return parent[x];
            }

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

    public static void main(String[] args) {
        Graph g = new Graph(10, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

        if (g.hasCycle()) {
            System.out.println("Contain cycle");
        } else {
            System.out.println("Contain no cycle");
        }
    }
}
