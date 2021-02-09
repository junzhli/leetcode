package com.leetcode.kth_smallest_element_in_a_sorted_matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    /**
     * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
     *
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     *
     * Example:
     *
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     *
     * return 13.
     *
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ n2.
     */

    // 5xx ms
//    static class Answer {
//        int value;
//        int x;
//        int y;
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Answer answer = (Answer) o;
//            return value == answer.value &&
//                    x == answer.x &&
//                    y == answer.y;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(value, x, y);
//        }
//
//        Answer (int value, int x, int y) {
//            this.value = value;
//            this.x = x;
//            this.y = y;
//        }
//
//    }
//
//    public int kthSmallest(int[][] matrix, int k) {
//        if (matrix.length == 0) {
//            return -1;
//        }
//
//        boolean[][] visited = new boolean[matrix[0].length][matrix.length];
//        List<Answer> arr = new ArrayList<>();
//
//        Answer first = new Answer(matrix[0][0], 0, 0);
//        arr.add(first);
//        visited[0][0] = true;
//
//        for (int i = 1; i < k; i++) {
//            Answer currentSmallest = null;
//            List<Answer> beRemoved = new ArrayList<>();
//            for (Answer n: arr) {
//                Answer smallestAdj = smallestAdjacentForNow(matrix, visited, n.x, n.y);
//                if (smallestAdj.x == -1 && smallestAdj.y == -1) {
//                    beRemoved.add(n);
//                    continue;
//                }
//
//                if (currentSmallest == null) {
//                    currentSmallest = smallestAdj;
//                    continue;
//                }
//
//                if (currentSmallest.value >= smallestAdj.value) {
//                    currentSmallest = smallestAdj;
//                }
//            }
//
//            if (currentSmallest == null) {
//                break;
//            }
//
//            arr.add(currentSmallest);
//            visited[currentSmallest.x][currentSmallest.y] = true;
//
//            if (beRemoved.size() != 0) {
//                arr.removeAll(beRemoved);
//            }
//        }
//
//        return arr.get(arr.size() - 1).value;
//    }
//
//    private Answer smallestAdjacentForNow(int[][] matrix, boolean[][] visited, int x, int y) {
//        // return type: int[] which contains [value, num.x, num.y]
//        int min = Integer.MAX_VALUE;
//        int rx = -1;
//        int ry = -1;
//        if (x + 1 < visited.length && !visited[x + 1][y]) {
//            if (matrix[x + 1][y] <= min) {
//                min = matrix[x + 1][y];
//                rx = x + 1;
//                ry = y;
//            }
//        }
//
//        if (y + 1 < visited[0].length && !visited[x][y + 1]) {
//            if (matrix[x][y + 1] <= min) {
//                min = matrix[x][y + 1];
//                rx = x;
//                ry = y + 1;
//            }
//        }
//
//        return new Answer(min, rx, ry);
//    }

    // 16ms use priorityQueue which is implemented a minHeap tree
    class Node {
        int row;
        int col;
        Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new Node(i, 0));

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k)
                break;
            node.col++;
            if (matrix[0].length > node.col)
                minHeap.add(node);
        }
        return result;
    }
}
