package io.educative.priority_queue_and_heap;

import java.util.PriorityQueue;
import java.util.Queue;

// accurate to 1 decimal place
// take constant time o(1)

/**
 * Problem statement
 *
 * Given a stream of numbers, find the median number at any given time (accurate to 1 decimal place). Do this in O(1) time complexity.
 * Example:
 *
 * add_number(1)
 * add_number(2)
 * add_number(3)
 * get_median() == 2.0
 * add_number(4)
 * get_median() == 2.5
 *
 * Explanation
 * Intuition
 *
 * The brute force way is to sort the entire list every time we get a new number. This would be O(Nlog(N)) for each add_number operation.
 *
 * One step up is to notice that the list is sorted before we add any new number to it. So, every time we add a new number to the existing list we just have to find the spot to add it to. We can find the insert position using binary search in O(log(N)). Since inserting into a position also means shifting after the insert position by 1, the overall run time is O(N).
 *
 * Upon re-examining the conditions and unknowns of the problem, we notice we only need to find the median and don’t need the rest of the list to be sorted. But how will we find the median without having a sorted list?
 *
 * It’s useful to use the first principle and go back to the definition of median:
 *
 * Half the numbers are smaller than the median and the other half are larger than the median.
 *
 * Let’s assume the total number of elements is even and we can divide the numbers into two piles of equal size based on their values: a smaller half small pile and the bigger half big pile. The median of both piles is the average of the largest number in the small pile and the smallest number of the big pile. When we add a new number, two things could happen:
 *
 *     The new number is smaller than the largest of the small pile. In this case, we put it into the small pile, and the size of the small pile is now 1 greater than big pile. The median of both piles is the largest number of the small pile.
 *     The new number is bigger than the largest of the small pile. In this case, the number belongs to the big pile. And the median of both piles is the smallest number of the big pile.
 *
 * Now the problem boils down to how to keep a small pile where we can find max value easily and a big pile where we can find min value easily. min heap and max heap fit these requirements perfectly.
 */

/**
 * The time complexity to add an element is O(log(N))O(log(N)) since the heap push operation is O(log(N))O(log(N)). The time complexity to find the median is O(1)O(1) since inspecting the top of each heap is O(1)O(1).
 */
public class MedianOfDataStream {
    private Queue<Double> minHeap = new PriorityQueue<>(),
            maxHeap = new PriorityQueue<>();
    public void addNum(int num) {
        // WRITE YOUR BRILLIANT CODE HERE
        if (maxHeap.size() == 0) {
            maxHeap.add((double) -num);
        } else if (-maxHeap.peek() >= num) {
            maxHeap.add((double) -num);
        } else {
            minHeap.add((double) num);
        }
        balance();
    }

    public double getMedian() {
        // ALSO HERE
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + (-maxHeap.peek())) / 2.0;
        }else {
            return -maxHeap.peek();
        }
    }

    private void balance() {
        if (minHeap.size() == maxHeap.size() || maxHeap.size() - minHeap.size() == 1) {
            return;
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(-minHeap.poll());
            return;
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(-maxHeap.poll());
        }
    }
}
