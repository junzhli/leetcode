package self.alg.graph.directedCycle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class Vertex {
        private String label;
        private boolean beingVisited;
        private boolean visited;


        private List<Vertex> adjacencyList; //

        public Vertex(String label) {
            this.label = label;
            this.adjacencyList = new ArrayList<>();
        }

        public void addNeighbor(Vertex adjacent) {
            this.adjacencyList.add(adjacent);
        }

        public boolean isBeingVisited() {
            return beingVisited;
        }

        public void setBeingVisited(boolean beingVisited) {
            this.beingVisited = beingVisited;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public List<Vertex> getAdjacencyList() {
            return adjacencyList;
        }
    }

    public class Graph {
        private List<Vertex> vertices;

        public Graph() {
            this.vertices = new ArrayList<>();
        }

        public void addVertex(Vertex v) {
            vertices.add(v);
        }

        public void addEdge(Vertex from, Vertex to) {
            from.addNeighbor(to);
        }
    }

    public boolean hasCycle(Graph g) {
        if (g == null) {
            return false;
        }

        List<Vertex> vertices = g.vertices;
        for (Vertex v: vertices) {
            if (helper(v)) {
                return true;
            }
        }

        return false;
    }

    private boolean helper(Vertex vertex) {
        vertex.setBeingVisited(true);

        for (Vertex adj: vertex.adjacencyList) {
            if (adj.isBeingVisited()) {
                return true;
            } else if (adj.isVisited() && helper(adj)) {
                return true;
            }
        }


        vertex.setBeingVisited(false);
        vertex.setVisited(true);
        return false;
    }

    /**
     * follow up: use bfs to detect cycles
     * refer to: ../../com/leetcode/course_schedule
     */
}
