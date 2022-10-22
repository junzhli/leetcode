package self.alg.directed_graph.shortest_path;

import java.util.HashSet;
import java.util.Map;

/**
 * Use dijkstra algorithm to solve the shortest problem:
 * * can be used in directed graph and undirected graph
 * * this one illustrates the approach to address directed one
 * * [from source to the shortest path for all nodes (don't support negative weight)
 * t.c. o(e +vlogv) --> v * logv (priority queue to keep unsettled vertices) + e (to process each adj in vertex)
 */
public class Dijkstra {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        Graph result = getShortestPath(graph, nodeA);
        for (Node node: result.getNodes()) {
            System.out.println(String.format("name = %s, distance = %s", node.getName(), node.getShortestDistance()));
            StringBuilder stringBuilder = new StringBuilder(String.format("Heading from node %s to shortest path: ", nodeA.getName()));
            for (Node pathNode: node.getShortestPath()) {
                stringBuilder.append(pathNode.getName());
            }
        }
    }


    public static Graph getShortestPath(Graph graph, Node source) {
        source.setShortestDistance(0); // set source shortest distance = 0

        HashSet<Node> settledNodes = new HashSet<>();
        HashSet<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node lowestDistanceNode = findLowestDistanceNode(unsettledNodes); // can be replaced by priority queue (improve t.c. to log n)
            unsettledNodes.remove(lowestDistanceNode);
            for (Map.Entry<Node, Integer> entry: lowestDistanceNode.getAdjacentNodes().entrySet()) {
                Node adjNode = entry.getKey();
                int adjDistance = entry.getValue();
                if (!settledNodes.contains(adjNode)) {
                    int currentShortestDistance = calculateShortestDistanceFromSource(lowestDistanceNode, adjDistance, adjNode);
                    adjNode.setShortestDistance(currentShortestDistance);
                    unsettledNodes.add(adjNode);
                }
            }
            settledNodes.add(lowestDistanceNode);
        }

        return graph;
    }

    /**
     * Using priority queue to keep all unsettled nodes (initialized with all nodes) --> V * logV
     * PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
     *             @Override
     *             public int compare(Node o1, Node o2) {
     *                 return o1.distance - o2.distance;
     *             }
     *         });
     * @param nodeSet
     * @return
     */

    private static Node findLowestDistanceNode(HashSet<Node> nodeSet) {
        Node result = null;
        for (Node node: nodeSet) {
            if (result == null) {
                result = node;
                continue;
            }
            if (result.getShortestDistance() > node.getShortestDistance()) {
                result = node;
            }
        }
        return result;
    }

    private static int calculateShortestDistanceFromSource(Node sourceNode, int adjDistance, Node targetNode) {
        int currentShortestDistance = sourceNode.getShortestDistance();
        int result = targetNode.getShortestDistance();
        if (currentShortestDistance + adjDistance < result) {
            result = currentShortestDistance + adjDistance;
            targetNode.addNodeToShortestPath(sourceNode);
        }
        return result;
    }

}
