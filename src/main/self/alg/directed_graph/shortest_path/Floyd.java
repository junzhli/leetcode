package self.alg.directed_graph.shortest_path;

import java.util.Arrays;

/**
 * t.c. (v^3)
 */
public class Floyd {
    static class Edge {
        int src;
        int dst;
        int weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    public static int[][] floyd(int vertices, Edge[] edges) {
        // initialize
        int[][] matrix = new int[vertices][vertices];
        for (int[] m: matrix) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        // set dst(i, i) = 0
        for (int i = 0; i < vertices; i++) {
            matrix[i][i] = 0;
        }

        // this can be considered as a dynamic programming, bottom-up approach
        // refer: https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm

        // fill in all weight in matrix
        // this line implies all shortest path cases with k = 0, means no intermediate vertex to go through
        for (Edge edge: edges) {
            matrix[edge.src][edge.dst] = edge.weight;
        }

        // k, i ,j: (i, j) <- (i, k), (k, j) [NOTE the 'k' in the middle] if left side > right side, case of shortest path with intermediate vertex to go through
        for (int k = 1; k < vertices; k++) {
            for (int i = 1; i < vertices; i++) {
                for (int j = 1; j < vertices; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                            matrix[i][j] = matrix[i][k] + matrix[k][j];
                        }
                    }
                }
            }
        }

        return matrix;
    }


    public static void main(String[] args) {
        int vertices = 4 + 1;
        Edge e1 = new Edge(2,1,4);
        Edge e2 = new Edge(1, 3, -2);
        Edge e3 = new Edge(3, 4, 2);
        Edge e4 = new Edge(4, 2, -1);
        Edge e5 = new Edge(2, 3, 3);
        Edge[] edges = new Edge[]{e1, e2, e3, e4, e5};

        int[][] result = floyd(vertices, edges);
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result.length; j++) {
                System.out.println(String.format("result[%d][%d] = %d", i, j, result[i][j]));
            }
        }

    }


}
