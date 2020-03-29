package self.practice.backtrack.n_queen_problem;

import java.util.Arrays;

public class Solution {

    private int[][] result;
    private int _queens;

    public void nQueen(int queens) {
        _queens = queens;
        result = new int[queens][queens];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], 0);
        }

        _nQueen(queens);

        for(int i = 0; i < _queens; i++) {
            for(int j = 0; j < _queens; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    private boolean _nQueen(int queens) {
        if (queens == 0) {
            return true;
        }

        for (int i = 0; i < _queens; i++) {
            for (int j = 0; j < _queens; j++) {
                /**
                 * check if others is in its diagnose or has been occupied
                 * if true, place the queen in this (i, j)
                 * and finally, check if others can be placed properly in recursive way
                 * if true, return true;
                 * else move the queen out of this (i, j) and return false;
                 */
                if (!isAttack(i, j) && result[i][j] != 1) {
                    result[i][j] = 1;

                    if (_nQueen(queens - 1)) {

                        return true;
                    }

                    result[i][j] = 0;
                }
            }
        }

        return false;
    }

    private boolean isAttack(int i, int j) {
        for (int x = 0; x < _queens; x++) {
            if (result[x][j] == 1 || result[i][x] == 1) { // check every cols and rows
                return true;
            }
        }

        // refer to https://www.kancloud.cn/leavor/cplusplus/630540
        // (k - i or i - k) = j - l where (i, j) is the one ,and (k, l) is in the one's diagnose
        for (int k = 0; k < _queens; k++) {
            for (int l = 0; l < _queens; l++) {
                // check every diagnoses
                if ((l + k) == (i + j) || (i - j) == (k - l)) {
                    if (result[k][l] == 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
