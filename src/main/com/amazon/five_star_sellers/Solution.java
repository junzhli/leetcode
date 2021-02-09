package com.amazon.five_star_sellers;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * Third-party companies that sell their products on Amazon.com are able to analyze the customer reviews for their products in real time. Imagine that Amazon is creating a category called "five-star sellers" that will only display products sold by companies whose average percentage of five-star reviews per-product is at or above a certain threshold. Given the number of five-star and total reviews for each product a company sells, as well as the threshold percentage, what is the minimum number of additional fivestar reviews the company needs to become a five-star seller?
     *
     * For example, let's say there are 3 products (n = 3) where productRatings = [[4,4], [1,2], [3, 6]], and the percentage ratings Threshold = 77. The first number for each product in productRatings denotes the number of fivestar reviews, and the second denotes the number of total reviews. Here is how we can get the seller to reach the threshold with the minimum number of additional five-star reviews:
     *
     * Before we add more five-star reviews, the percentage for this seller is ((4 / 4) + (1/2) + (3/6))/3 = 66.66%
     * If we add a five-star review to the second product, the percentage rises to ((4 / 4) + (2/3) +(3/6))/3 = 72.22%
     * If we add another five-star review to the second product, the percentage rises to ((4 / 4) + (3/4) + (3/6))/3 = 75.00%
     * If we add a five-star review to the third product, the percentage rises to ((4/4) + (3/4) + (4/7))/3 = 77.38%
     * At this point, the threshold of 77% has been met. Therefore, the answer is 3 because that is the minimum number of additional five-star reviews the company needs to become a five-star seller.
     *
     * Function Description
     *
     * Complete the function fiveStarReviews in the editor below.
     *
     * fiveStarReviews has the following parameters:
     *
     * int productRatings[n][2]: a 2-dimensional array of integers where the ith element contains two values, the first one denoting fivestar[i] and the second denoting total[i]
     *
     * int ratingsThreshold: the threshold percentage, which is the average percentage of five-star reviews the products need for the company to be considered a five-star seller
     *
     * Returns:
     *
     * int: the minimum number of additional five-star reviews the company needs to meet the threshold ratingsThreshold
     *
     * Constraints
     *
     * 1<=n<=200
     * 0 <= fivestar<total<=100
     * 1<=ratingsThreshold<100
     * The array productRatings contains only non-negative integers.
     */

    static class ProductRating {
        int people;
        int rateFives;

        ProductRating (int rateFives, int people) {
            this.rateFives = rateFives;
            this.people = people;
        }
    }

    public static int minChange(List<List<Integer>> productRatings, int ratingsThreshold) {
        if (productRatings.size() == 0) {
            return 0;
        }

        PriorityQueue<ProductRating> pQueue = new PriorityQueue<>(new Comparator<ProductRating>() {
            @Override
            public int compare(ProductRating o1, ProductRating o2) {
                float improvedRatesA = (((float) (o1.rateFives + 1) / (o1.people + 1))
                        - ((float) o1.rateFives / o1.people)); // !!!!(no need to put divisor) notice some cases would result in "infinity" due to zero-divisor problem
                float improvedRatesB = (((float) (o2.rateFives + 1) / (o2.people + 1))
                        - ((float) o2.rateFives / o2.people));

                float diff = improvedRatesA - improvedRatesB;
                if (diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int res = 0;
        int products = productRatings.size();
        float percentages = 0;
        for (List<Integer> pRating: productRatings) {
            percentages += ((float) pRating.get(0) / (float) pRating.get(1));
            pQueue.offer(new ProductRating(pRating.get(0), pRating.get(1)));
        }

        /**
         * debugging purpose
         */
//        while (!pQueue.isEmpty()) {
//            ProductRating pR = pQueue.poll();
//            System.out.println(pR.rateFives + " " + pR.people);
//            System.out.println((((float) (pR.rateFives + 1) / (pR.people + 1))
//                    - ((float) pR.rateFives / pR.people)));
//        }
//        return res;

        if (percentages * 100 / products >= ratingsThreshold) {
            return res;
        }

        while (percentages * 100 / products < ratingsThreshold) {
            System.out.println(percentages * 100 / products);

            ProductRating pRating = pQueue.poll();
            System.out.println(pRating.rateFives + " / " + pRating.people);

            percentages = percentages - ((float) pRating.rateFives / (float) pRating.people)
                                        + ((float) (pRating.rateFives + 1) / (float) (pRating.people + 1));
            pRating.people += 1;
            pRating.rateFives += 1;
            res += 1;
            pQueue.offer(pRating);
        }
        System.out.println(percentages * 100 / products);

        return res;
    }

}
