package io.educative.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class KnightMinMoves {
    public static int getKnightShortestPath(int x, int y) {
        // always starts with 0,0
        Coordinate startPoint = new Coordinate(0, 0);
        HashSet<Coordinate> visited = new HashSet<>();
        visited.add(startPoint);
        Deque<Coordinate> deque = new ArrayDeque<>();
        deque.offer(startPoint);
        // WRITE YOUR BRILLIANT CODE HERE
        int moves = 0;
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                Coordinate coordinate = deque.poll();
                if (coordinate.r == x && coordinate.c == y) {
                    return moves;
                }

//                int[] nextRows = new int[]{-1, -2, -1, -2, 1, 2, 2, 1};
//                int[] nextCols = new int[]{2, 1, -2, -1, -2, -1, 1, 2};
                int[] nextRows = new int[]{1,1,-1,-1,2,2,-2,-2};
                int[] nextCols = new int[]{2,-2,2,-2,1,-1,1,-1};
                for (int j = 0; j < 8; j++) {
                    int nextRow = coordinate.r + nextRows[j];
                    int nextCol = coordinate.c + nextCols[j];
                    Coordinate nextCoordinate = new Coordinate(nextRow, nextCol);
                    if (visited.contains(nextCoordinate)) {
                        continue;
                    }
                    deque.offer(nextCoordinate);
                    visited.add(nextCoordinate);
                }
            }
            moves += 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        String[] inputs = {"2 1", "5 5"};
        for (int i = 0; i<inputs.length; i++) {
            String[] target = inputs[i].split(" ");
            int x = Integer.parseInt(target[0]);
            int y = Integer.parseInt(target[1]);
            System.out.println("Get knight shortest path : " + getKnightShortestPath(x, y));
        }
    }
}
