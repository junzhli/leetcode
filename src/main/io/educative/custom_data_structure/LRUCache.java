package io.educative.custom_data_structure;

import java.util.*;

/**
 * Statement
 *
 * Implement an LRU cache class with the following functions:
 *
 *     Init(capacity): Initializes an LRU cache with the capacity size.
 *     Set(key, value): Adds a new key-value pair or updates an existing key with a new value.
 *     Get(key): Returns the value of the key, or −1−1 if the key does not exist.
 *
 * If the number of keys has reached the cache capacity, evict the least recently used key and then add the new key.
 *
 * As caches use relatively expensive, faster memory, they are not designed to store very large data sets. Whenever the cache becomes full, we need to evict some data from it. There are several caching algorithms to implement a cache eviction policy. LRU is a very simple and commonly used algorithm. The core concept of the LRU algorithm is to evict the oldest data from the cache to accommodate more data.
 Constraints:

 1≤1≤ capacity ≤3000≤3000
 0≤0≤ key ≤104≤104
 0≤0≤ value ≤105≤105
 At most 2×1052×105 calls will be made to Set and Get.


 Optimized approach using a doubly linked list and a hash map

 This problem can be solved efficiently if we combine two data structures and use their respective functionalities, as well as the way they interact with each other, to our advantage. A doubly linked list allows us to arrange nodes by the time they were last accessed. However, accessing a value in a linked list is O(n)O(n). On the other hand, a hash table has O(1)O(1) lookup time, but has no concept of recency. We can combine these two data structures to get the best properties of both.

 Here is the algorithm for the LRU cache:

 Set:

 If the element exists in the hash map, then update its value and move the corresponding linked list node to the head of the linked list.
 Otherwise, if eviction is needed— that is, if the cache is already full— remove the tail element from the doubly linked list. Then delete its hash map entry, add the new element at the head of the linked list, and add the new key-value pair to the hash map.

 Get:

 If the element exists in the hash map, move the corresponding linked list node to the head of the linked list and return the element value.
 Otherwise, return -1.

 Note that the doubly linked list is used to keep track of the most recently accessed elements. The element at the head of the doubly linked list is the most recently accessed element. All newly inserted elements (in Set) go to the head of the list. Similarly, any element accessed (in the Get operation) goes to the head of the list.
 */

/**
 * Solution summary
 *
 * To set a new value, first we need to verify whether the given key exists or not. If it exists, update its value and move it to the front of the linked list. If it doesn’t, add the new pair at the front of the linked list if we have enough space to add a new element. If the cache is already filled, evict the LRU element and add the new one at the front of the linked list. In order to get a value for the given key, return −1−1 if we don’t have such a key available in the hash map. Otherwise, move the node on the head of the linked list as the most recently used value and return the value corresponding to the given key.
 * Time complexity
 *
 * The time complexity bounds of the LRU cache operations are given below:
 *
 *     Get:  O(1) O(1)
 *     Set:  O(1) O(1)
 *
 * Space complexity
 *
 * The space complexity of this solution is O(n)O(n), where nn is the size of the cache.
 */
public class LRUCache {
    // Constructor that sets the size of the cache
    private int capacity;
    private LinkedHashMap<Integer, Integer> hashMap;
    public LRUCache(int size) {
        this.capacity = size;
        this.hashMap = new LinkedHashMap<Integer, Integer>(capacity);
        // Write your code here
    }

    int get(int key) {
        // Your code will replace this placeholder return statement
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        int value= hashMap.get(key);
        hashMap.remove(key);
        hashMap.put(key, value);
        return value;
    }

    void set(int key, int value) {
        // Check if the key exists in the cache hashmap
        // If the key exists
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, value);
        } else {
            hashMap.remove(key);
            hashMap.put(key, value);
        }

        if (hashMap.size() > capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
            int keyBeRemoved = iterator.next().getKey();
            hashMap.remove(keyBeRemoved);
        }
        // Your code will replace this placeholder return statement
    }

    public static void main(String[] args) {

    }
}
