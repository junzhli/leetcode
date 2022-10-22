package self.alg.directed_graph.shortest_path;

import java.util.*;

/**
 * Using bellman ford
 * o(V * E), V = number of vertices and E = number of edges
 * from source to all of nodes shortest path
 */
public class Bellman {
    static class Node {
        private String name;
        private int distance;

        Node(String name) {
            this.name = name;
            this.distance = Integer.MAX_VALUE;
        }

        public String getName() {
            return name;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }
    }

    static class Edge {
        String src;
        String dst;
        int weight;

        public Edge(String src, String dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        String getSrc() {
            return this.src;
        }

        String getDst() {
            return this.dst;
        }

        void setSrc(String src) {
            this.src = src;
        }

        void setDst(String dst) {
            this.dst = dst;
        }
    }

    static class Graph {
        int vertices;
        Edge[] edges;
        HashMap<String, Node> nodeMap;

        Graph(int vertices, Edge[] edges, HashMap<String, Node> nodeMap) {
            this.vertices = vertices;
            this.edges = edges;
            this.nodeMap = nodeMap;
        }

        public int getVertices() {
            return vertices;
        }

        public Edge[] getEdges() {
            return edges;
        }
    }

    public static void bellmanFord(Graph graph, Node source) {
        source.setDistance(0);

        for (int i = 0; i < graph.nodeMap.size(); i++) { // need t.c. o(V)
            int updateCounter = 0;
            for (Edge edge: graph.getEdges()) { // need t.c. o(E)
                Node srcNode = graph.nodeMap.get(edge.getSrc());
                Node dstNode = graph.nodeMap.get(edge.getDst());
                if (srcNode.getDistance() == Integer.MAX_VALUE) {
                    continue;
                }

                int assumption = srcNode.getDistance() + edge.getWeight();
                if (assumption < dstNode.getDistance()) {
                    dstNode.setDistance(assumption);
                    updateCounter += 1;
                }
            }

            if (updateCounter == 0) {
                System.out.println("since no change in the last iteration, we skip as all is ready, iterations = " + (i + 1));
                break;
            }
        }

        // optional: check if there's negative weight cycle
        for (Edge edge: graph.getEdges()) { // need t.c. o(E)
            Node srcNode = graph.nodeMap.get(edge.getSrc());
            Node dstNode = graph.nodeMap.get(edge.getDst());
            if (srcNode.getDistance() == Integer.MAX_VALUE) {
                continue;
            }

            int assumption = srcNode.getDistance() + edge.getWeight();
            if (assumption < dstNode.getDistance()) {
                System.out.println("Find negative weight cycle! " + srcNode.getName().toString() + " to " + dstNode.getName());
            }
        }
    }

    public static void main(String[] args) {
        Node s = new Node("S");
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        HashMap<String, Node> nodeMap = new HashMap<>();
        nodeMap.put("S", s);
        nodeMap.put("A", a);
        nodeMap.put("B", b);
        nodeMap.put("C", c);
        nodeMap.put("D", d);
        nodeMap.put("E", e);

        Edge e1 = new Edge("S", "A", 10);
        Edge e2 = new Edge("S", "E", 8);
        Edge e3 = new Edge("E", "D", 1);
        Edge e4 = new Edge("D", "A", -4);
        Edge e5 = new Edge("B", "A", 1);
        Edge e6 = new Edge("C", "B", -2);
        Edge e7 = new Edge("A", "C", 2);
        Edge e8 = new Edge("D", "C", 1);
        Edge[] edges = new Edge[]{e1,e2,e3,e4,e5,e6,e7,e8};

        Graph graph = new Graph(6, edges, nodeMap);
        bellmanFord(graph, s);

        for (Node node: graph.nodeMap.values()) {
            System.out.println(String.format("name = %s, distance = %s", node.getName(), node.getDistance()));
//            StringBuilder stringBuilder = new StringBuilder(String.format("Heading from node %s to shortest path: ", s.getName()));
//            for (Node pathNode: node.getShortestPath()) {
//                stringBuilder.append(pathNode.getName());
//            }
        }

    }
}
