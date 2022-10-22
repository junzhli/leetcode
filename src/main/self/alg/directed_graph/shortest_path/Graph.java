package self.alg.directed_graph.shortest_path;

import java.util.HashSet;

public class Graph {
    private HashSet<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public HashSet<Node> getNodes() {
        return this.nodes;
    }

}
