package com.leetcode.fizz_buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        final String threeChr = "Fizz", fiveChr = "Buzz", fifteenChr = "FizzBuzz";
        int three = 0, five = 0, fifteen = 0;
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            three++;
            five++;
            fifteen++;

            if (fifteen == 15) {
                ret.add(fifteenChr);
                fifteen = 0;
                three = 0;
                five = 0;
                continue;
            }

            if (three == 3) {
                ret.add(threeChr);
                three = 0;
                continue;
            }

            if (five == 5) {
                ret.add(fiveChr);
                five = 0;
                continue;
            }

            ret.add(String.valueOf(i));
        }

        return ret;
    }
}
