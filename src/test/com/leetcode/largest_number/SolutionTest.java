package com.leetcode.largest_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void largestNumber() {
        Solution sol = new Solution();
        String ret = sol.largestNumber(new int[]{3,30,34,5,9});
        Assertions.assertEquals("9534330", ret);

        String ret2 = sol.largestNumber(new int[]{0,30,34,5,9});
        Assertions.assertEquals("9534300", ret2);

        String ret3 = sol.largestNumber(new int[]{10,2});
        Assertions.assertEquals("210", ret3);

        String ret4 = sol.largestNumber(new int[]{3338,33});
        Assertions.assertEquals("333833", ret4);

        String ret5 = sol.largestNumber(new int[]{3332,33});
        Assertions.assertEquals("333332", ret5);

        String ret6 = sol.largestNumber(new int[]{0,0});
        Assertions.assertEquals("0", ret6);

        String ret7 = sol.largestNumber(new int[]{0,0,0,0});
        Assertions.assertEquals("0", ret7);

        // [824,938,1399,5607,6973,5703,9609,4398,8247]
        String ret8 = sol.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247});
        Assertions.assertEquals("9609938824824769735703560743981399", ret8);
        // "9609 938 8247 824 69735703560743981399" act
        // "9609 938 824 8247 69735703560743981399" ex

        // [121,12]
        String ret9 = sol.largestNumber(new int[]{121,12});
        Assertions.assertEquals("12121", ret9);
    }
}