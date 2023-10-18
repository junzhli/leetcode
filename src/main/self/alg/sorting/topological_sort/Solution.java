package self.alg.sorting.topological_sort;

import utils.Array;

import java.util.*;
//Used in DAG, cycle detection, dep resolution, deadlock detection...
//Will terminate when cycle detected
//===
// directed graph!!! --> shortest path problem
// https://www.geeksforgeeks.org/topological-sorting/
// good article to metaphor: https://efficientcodeblog.wordpress.com/2017/11/28/topological-sort-dfs-bfs-and-dag/
// dfs vs bfs https://open4tech.com/bfs-vs-dfs/
// bfs will traverse every node at fixed depth and enqueue them into queue before proceeding to next level
// dfs will swallow its deep
// tree is wide -> use dfs, tree is deep -> use bfs
@Deprecated
public class Solution {
    static class Graph {
        int vertices;
        HashMap<Integer, List<Integer>> mapOut = new HashMap<>();
        HashMap<Integer, List<Integer>> mapIn = new HashMap<>();
        boolean visited[]; // used in dfs

        public Graph(int vertices) {
            this.vertices = vertices;
            visited = new boolean[vertices];
        }

        public void addEdge(int x, int y) {
            if (mapOut.containsKey(x)) {
                mapOut.get(x).add(y);

            } else {
                List<Integer> edgesOut = new ArrayList<>();
                edgesOut.add(y);
                mapOut.put(x, edgesOut);
            }

            if (mapIn.containsKey(y)) {
                mapIn.get(y).add(x);
            } else {
                List<Integer> edgesIn = new ArrayList<>();
                edgesIn.add(x);
                mapIn.put(y, edgesIn);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        topologicalSort(g);
        // 5,4,2,3,1,0
    }

    // dfs
//    public static void topologicalSort(Graph g) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < g.vertices; i++) {
//            if (g.visited[i]) {
//                continue;
//            }
//            helper(g, i, stack);
//        }
//
//        while (!stack.empty()) {
//            System.out.println(stack.pop());
//        }
//    }
//
//    private static void helper(Graph g, int vertex, Stack<Integer> stack) {
//        g.visited[vertex] = true;
//
//        List<Integer> neighbors = g.mapOut.getOrDefault(vertex, null);
//        if (neighbors != null) {
//            for (int nei: neighbors) {
//                if (g.visited[nei]) {
//                    continue;
//                }
//                helper(g, nei, stack);
//            }
//        }
//
//        stack.push(vertex);
//    }


    // using bfs
    public static void topologicalSort(Graph g) {
        int result = 0;

        // calculate incoming nodes for every vertex
        int[] incomingNodes = new int[g.vertices];
        for (int i = 0; i < incomingNodes.length; i++) {
            incomingNodes[i] = g.mapIn.getOrDefault(i, new ArrayList<>()).size();
        }

        // put into queue if its incomingNodes equals zero
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < incomingNodes.length; i++) {
            if (incomingNodes[i] == 0) {
                queue.offer(i);

            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result++;
            System.out.println(node);

            // every node popped from queue will traverse its neighbors (outgoing nodes), decreasing every its outgoing
            // node by 1, and then check whether the incoming nodes equals zero. If true, put it into queue
            List<Integer> outs = g.mapOut.getOrDefault(node, new ArrayList<>());
            for (int outNode : outs) {//  iterate through all outgoing nodes, put info queue if incoming node == 0 and remove all outgoing edges
                if (!g.visited[outNode]) {
                    //!!!!
                    incomingNodes[outNode]--;

                    //!!!!
                    if (incomingNodes[outNode] == 0) {
                        queue.offer(outNode);
                    }
                }
            }
        }

        if (result != g.vertices) {
            System.out.println("Cycle detected");
        }
    }
}
