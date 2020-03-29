package self.alg.sorting.merge_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void mergeSort() {
        Solution sol = new Solution();
        int[] ret1 = sol.mergeSort(new int[]{2,1,6,4,0,1});
        utils.Array.printIntArray(ret1);
    }
}