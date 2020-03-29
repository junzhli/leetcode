package self.alg.graph.dfs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static class Node {
        public int val;
        public boolean visited;
        public List<Node> neighborhoods;

        public Node(int val) {
            this.val = val;
            this.visited = false;
            this.neighborhoods = new ArrayList<>();
        }

        public void addNeighbors(Node n) {
            this.neighborhoods.add(n);
        }
    }

    public void dfsUsingRecursion(Node n) {
        System.out.println("node: " + n.val);
        n.visited = true;
        for (Node subN: n.neighborhoods) {
            if (!subN.visited) {
                dfsUsingRecursion(subN);
            }
        }
    }

    public void dfsUsingIteration(Node n) {
        Stack<Node> stack = new Stack<>();
        stack.push(n);

        while (!stack.empty()) {
            Node nd = stack.pop();
            // !must!: this case happens when an element is got pushed into stack twice due to its unvisited state
            // ignore the one who has visited once, just pop it out
            if (!nd.visited) {
                System.out.println("node: " + nd.val);
                nd.visited = true;
            }

            for (Node subN: nd.neighborhoods) {
                if (!subN.visited) {
                    stack.push(subN);
                }

            }
        }
    }
}
