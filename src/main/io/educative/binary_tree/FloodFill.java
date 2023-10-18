package io.educative.binary_tree;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// using bfs
// t.c. o(cols * rows) ~= m*n
public class FloodFill {
    public static void floodFill(List<List<Integer>> image, Coordinate start, int replacementColor) {
        if (image.size() == 0) {
            return;
        }
        int rowsSize = image.size();
        int colsSize = image.get(0).size();
        // WRITE YOUR BRILLIANT CODE HERE
        boolean[][] visited = new boolean[rowsSize][colsSize];
        Deque<Coordinate> deque = new ArrayDeque<>();
        deque.offer(start);

        while (!deque.isEmpty()) {
            Coordinate coordinate = deque.poll();

            int[] cols = new int[]{1, -1, 0, 0};
            int[] rows = new int[]{0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int nextC = coordinate.c + cols[i];
                int nextR = coordinate.r + rows[i];
                if (nextR < rowsSize && nextR >= 0 && nextC >= 0 && nextC < colsSize && !visited[nextR][nextC] &&
                        image.get(coordinate.r).get(coordinate.c).equals(image.get(nextR).get(nextC))) {
                    deque.offer(new Coordinate(nextR, nextC));
                }
            }
            image.get(coordinate.r).set(coordinate.c, replacementColor);
            visited[coordinate.r][coordinate.c] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] inputs = {"2 2","1 1"};
        String[] inputs1 = {"9", "9"};
        String[] inputs2 = {"5", "4"};
        String[][] inputs3 = {{"0 1 3 4 1","3 8 8 3 3","6 7 8 8 3","12 2 8 9 1","12 3 1 3 2"},
                {"0 1 6 4","2 3 3 5","3 3 3 3","6 4 3 4"}};

        for(int i = 0; i < inputs.length; i++) {
            String[] coord = inputs[i].split(" ");
            Coordinate start = new Coordinate(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
            int color = Integer.parseInt(inputs1[i]);
            int rows = Integer.parseInt(inputs2[i]);
            List<List<Integer>> image = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                image.add(
                        Arrays.stream(inputs3[i][j].split(" ")).map(Integer::parseInt).collect(Collectors.toList())
                );
            }


            floodFill(image, start, color);

            List<String> actual_output = image.stream().map(row -> row.stream().map(pixel -> Integer.toString(pixel)).collect(Collectors.joining(" "))).collect(Collectors.toList());

            System.out.println("output : " + Arrays.toString(actual_output.toArray()));
        }
    }
}
