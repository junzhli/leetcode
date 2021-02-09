package self.alg.binary_tree.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void binarySearch() {
        Solution sol = new Solution();
        int[] testArr = new int[] {1,2,3,4,5,6,9,12,13};
        int i = 0;
        for (int a: testArr) {
            System.out.println(sol.binarySearch(testArr, a));
//            assertEquals(i++, sol.binarySearch(testArr, a));
        }
        assertEquals(-1, sol.binarySearch(testArr, 0));
    }
}