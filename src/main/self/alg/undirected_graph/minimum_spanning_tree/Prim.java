package self.alg.undirected_graph.minimum_spanning_tree;

import java.util.*;
import java.util.stream.Collectors;

public class Prim {
    static class Node {
        int name;
        Edge minEdge;
        List<Edge> adjacentEdges;

        Node(int name) {
            this.name = name;
            this.minEdge = null;
            this.adjacentEdges = new ArrayList<>();
        }

        void addEdge(Edge edge) {
            adjacentEdges.add(edge);
        }
    }

    static class Edge {
        Node src;
        Node dst;
        int weight;

        public Edge(Node src, Node dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
            if (src != null) {
                src.addEdge(this);
            }
            if (dst != null) {
                dst.addEdge(this);
            }
        }
    }

    static void prim(Node sourceNode, HashMap<Integer, Node> nodeMap) {
        Edge zeroEdge = new Edge(null, null, 0);
        PriorityQueue<Node> unsettledNodes = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.minEdge == zeroEdge) {
                    return Integer.MIN_VALUE;
                }
                if (o2.minEdge == zeroEdge) {
                    return Integer.MIN_VALUE;
                }

                return o1.minEdge.weight - o2.minEdge.weight;
            }
        });
        HashSet<Node> settledNodes = new HashSet<>();

        if (nodeMap.size() == 0) {
            return;
        }

        // put sourceNode in priorityQueue
        sourceNode.minEdge = zeroEdge;
        unsettledNodes.offer(sourceNode);

        while (!unsettledNodes.isEmpty()) {
            Node nodeWithMinPath = unsettledNodes.poll();
            int weight = (nodeWithMinPath.minEdge != null) ? nodeWithMinPath.minEdge.weight : -1;
            System.out.println(String.format("Node %d to be added from edge %d", nodeWithMinPath.name, weight));
            settledNodes.add(nodeWithMinPath);
            for (Edge adjEdge: nodeWithMinPath.adjacentEdges) {
                if (adjEdge.dst != nodeWithMinPath) {
                    // dst is target
                    if (settledNodes.contains(adjEdge.dst)) {
                        continue;
                    }
                    if (unsettledNodes.contains(adjEdge.dst)) {
                        unsettledNodes.remove(adjEdge.dst);
                    }
                    adjEdge.dst.minEdge = adjEdge;
                    unsettledNodes.offer(adjEdge.dst);
                } else {
                    if (settledNodes.contains(adjEdge.src)) {
                        continue;
                    }
                    if (unsettledNodes.contains(adjEdge.src)) {
                        unsettledNodes.remove(adjEdge.src);
                    }
                    adjEdge.src.minEdge = adjEdge;
                    unsettledNodes.offer(adjEdge.src);
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Edge e0 = new Edge(node0, node1, 4);
        Edge e1 = new Edge(node0, node7, 8);
        Edge e2 = new Edge(node1, node7, 11);
        Edge e3 = new Edge(node1, node2, 8);
        Edge e4 = new Edge(node7, node8, 7);
        Edge e5 = new Edge(node8, node6, 6);
        Edge e6 = new Edge(node7, node6, 1);
        Edge e7 = new Edge(node2, node3, 7);
        Edge e8 = new Edge(node2, node8, 2);
        Edge e9 = new Edge(node6, node5, 2);
        Edge e10 = new Edge(node2, node5, 4);
        Edge e11 = new Edge(node3, node5, 14);
        Edge e12 = new Edge(node3, node4, 9);
        Edge e13 = new Edge(node5, node4, 10);

        nodeMap.put(0, node0);
        nodeMap.put(1, node1);
        nodeMap.put(2, node2);
        nodeMap.put(3, node3);
        nodeMap.put(4, node4);
        nodeMap.put(5, node5);
        nodeMap.put(6, node6);
        nodeMap.put(7, node7);
        nodeMap.put(8, node8);


        prim(node0, nodeMap);
        for (Map.Entry<Integer, Node> entry: nodeMap.entrySet()) {
            int weight = (entry.getValue().minEdge != null) ? entry.getValue().minEdge.weight : -1;
            System.out.println(String.format("Node %d with edge %d", entry.getKey(), weight));
        }
    }
}
