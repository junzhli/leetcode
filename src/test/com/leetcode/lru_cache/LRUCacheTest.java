package com.leetcode.lru_cache;

import com.leetcode.linked_list_cycle.Solution;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void all() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        assertEquals(-1, cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        assertEquals(-1, cache.get(1));       // returns -1 (not found)
        assertEquals(3, cache.get(3));       // returns 3
        assertEquals(4, cache.get(4));       // returns 4

        /**
         * LRUCache cache = new LRUCache(2);
 *         ["LRUCache","put","get","put","get","get"]
         * [[1],[2,1],[2],[3,2],[2],[3]]
         */
        LRUCache cache2 = new LRUCache(1);
        cache2.put(2, 1);
        assertEquals(1, cache2.get(2));
        cache2.put(3, 2);
        assertEquals(-1, cache2.get(2));
        assertEquals(2, cache2.get(3));

        /**
         * ["LRUCache","put","put","put","put","get","get"]
         * [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
         */
        LRUCache cache3 = new LRUCache(2);
        cache3.put(2, 1);
        cache3.put(1, 1);
        cache3.put(2, 3);
        cache3.put(4, 1);
        assertEquals(-1, cache3.get(1));
        assertEquals(3, cache3.get(2));

        /**
         * ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
         * [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
         */
        LRUCache cache4 = new LRUCache(3);
        cache4.put(1, 1);
        cache4.put(2, 2);
        cache4.put(3, 3);
        cache4.put(4, 4);
        assertEquals(4, cache4.get(4));
        assertEquals(3, cache4.get(3));
        assertEquals(2, cache4.get(2));
        assertEquals(-1, cache4.get(1));
        cache4.put(5, 5);
        assertEquals(-1, cache4.get(1));
        assertEquals(2, cache4.get(2));
        assertEquals(3, cache4.get(3));
        assertEquals(-1, cache4.get(4));
        assertEquals(5, cache4.get(5));

        System.out.println("==============");
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(2) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > 2;
            }
        };

        map.put(2,1);
        map.put(1,1);
        map.put(2,3);
        map.put(4,1);
//        map.get(1);
//        map.get(2);
        for (Integer k: map.keySet()) {
            System.out.println(k);
        }

    }
}