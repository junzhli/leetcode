package com.leetcode.product_of_array_except_self;

public class Solution {
    /**
     * 題目說明：
     *
     *         輸入1個陣列nums，需產生新的陣列output，而新的陣列的值output[i] 是原本陣列其他元素相乘但不包含相乘nums[i]的結果。題目要求時間複雜度為O(n)且不能用額外的計算空間。
     *         比如範例輸入的[1, 2, 3 ,4]，答案是[2 * 3 * 4, 1 * 3 * 4, 1 * 2 * 4, 1 * 2 * 3] = [24, 12, 8, 6]
     *
     * 解題方法：
     *    　可以先用數學代數分析題目，假設陣列的值是 [x, y, z, w]，第一次我們從索引值 i = 0 往上遞增，先建立一版不包含當前nums[i]的相乘，之後再從i = n - 1往下遞減，乘上當前nums[i+1]的解。
     *
     *     先從i = 0 到 n-1，output變化為 [1] => [1, x * 1] => [1, x, y * x] => [1, x, yx, z * xy] = [1, x, yx, zxy]
     *     再從 i = n -1 到 ，output變化為[1, x, yx, zxy * 1] => [1, x, yx * w, zxy] => [1, x * zw, yxw, zxy] =>  [1 * zwy, xzw, yxw, zxy] = [zwy, xzw, yxw, zxy]
     *
     * 最終答案是[zwy, xzw, yxw, zxy]，每個元素都不包含原本nums[i]的值
     *
     * // [1, x, xy, xyz]
     * // [yzw, zw, w, 1]
     * // times together to get the result
     */

    //https://glj8989332.blogspot.com/2020/09/leetcode-238-product-of-array-except.html
    public int[] productExceptSelf(int[] nums) {
        // left * right (except itself)
        // [1,2,3,4]
        // regarding to 3, (1*2) * (4)
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int[] tmp = new int[nums.length];
        tmp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            tmp[i] = tmp[i + 1] * nums[i + 1];
            res[i] *= tmp[i];
        }

        return res;
    }
}
