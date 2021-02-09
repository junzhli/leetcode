package com.leetcode.sum_of_two_integers;

public class Solution {
    /**
     *
     * illustrate how does the solution work:
     *
     * carry can be an alternative to temp var, it can be assigned to var 'b' after xor operation with 'a'
     *  and 'b' finished
     *
     * step 1. get carry: carry = a & b << 1
     * step 2. assign carry to b: b = carry
     * step 3. xor operation with a and b, the outcome saved in a: a = a ^ b
     * keep doing the above steps until no carry is provided
     *
     *
     */



    // solution for addition of two numbers without arithmetic operator (+)
    // https://leetcode.com/problems/sum-of-two-integers/discuss/689566/Standard-Java-Solution
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
