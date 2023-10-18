package com.leetcode.best_time_to_buy_and_sell_stock;

public class Solution {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */

    // round 2
    // greedy algorithm: always to use lowest buy-in price where we visited to earn
    // if there's lower one, update the current buy-in-price to this
    // check with curr max value and (current visit point - current buy-in-price)
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = -1;
        for (int i = 0; i < prices.length; i++) {
            if (buy == -1) {
                buy = prices[i];
            } else if (prices[i] < buy) {
                buy = prices[i];
            }
            max = Math.max(prices[i] - buy, max);
        }
        return max;
    }

//    public int maxProfit(int[] prices) {
//
//
//
//        // round 1
//        /**
//         * Concept: Find min value at i and max value at j and j > i
//         * 7 1 5 3 6 4
//         *
//         * t: n
//         * s: n
//         */
//
//        // if number of prices is less than 2, return 0
//        if (prices.length == 0 || prices.length == 1) {
//            return 0;
//        }
//
//        int res = 0;
//        int min = prices[0];
//        int max = prices[0];
//
//        for (int i = 0; i < prices.length; i++) {
//            /**
//             * find value which is greater than min as max, and then return max - min
//             */
//            if (prices[i] > max) {
//                max = prices[i];
//            } else if (prices[i] < min) {
//                /**
//                 * if we find the value is lower than min. min and max both needs to be cleared and reset
//                 * because max at j and min at i must fit the need which is j > i
//                 * to keep last best result, check the current value (max - min) is greater than the previous result
//                 *
//                 * *   * * * *
//                 *   *
//                 *
//                 *
//                 * *   * * * *
//                 *
//                 *
//                 */
//                res = Math.max(res, max - min);
//
//                min = prices[i];
//                max = prices[i];
//            }
//        }
//
//        return Math.max(max - min, res);
//    }
}
