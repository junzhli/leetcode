package self.alg.graph.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void dfsUsingRecursion() {
        Solution sol = new Solution();
        Solution.Node node40 =new Solution.Node(40);
        Solution.Node node10 =new Solution.Node(10);
        Solution.Node node20 =new Solution.Node(20);
        Solution.Node node30 =new Solution.Node(30);
        Solution.Node node60 =new Solution.Node(60);
        Solution.Node node50 =new Solution.Node(50);
        Solution.Node node70 =new Solution.Node(70);

        node40.addNeighbors(node10);
        node40.addNeighbors(node20);
        node10.addNeighbors(node30);
        node20.addNeighbors(node10);
        node20.addNeighbors(node30);
        node20.addNeighbors(node60);
        node20.addNeighbors(node50);
        node30.addNeighbors(node60);
        node60.addNeighbors(node70);
        node50.addNeighbors(node70);

        sol.dfsUsingRecursion(node40);
    }

    @Test
    void dfsUsingIteration() {
        Solution sol = new Solution();
        Solution.Node node40 =new Solution.Node(40);
        Solution.Node node10 =new Solution.Node(10);
        Solution.Node node20 =new Solution.Node(20);
        Solution.Node node30 =new Solution.Node(30);
        Solution.Node node60 =new Solution.Node(60);
        Solution.Node node50 =new Solution.Node(50);
        Solution.Node node70 =new Solution.Node(70);

        node40.addNeighbors(node10);
        node40.addNeighbors(node20);
        node10.addNeighbors(node30);
        node20.addNeighbors(node10);
        node20.addNeighbors(node30);
        node20.addNeighbors(node60);
        node20.addNeighbors(node50);
        node30.addNeighbors(node60);
        node60.addNeighbors(node70);
        node50.addNeighbors(node70);

        sol.dfsUsingIteration(node40);
    }
}