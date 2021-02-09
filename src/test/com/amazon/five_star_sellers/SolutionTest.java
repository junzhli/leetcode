package com.amazon.five_star_sellers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minChange() {
        List<List<Integer>> test = Arrays.asList(Arrays.asList(4, 4),
                Arrays.asList(1,2),
                Arrays.asList(3,6));

        int ans = Solution.minChange(test, 77);
        assertEquals(3, ans);

//        List<List<Integer>> test2 = Arrays.asList(
//                Arrays.asList(15, 15),
//                Arrays.asList(1, 2),
//                Arrays.asList(3, 6),
//                Arrays.asList(15, 115),
//                Arrays.asList(1, 22),
//                Arrays.asList(3, 16),
//                Arrays.asList(13, 215),
//                Arrays.asList(0, 2),
//                Arrays.asList(6, 6)
//        );
//
//        int ans2 = Solution.minChange(test2, 90);
//        assertEquals(1113, ans2);
    }
}