package io.educative.priority_queue_and_heap;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueImplTest {

    @Test
    void priorityQueueImpl() {
        int[] arr = new int[]{1,3,2};
        PriorityQueueImpl<Integer> minHeap = new PriorityQueueImpl<>();
        for (int a: arr) {
            minHeap.push(new DataItem<>(a, a));
        }

        System.out.println(minHeap.pop().toString());
        System.out.println(minHeap.pop().toString());
        System.out.println(minHeap.pop().toString());
    }
}