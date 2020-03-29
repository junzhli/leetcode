package com.leetcode.course_schedule;

import java.util.*;

public class Solution {

    static class Vertex {
        int course;
        List<Vertex> adjacencyList;

        Vertex(int course) {
            this.course = course;
            this.adjacencyList = new ArrayList<>();
        }

        void addNeighbor(Vertex adjacent) {
            this.adjacencyList.add(adjacent);
        }
    }



    // using dfs
//
//    private boolean[] beingVisited;
//    private boolean[] visited;
//
//    // use dfs to traverse all adjacent through every vertices in array, return false if there is an adjacent being visited
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        beingVisited = new boolean[numCourses];
//        visited = new boolean[numCourses];
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
//        // find cycle
//        for (Vertex v: vertices) {
//            if (!helper(v)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // it must return true if it can finish
//    private boolean helper(Vertex v) {
//        beingVisited[v.course] = true;
//
//        List<Vertex> adjacent = v.adjacencyList;
//        for (Vertex a: adjacent) {
//            if (beingVisited[a.course]) {
//                return false;
//            } else if (!visited[a.course] && !helper(a)) {
//                return false;
//            }
//        }
//
//        beingVisited[v.course] = false;
//        visited[v.course] = true;
//        return true;
//    }

    /**
     * follow up: use bfs, dfs
     * bfs could be faster than dfs
     */

    // using bfs
    // refer to https://www.geeksforgeeks.org/detect-cycle-in-a-directed-graph-using-bfs/
    // simply saying, it uses bfs algorithm in directed graph to detect cycles
    //
    /**
     * algorithm: Kahn’s algorithm for Topological Sorting
     * Steps involved in detecting cycle in a directed graph using BFS.
     *
     * Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the graph and initialize the count of visited nodes as 0.
     *
     * Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
     *
     * Step-3: Remove a vertex from the queue (Dequeue operation) and then.
     *
     *     Increment count of visited nodes by 1.
     *     Decrease in-degree by 1 for all its neighboring nodes.
     *     If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
     *
     * Step 4: Repeat Step 3 until the queue is empty.
     *
     * Step 5: If count of visited nodes is not equal to the number of nodes in the graph has cycle, otherwise not.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        int visited = 0;

        for (int[] p: prerequisites) {
            incomingEdges[p[1]]++;
        }

        // gen Graph
        HashMap<Integer, Vertex> hashMap = new HashMap<>();
        List<Vertex> vertices = new ArrayList<>();
        for (int[] prerequisite: prerequisites) {
            Vertex v1 = hashMap.getOrDefault(prerequisite[0], new Vertex(prerequisite[0]));
            hashMap.putIfAbsent(prerequisite[0], v1);
            Vertex v2 = hashMap.getOrDefault(prerequisite[1], new Vertex(prerequisite[1]));
            hashMap.putIfAbsent(prerequisite[1], v2);
            v1.addNeighbor(v2);
            vertices.add(v1);
        }

        // add vertex to queue if incomingedge is zero
        Queue<Vertex> queue = new LinkedList<>();
        for (int i = 0; i < incomingEdges.length; i++) {
            if (incomingEdges[i] == 0) {
                Vertex beAdded = hashMap.getOrDefault(i, new Vertex(i));
                hashMap.putIfAbsent(i, beAdded);
                queue.add(beAdded);
            }
        }

        // pop up vertex in queue, until queue is empty
        // increment count of visited by 1
        // every vertex popped out from queue traverse its adjacent. decrease count of its incomingedge by 1.
        // put it to queue if incomingedge is zero (after reduction)
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            visited++;
            List<Vertex> adjacent = v.adjacencyList;

            for (Vertex a: adjacent) {
                incomingEdges[a.course]--;
                if (incomingEdges[a.course] == 0) {
                    queue.add(a);
                }
            }
        }

        // return true if visited == number of courses
        return (visited == numCourses);
    }


}
