package io.educative.custom_data_structure;

import java.util.*;

// refer to https://www.enjoyalgorithms.com/blog/least-frequently-used-cache
// https://www.javatpoint.com/difference-between-hashmap-and-treemap

/**
 * Statement
 *
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class. Here is how it should be implemented:
 *
 *     LFUCache(capacity): This function initializes the object with the capacity of the data structure.
 *
 *     get(key): This function gets the value of the key if it exists in the cache. Otherwise, it returns -1.
 *
 *     put(key, value): This function updates the value of the key if present, or inserts the key if it’s not present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there’s a tie, that is, two or more keys have the same frequency, the least recently used key is invalidated.
 *
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key. When a key is first inserted into the cache, its use counter is set to 1 (due to the put() operation). The use counter for a key in the cache is incremented and either a get() or put() operation is called on it.
 *
 * The get() and put() functions should both run with an average time complexity of O(1)O(1).
 *
 * Constraints:
 *
 *     0≤0≤ capacity ≤104≤104
 *
 *     0≤0≤ key ≤105≤105
 *
 *     0≤0≤ value ≤109≤109
 *
 *     At most 2×1052×105 calls will be made to get() and put().
 *
 *     POINT: achieve o(1) for get and set
 */
public class LFUCache {
    private int capacity;
    private HashMap<Integer, Integer> hashMap; // key, value
    private HashMap<Integer, Integer> countMap; // key, count
    private TreeMap<Integer, List<Integer>> frequencyMap; // frequency, keys... (uses linkedlist to chain)

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
        this.frequencyMap = new TreeMap<>();
    }

    int get(int key) {
        // Your code will replace this placeholder return statement
        if (!hashMap.containsKey(key)) {
            return -1;
        }

        int frequency = countMap.get(key);
        frequencyMap.get(frequency).remove(key);

        if (frequencyMap.get(frequency).size() == 0) {
            frequencyMap.remove(frequency);
        }
        frequencyMap.computeIfAbsent(frequency + 1, k -> new LinkedList<>()).add(key); // create new linkedlist if absent, otherwise appends new key to the existing linkedlist

        countMap.put(key, frequency + 1);

        return hashMap.get(key);
    }

    void set(int key, int value) {
        // Check if the key exists in the cache hashmap
        if (hashMap.size() == capacity) {
            frequencyMap.remove(frequencyMap.firstKey());
        }

        if (hashMap.containsKey(key)) {
            hashMap.put(key, value);
            countMap.put(key, countMap.get(key) + 1);

            int frequency = countMap.get(key);
            frequencyMap.get(frequency).remove(key);
            frequencyMap.computeIfAbsent(frequency + 1, k -> new LinkedList<>()).add(key);
        } else {
            hashMap.put(key, value);
            countMap.put(key, 1);

            frequencyMap.computeIfAbsent(1, k -> new LinkedList<>()).add(key);
        }

        // If the key exists

        // Your code will replace this placeholder return statement

    }

    public static void main(String[] args) {

    }
}
