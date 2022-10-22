package self.practice.bfs.min_steps_to_reach_target_of_knight;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // using bfs (t.c. n^2 s.c. n^2
    // https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
    // using dynamic programming
    // https://www.geeksforgeeks.org/minimum-steps-reach-target-knight-set-2/

    // using bfs
    class Chess {
        int x;
        int y;

        public Chess(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        int distance;


    }

    public int minStep(int x, int y, int tx, int ty, int n) {
        int[] nx = new int[]{1, 2, 1, 2, -1, -2, -1, -2};
        int[] ny = new int[]{2, 1, -2, -1, 2, 1, -2, -1};
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;

        Queue<Chess> queue = new LinkedList<>();
        queue.offer(new Chess(x, y, 0));

        while (!queue.isEmpty()) {
            Chess ch = queue.poll();

            if (ch.x == tx && ch.y == ty) {
                return ch.distance;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = ch.x + nx[i];
                int nextY = ch.y + ny[i];
                if (isSafe(nextX, nextY, n) && !visited[nextX][nextY]) {
                    queue.offer(new Chess(nextX, nextY, ch.distance + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return -1;
    }

    private boolean isSafe(int x, int y, int n) {
        if (x < 0 || x >= n) {
            return false;
        }

        if (y < 0 || y >= n) {
            return false;
        }

        return true;
    }

    // using dynamic programming
//    public int minStep(int x, int y, int tx, int ty, int n) {
//        int[][] dp = new int[n][n];
//
//        // (Exception) these are the four corner points
//        // for which the minimum steps is 4.
//        if ((x == 1 && y == 1 && tx == 2 && ty == 2)
//                || (x == 2 && y == 2 && tx == 1 && ty == 1)) {
//            return 4;
//        } else if ((x == 1 && y == n && tx == 2 && ty == n - 1)
//                || (x == 2 && y == n - 1 && tx == 1 && ty == n)) {
//            return 4;
//        } else if ((x == n && y == 1 && tx == n - 1 && ty == 2)
//                || (x == n - 1 && y == 2 && tx == n && ty == 1)) {
//            return 4;
//        } else if ((x == n && y == n && tx == n - 1 && ty == n - 1)
//                || (x == n - 1 && y == n - 1 && tx == n && ty == n)) {
//            return 4;
//        } else {
//            // dp[a][b], here a, b is the difference of
//            // x & tx and y & ty respectively.
//            dp[1][0] = 3;
//            dp[0][1] = 3;
//            dp[1][1] = 2;
//            dp[2][0] = 2;
//            dp[0][2] = 2;
//            dp[2][1] = 1;
//            dp[1][2] = 1;
//
//            return helper(dp, x, y, tx, ty);
//        }
//
//
//    }
//
//    private int helper(int[][] dp, int x, int y, int tx, int ty) {
//        if (dp[Math.abs(tx - x)][Math.abs(ty - y)] != 0) {
//            return dp[Math.abs(tx - x)][Math.abs(ty - y)];
//        }
//
//        if (x == tx && y == ty) {
//            return 0;
//        }
//
//        // two cases:
//        // (1) chess get along with the knight with same row or same column
//        // (2) chess not get along with the knight with same row or same column
//        // there are 4 possible relations between chess and the knight:
//        //            K
//        //    C       C     K C     C K
//        //    K
//        //
//        int nx1, ny1, nx2, ny2;
//        if (x < tx) {
//            if (y < ty) {
//                nx1 = x + 2;
//                ny1 = y + 1;
//                nx2 = x + 1;
//                ny2 = y + 2;
//            } else {
//                nx1 = x + 2;
//                ny1 = y - 1;
//                nx2 = x + 1;
//                ny2 = y - 2;
//            }
//        } else {
//            if (y < ty) {
//                nx1 = x - 2;
//                ny1 = y + 1;
//                nx2 = x - 1;
//                ny2 = y + 2;
//            } else {
//                nx1 = x - 2;
//                ny1 = y - 1;
//                nx2 = x - 1;
//                ny2 = y - 2;
//            }
//        }
//
//        dp[Math.abs(tx - x)][Math.abs(ty - y)] = Math.min(helper(dp, nx1, ny1, tx, ty),
//                helper(dp, nx2, ny2, tx, ty)) + 1;
//
//        dp[Math.abs(ty - y)][Math.abs(tx - x)] = dp[Math.abs(tx - x)][Math.abs(ty - y)];
//
//        return dp[Math.abs(tx - x)][Math.abs(ty - y)];
//    }
}
