package com.leetcode.print_in_order;

import java.util.concurrent.Semaphore;

public class Solution {
    /**
     * Print strings for those func in this order: first, second, third;
     * Use semaphore to let executions without semaphore to wait until released
     */
    class Foo {
        Semaphore lockA;
        Semaphore lockB;

        public Foo() {
            lockA = new Semaphore(0);
            lockB = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            lockA.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lockA.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            lockB.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            lockB.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
