package io.educative.dfs;

import java.util.*;

/**
 * There are a total of n courses a student has to take, numbered from 0 to n-1. A course may have prerequisites. The “depends on” relationship is expressed as a pair of numbers. For example, [0, 1] means you need to take course 1 before taking course 0. Given n and the list of prerequisites, decide if it is possible to take all the courses.
 * Example 1:#
 *
 * Input: n = 2, prerequisites = [[0, 1]]
 *
 * Output: true
 *
 * Explanation: we can take 1 first and then 0.
 * Example 2:#
 *
 * Input: n = 2, prerequisites = [[0, 1], [1, 0]]
 *
 * Output: false
 *
 * Explanation: the two courses depend on each other, there is no way to take them
 *
 * Intuition#
 *
 * Naturally, the dependency relationship can be modelled as a directed graph.
 *
 * Notice that a course is “not takeable” if any of its dependencies are “not takeable”. This only happens when there is a circular dependency, e.g., A depends on B and B depends on A. In graph terms, this is called a cycle. This problem then comes down to determining if the graph contains a cycle. Note that this is a directed graph, and a path is only a cycle if one of the nodes points back to one of the nodes in the current path.
 *
 *Cycle detection#
 *
 * One way to detect cycles is to use DFS. For normal graph DFS a node has two states: to be visited and visited. We traverse the graph and visit each node and mark it as visited.
 *
 * In cycle detection, we need a third state visiting. We perform DFS on each node by:
 *
 *     marking a node as visiting
 *     visiting each of its neighbors
 *
 * When we reach the end of the path, i.e. no more out edges from the last node in the path, we mark the node in the path as visited. If during the DFS we happen to come back to a node that is in the visiting state, we have a cycle.
 *
 * One question you may ask is why we have to introduce an additional state visiting. Couldn’t we have solved it with only visited and to be visited as in normal DFS?
 *
 * If we use the normal DFS logic and reject when a node in the visited state is revisited, we would have determined the above graph to have a cycle. Even though node 3 is visited twice, the graph does not contain a cycle.
 *
 * In a directed graph, a path is only a cycle if a node on the path points to an existing node on the same path. If we only have two states, we wouldn’t be able to distinguish this. The visiting state gives us a way to represent the “current path”.
 *
 * Consider the following case:
 *
 * The time complexity for the DFS is O(E+V)O(E+V).
 */
public class CourseSchedule {
    public static boolean isValidCourseSchedule(int n, int[][] prerequisites) {
        // WRITE YOUR BRILLIANT CODE HERE
        HashMap<Integer, List<Integer>> graph = buildGraph(n, prerequisites);
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dfs(n, graph, visiting, visited, i)) {
                return true;
            };
        }
        return false;
    }

    private static boolean dfs(int n, HashMap<Integer, List<Integer>> graph, boolean[] visiting, boolean[] visited, int klassNumber) {
        if (visited[klassNumber]) {
            return false;
        }

        visiting[klassNumber] = true;

        for (Integer adj: graph.getOrDefault(klassNumber, new ArrayList<>())) {
            if (visited[adj]) {
                continue;
            }

            if (visiting[adj]) {
                return true;
            }

            if (dfs(n, graph, visiting, visited, adj)) {
                return true;
            }
        }

        visiting[klassNumber] = false;
        visited[klassNumber] = true;

        return false;
    }

    private static HashMap<Integer, List<Integer>> buildGraph(int n, int [][] prerequisites) {
        HashMap<Integer, List<Integer>> result = new HashMap<>();

        for (int[] prerequisite: prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            if (result.get(from) == null) {
                result.put(from, new ArrayList<>(Arrays.asList(to)));
            } else {
                List<Integer> arr = result.get(from);
                arr.add(to);
            }
        }

        return result;
    }

    // Driver code
    public static void main(String[] args) {

        String[] inputs = {"2","2", "4"};
        String[] inputs1 = {"1", "2", "4"};
        String[][] inputs2 = {{"0 1"},{"0 1","1 0"},{"0 1","1 2","2 3","3 1"}};
        for (int i = 0; i<inputs.length; i++) {
            int n = Integer.parseInt(inputs[i]);
            int numDependencies = Integer.parseInt(inputs1[i]);
            int[][] relationships = new int[numDependencies][];
            for (int j = 0; j < numDependencies; j++) {
                String[] courses = inputs2[i][j].split(" ");
                int[] dependency = new int[2];
                dependency[0] = Integer.parseInt(courses[0]);
                dependency[1] = Integer.parseInt(courses[1]);
                relationships[j] = dependency;
            }
            System.out.println("Course Schedule : " +isValidCourseSchedule(n, relationships));
        }
    }
}
