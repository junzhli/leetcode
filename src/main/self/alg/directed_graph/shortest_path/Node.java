package self.alg.directed_graph.shortest_path;

import java.util.HashMap;
import java.util.LinkedList;

public class Node {
    private HashMap<Node, Integer> adjacentNodes = new HashMap<>();
    private String name;
    private int shortestDistance = Integer.MAX_VALUE; // init value set to infinite
    private LinkedList<Node> shortestPath = new LinkedList<>(); // to record the path heading from source to this node

    public Node(String name) {
        this.name = name;
    }

    private void addDestinationNode(Node node, int distance) {
        this.adjacentNodes.putIfAbsent(node, distance);
    }

    public Integer getDistanceByDestinationNode(Node node) {
        if (adjacentNodes.containsKey(node)) {
            return adjacentNodes.get(node);
        }
        return null;
    }

    public void addDestination(Node destinationNode, int distance) {
        adjacentNodes.put(destinationNode, distance);
    }

    public HashMap<Node, Integer> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    public String getName() {
        return name;
    }

    public int getShortestDistance() {
        return shortestDistance;
    }

    public void setShortestDistance(int distance) {
        shortestDistance = distance;
    }

    public LinkedList<Node> getShortestPath() {
        return shortestPath;
    }

    public void addNodeToShortestPath(Node node) {
        this.shortestPath.add(node);
    }
}
