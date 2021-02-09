package com.leetcode.course_schedule_ii;

import java.util.*;

public class Solution {
    // round 2
    // using dfs
    // https://en.wikipedia.org/wiki/Topological_sorting
    // dfs, bfs, topological sorting
    // bfs is better at finding shortest path while dfs is better at finding vertices connectivity
    // https://efficientcodeblog.wordpress.com/2017/11/28/topological-sort-dfs-bfs-and-dag/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] beingVisited = new boolean[numCourses];
        ArrayList<Integer>[] neighbors = new ArrayList[numCourses];
        for (int i = 0; i < neighbors.length; i++) {
            neighbors[i] = new ArrayList<>();
        }
        buildRelations(prerequisites, neighbors);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }

            if (!visited[i] && helper(stack, visited, beingVisited, neighbors, i)) {
                return new int[0];
            }
        }

        // use topological sorting !!! the reason we use stack is that our topological sorting uses dfs which means
        // the starting point returns in the final run
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.empty()) {
            ret.add(stack.pop());
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }

    private boolean helper(Stack<Integer> stack, boolean[] visited, boolean[] beingVisited, ArrayList<Integer>[] neighbors, int i) {
        if (beingVisited[i]) {
            return true;
        }

        beingVisited[i] = true;

        for (int n: neighbors[i]) {
            if (visited[n]) {
                continue;
            }

            if (helper(stack, visited, beingVisited, neighbors, n)) {
                return true;
            }
        }

        beingVisited[i] = false;
        visited[i] = true;

        stack.push(i);
        return false;
    }

    private void buildRelations(int[][] prerequisites, ArrayList<Integer>[] neighbors) {
        for (int[] p: prerequisites) {
            neighbors[p[1]].add(p[0]);
        }
    }


    // round 1
    // topological sorting, bfs
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
//    private boolean[] beingVisited;
//    private boolean[] visited;
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        beingVisited = new boolean[numCourses];
//        visited = new boolean[numCourses];
//
//        // roots (which doesn't contain incoming nodes: 0)
//        int[] incomingNodes = new int[numCourses];
//
//        // gen graph
//        HashMap<Integer, Vertex> hashMap = new HashMap<>();
//        List<Vertex> vertices = new ArrayList<>();
//
//        for (int[] prerequisite: prerequisites) {
//            incomingNodes[prerequisite[0]] += 1;
//            Vertex v1 = hashMap.getOrDefault(prerequisite[0], new Vertex(prerequisite[0]));
//            hashMap.putIfAbsent(prerequisite[0], v1);
//            Vertex v2 = hashMap.getOrDefault(prerequisite[1], new Vertex(prerequisite[1]));
//            hashMap.putIfAbsent(prerequisite[1], v2);
//            v2.addNeighbor(v1);
//            vertices.add(v2);
//        }
//
//        // find cycles
//        for (Vertex v: vertices) {
//            if (!helper(v)) {
//                return new int[0];
//            }
//        }
//
//        // iterate through roots using bfs
//        ArrayList<Integer> res = new ArrayList<>();
//        Queue<Vertex> queue = new LinkedList<>();
//        int[] tmpIncoming = Arrays.copyOf(incomingNodes, numCourses);
//        for (int i = 0; i < numCourses; i++) {
//            if (incomingNodes[i] == 0) {
//                Vertex v = hashMap.getOrDefault(i, new Vertex(i));
//                hashMap.putIfAbsent(i, v);
//                res.add(v.course);
//                List<Vertex> adj = v.adjacencyList;
//                queue.addAll(adj);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            Vertex _v = queue.poll();
//            tmpIncoming[_v.course] -= 1;
//            if (tmpIncoming[_v.course] == 0) {
//                res.add(_v.course);
//                List<Vertex> _adj = _v.adjacencyList; //*
//                queue.addAll(_adj); //*
//            }
//        }
//
//        return res.stream().mapToInt(i -> i).toArray();
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
}
