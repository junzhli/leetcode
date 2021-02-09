package com.leetcode.count_primes;

public class Solution {
    public int countPrimes(int n) {
        // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
        boolean[] prime = new boolean[n];
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < prime.length; i++) { //
            // i * i: as a refinement, it's sufficient to terminate if i^2 > n
            // i * i < prime.length: i < square of prime n
            for (int j = i; j * i < prime.length; j++) {
                prime[j * i] = false; // prime: j (starting from 2), times: i (starting from 2)
            }
        }

        int countPrime = 0;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                countPrime++;
            }
        }

        return countPrime;
    }
}
