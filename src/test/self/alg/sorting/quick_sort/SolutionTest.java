package self.alg.sorting.quick_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void quickSort() {
        Solution sol = new Solution();
        int[] res1 = sol.quickSort(new int[]{ 2,0,2,1,1,0});
        utils.Array.printIntArray(res1);
    }
}