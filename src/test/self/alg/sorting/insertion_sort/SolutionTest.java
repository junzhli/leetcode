package self.alg.sorting.insertion_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void insertionSort() {
        Solution sol = new Solution();
        int[] res1 = sol.insertionSort(new int[]{1,3,2,0,0});
        utils.Array.printIntArray(res1);
    }
}