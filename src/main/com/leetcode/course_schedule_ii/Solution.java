package com.leetcode.course_schedule_ii;

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

    private boolean[] beingVisited;
    private boolean[] visited;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        beingVisited = new boolean[numCourses];
        visited = new boolean[numCourses];

        // roots (which doesn't contain incoming nodes: 0)
        int[] incomingNodes = new int[numCourses];

        // gen graph
        HashMap<Integer, Vertex> hashMap = new HashMap<>();
        List<Vertex> vertices = new ArrayList<>();

        for (int[] prerequisite: prerequisites) {
            incomingNodes[prerequisite[0]] += 1;
            Vertex v1 = hashMap.getOrDefault(prerequisite[0], new Vertex(prerequisite[0]));
            hashMap.putIfAbsent(prerequisite[0], v1);
            Vertex v2 = hashMap.getOrDefault(prerequisite[1], new Vertex(prerequisite[1]));
            hashMap.putIfAbsent(prerequisite[1], v2);
            v2.addNeighbor(v1);
            vertices.add(v2);
        }

        // find cycles
        for (Vertex v: vertices) {
            if (!helper(v)) {
                return new int[0];
            }
        }

        // iterate through roots using bfs
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        int[] tmpIncoming = Arrays.copyOf(incomingNodes, numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (incomingNodes[i] == 0) {
                Vertex v = hashMap.getOrDefault(i, new Vertex(i));
                hashMap.putIfAbsent(i, v);
                res.add(v.course);
                List<Vertex> adj = v.adjacencyList;
                queue.addAll(adj);
            }
        }

        while (!queue.isEmpty()) {
            Vertex _v = queue.poll();
            tmpIncoming[_v.course] -= 1;
            if (tmpIncoming[_v.course] == 0) {
                res.add(_v.course);
                List<Vertex> _adj = _v.adjacencyList; //*
                queue.addAll(_adj); //*
            }
        }

        return convertIntegers(res);
    }

    private int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    // it must return true if it can finish
    private boolean helper(Vertex v) {
        beingVisited[v.course] = true;

        List<Vertex> adjacent = v.adjacencyList;
        for (Vertex a: adjacent) {
            if (beingVisited[a.course]) {
                return false;
            } else if (!visited[a.course] && !helper(a)) {
                return false;
            }
        }

        beingVisited[v.course] = false;
        visited[v.course] = true;
        return true;
    }
}
