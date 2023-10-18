package com.leetcode.course_schedule;

import java.util.*;

public class Solution {
    // round 4
    // use array to depict the relations across vertices
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] arr = new boolean[numCourses][numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            arr[from][to] = true;
        }

        for (int i = 0; i < numCourses; i ++) {
            if (visited[i]) {
                continue;
            }

            boolean result = dfs(new boolean[numCourses], visited, arr, i);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(boolean[] visiting, boolean[] visited, boolean[][] arr, int v) {
        if (visited[v]) {
            return true;
        }

        if (visiting[v]) {
            return false;
        }

        visiting[v] = true;
        for (int i = 0; i < visiting.length; i++) {
            if (arr[v][i]) {
                boolean result = dfs(visiting, visited, arr, i);
                if (!result) {
                    return false;
                }
            }
        }

        visiting[v] = false;
        visited[v] = true;

        return true;
    }

    // round 3
    // using dfs (hasCycle)
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        boolean[] visited = new boolean[numCourses];
//        boolean[] beingVisited = new boolean[numCourses];
//        ArrayList<Integer>[] adj = new ArrayList[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            adj[i] = new ArrayList<Integer>();
//        }
//
//        for (int[] p: prerequisites) {
//            int before = p[0];
//            int course = p[1];
//            adj[before].add(course);
//        }
//
//        for (int i = 0; i < numCourses; i++) {
//            if (!visited[i] && hasCycle(i, visited, beingVisited, adj)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private boolean hasCycle(int i, boolean[] visited, boolean[] beingVisited, ArrayList<Integer>[] adj) {
//        if (beingVisited[i]) {
//            return true;
//        }
//
//        beingVisited[i] = true;
//        for (int a: adj[i]) {
//            if (!visited[a] && hasCycle(a, visited, beingVisited, adj)) {
//                return true;
//            }
//        }
//
//        beingVisited[i] = false;
//        visited[i] = true;
//
//        return false;
//    }

    // round 2.1
    // using bfs with iteration

    // round 2
    // using dfs with recursion
    // note: uses 'beingVisited' to determine cycle is forming
    //       uses 'visited' to avoid duplication
//    class Node {
//        int val;
//        HashSet<Node> adj;
//
//        Node(int val) {
//            this.val = val;
//            this.adj = new HashSet<>();
//        }
//
//        void ConnectTo(Node node) {
//            this.adj.add(node);
//        }
//    }
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        Node[] courses = new Node[numCourses];
//        for (int i = 0; i < courses.length; i++) {
//            courses[i] = new Node(i);
//        }
//
//        for (int[] prer: prerequisites) {
//            int before = prer[0];
//            int take = prer[1];
//            courses[before].ConnectTo(courses[take]);
//        }
//
//        boolean[] visited = new boolean[numCourses];
//        boolean[] beingVisited = new boolean[numCourses];
//        for (Node c: courses) {
//            if (!visited[c.val] && hasCycle(c, visited, beingVisited)) { // visited, beVisiting
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private boolean hasCycle(Node course, boolean[] visited, boolean[] beingVisited) {
//        if (beingVisited[course.val]) {
//            return true;
//        }
//
//        beingVisited[course.val] = true;
//
//        for (Node a: course.adj) {
//            if (!visited[a.val]) { /// ??? see round 3
//                continue;
//            }
//
//            if (hasCycle(a, visited, beingVisited)) {
//                return true;
//            }
//        }
//
//        beingVisited[course.val] = false;
//        visited[course.val] = true;
//
//        return false;
//    }


    // round 1
//    static class Vertex {
//        int course;
//        List<Vertex> adjacencyList;
//
//        Vertex(int course) {
//            this.course = course;
//            this.adjacencyList = new ArrayList<>();
//        }
//
//        void addNeighbor(Vertex adjacent) {
//            this.adjacencyList.add(adjacent);
//        }
//    }
//
//
//
//    // using dfs
////
////    private boolean[] beingVisited;
////    private boolean[] visited;
////
////    // use dfs to traverse all adjacent through every vertices in array, return false if there is an adjacent being visited
////    public boolean canFinish(int numCourses, int[][] prerequisites) {
////        beingVisited = new boolean[numCourses];
////        visited = new boolean[numCourses];
////
////        // gen Graph
////        HashMap<Integer, Vertex> hashMap = new HashMap<>();
////        List<Vertex> vertices = new ArrayList<>();
////        for (int[] prerequisite: prerequisites) {
////            Vertex v1 = hashMap.getOrDefault(prerequisite[0], new Vertex(prerequisite[0]));
////            hashMap.putIfAbsent(prerequisite[0], v1);
////            Vertex v2 = hashMap.getOrDefault(prerequisite[1], new Vertex(prerequisite[1]));
////            hashMap.putIfAbsent(prerequisite[1], v2);
////            v1.addNeighbor(v2);
////            vertices.add(v1);
////        }
////
////        // find cycle
////        for (Vertex v: vertices) {
////            if (!helper(v)) {
////                return false;
////            }
////        }
////        return true;
////    }
////
////    // it must return true if it can finish
////    private boolean helper(Vertex v) {
////        beingVisited[v.course] = true;
////
////        List<Vertex> adjacent = v.adjacencyList;
////        for (Vertex a: adjacent) {
////            if (beingVisited[a.course]) {
////                return false;
////            } else if (!visited[a.course] && !helper(a)) {
////                return false;
////            }
////        }
////
////        beingVisited[v.course] = false;
////        visited[v.course] = true;
////        return true;
////    }
//
//    /**
//     * follow up: use bfs, dfs
//     * bfs could be faster than dfs
//     */
//
//    // using bfs
//    // refer to https://www.geeksforgeeks.org/detect-cycle-in-a-directed-graph-using-bfs/
//    // simply saying, it uses bfs algorithm in directed graph to detect cycles
//    //
//    /**
//     * algorithm: Kahn’s algorithm for Topological Sorting
//     * Steps involved in detecting cycle in a directed graph using BFS.
//     *
//     * Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the graph and initialize the count of visited nodes as 0.
//     *
//     * Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
//     *
//     * Step-3: Remove a vertex from the queue (Dequeue operation) and then.
//     *
//     *     Increment count of visited nodes by 1.
//     *     Decrease in-degree by 1 for all its neighboring nodes.
//     *     If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
//     *
//     * Step 4: Repeat Step 3 until the queue is empty.
//     *
//     * Step 5: If count of visited nodes is not equal to the number of nodes in the graph has cycle, otherwise not.
//     */
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[] incomingEdges = new int[numCourses];
//        int visited = 0;
//
//        for (int[] p: prerequisites) {
//            incomingEdges[p[1]]++;
//        }
//
//        // gen Graph
//        HashMap<Integer, Vertex> hashMap = new HashMap<>();
//        List<Vertex> vertices = new ArrayList<>();
//        for (int[] prerequisite: prerequisites) {
//            Vertex v1 = hashMap.getOrDefault(prerequisite[0], new Vertex(prerequisite[0]));
//            hashMap.putIfAbsent(prerequisite[0], v1);
//            Vertex v2 = hashMap.getOrDefault(prerequisite[1], new Vertex(prerequisite[1]));
//            hashMap.putIfAbsent(prerequisite[1], v2);
//            v1.addNeighbor(v2);
//            vertices.add(v1);
//        }
//
//        // add vertex to queue if incomingedge is zero
//        Queue<Vertex> queue = new LinkedList<>();
//        for (int i = 0; i < incomingEdges.length; i++) {
//            if (incomingEdges[i] == 0) {
//                Vertex beAdded = hashMap.getOrDefault(i, new Vertex(i));
//                hashMap.putIfAbsent(i, beAdded);
//                queue.add(beAdded);
//            }
//        }
//
//        // pop up vertex in queue, until queue is empty
//        // increment count of visited by 1
//        // every vertex popped out from queue traverse its adjacent. decrease count of its incomingedge by 1.
//        // put it to queue if incomingedge is zero (after reduction)
//        while (!queue.isEmpty()) {
//            Vertex v = queue.poll();
//            visited++;
//            List<Vertex> adjacent = v.adjacencyList;
//
//            for (Vertex a: adjacent) {
//                incomingEdges[a.course]--;
//                if (incomingEdges[a.course] == 0) {
//                    queue.add(a);
//                }
//            }
//        }
//
//        // return true if visited == number of courses
//        return (visited == numCourses);
//    }


}
