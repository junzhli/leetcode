package self.alg.undirected_graph.shortest_path;

import java.util.*;

// undirected shortest path problem --> dijkstra
// edit: ?? should move to directed
public class Dijkstra {
    static class Node {
        char val;
        List<Edge> edges;
        int path;
        boolean marked;

        Node(char val) {
            this.val = val;
            this.edges = new ArrayList<>();
            this.path = Integer.MAX_VALUE;
            this.marked = false;
        }
    }

    static class Edge {
        Node source;
        Node destination;
        int weight;

        Edge(Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // build a graph
        List<Node> nodes = new ArrayList<>();
        Node a = new Node('a');
        Node b = new Node('b');
        addEdge(a, b, 3);
        Node c = new Node('c');
        addEdge(b, c, 7);
        addEdge(a, c, 1);
        Node d = new Node('d');
        addEdge(b, d, 5);
        addEdge(c, d, 2);
        Node e = new Node ('e');
        addEdge(b, e, 1);
        addEdge(d, e, 7);
        nodes.add(c);
        nodes.add(b);
        nodes.add(a);
        nodes.add(d);
        nodes.add(e);

        dijkstra(nodes);
        for (Node n: nodes) {
            System.out.println("n: " + n.val + " -> path: " + n.path);
        }

    }

    private static void dijkstra(List<Node> nodes) {
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.path - o2.path;
            }
        });
        q.offer(nodes.get(0));
        Node first = q.peek();
        first.path = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.marked) {
                continue;
            }

            for (Edge e: node.edges) {
                if (e.destination.marked) {
                    continue;
                }

                e.destination.path = Math.min(e.destination.path, node.path + e.weight);
                q.offer(e.destination);
            }

            node.marked = true;
        }
    }

    private static void addEdge(Node a, Node b, int weight) {
        Edge edgeFrom = new Edge(a, b, weight);
        Edge edgeTo = new Edge(b, a, weight);
        a.edges.add(edgeFrom);
        b.edges.add(edgeTo);
    }
}
