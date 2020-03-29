package com.leetcode.lru_cache;

import java.util.HashMap;

/**
 * We can leverage with double linked list and hash-map to solve this problem:
 * Double linked list keeps track of those key-value in least-access order like queue
 * Hash-map helps fast access to each key-value
 * (1) invalidate the least used data from LRU if exceeds with capped number of key-values
 * (1 - 1) get: if found, move it to head (remove + insert to head)
 * (1 - 2) put: if same key exists, move it to head and overwrite its value
 * (1 - 3) put: if not exists, create a node for this key-value and insert it to head
 * (2) return -1 if requested key-value is not cached
 * (2) remove and insert to head: check if either tail or head gets involved and re-link
 */

public class LRUCache {
    class LinkedList {
        public LinkedList next;
        public LinkedList prev;
        public int val;
        public int key;

        public LinkedList(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    /**
     * tail <-> node1 <-> node2 <-> node 3 <-> .... <-> head
     */
    private HashMap<Integer, LinkedList> indexMap;
    private LinkedList head;
    private LinkedList tail;
    private int capped;
    private int capacity;

    public LRUCache(int capacity) {
        indexMap = new HashMap<>();
        this.capacity = capacity;
        this.capped = 0;
    }

    public int get(int key) {
        LinkedList node = indexMap.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }

        removeNode(node);
        insertToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        LinkedList node = indexMap.getOrDefault(key, null);
        if (node == null && capped == capacity) { // remove the least used key-value if exceeds its capped number of caches
            indexMap.remove(tail.key);
            removeNode(tail);
            capped--;
        }

        if (node != null) {
            node.val = value;
            removeNode(node);
        } else {
            node = new LinkedList(value, key);
            indexMap.put(key, node);
            capped++;
        }
        insertToHead(node);
    }

    private void removeNode(LinkedList node) {
        // remove from doubly linked list
        if (head == node) {
            head = node.next;
        }

        if (tail == node) {
            tail = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    private void insertToHead (LinkedList node){
        if (head == null && tail == null) {
            head = node;
            tail = node;
            return;
        }

        LinkedList oldHead = head;
        head = node;
        head.next = oldHead;
        oldHead.prev = head;
        head.prev = null;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */