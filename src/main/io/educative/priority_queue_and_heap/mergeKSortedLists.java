package io.educative.priority_queue_and_heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem statement
 *
 * Given k sorted lists of numbers, merge them into one sorted list.
 * Example:
 *
 * Input: [[1, 3, 5], [2, 4, 6], [7, 10]]
 *
 * Output: [1, 2, 3, 4, 5, 6, 7, 10]
 *
 * Explanation
 * Intuition
 *
 * The first thing that comes to mind is that we can concatenate all the lists into one and then sort the list. This is O(N log(N))) because sorting is O(N log(N)) where N is the total length of all the lists.
 *
 * Next, we ask the question: “are there any conditions that we haven’t used?” We know that all the lists are sorted and we haven’t used that condition. For each list, the smallest number is the first number. We can take the first number of each list and put them into a “pool of top k smallest numbers”, where k is the number of lists. The smallest number in the pool is the smallest number of all the lists and should be added to the final merged list. We then take the next smallest number from the list and add it to the pool. Repeat until we have exhausted all the lists.
 *
 * Now the question is, “how do we compare a stream of k numbers?”, which is a perfect use case for a min heap.
 *
 */
// t.c. o(Nlog(N)), where N is the length of all the lists
public class mergeKSortedLists {
    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        // WRITE YOUR BRILLIANT CODE HERE
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.intValue()));

        for (List<Integer> list: lists) {
            for (Integer item: list) {
                queue.add(item);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] inputs = {"3","1"};
        String[][] inputs1 = {{"1 3 5", "2 4 6", "7 10"}, {"1 2 3"}};
        for(int i = 0; i < inputs.length; i++) {
            int n = Integer.parseInt(inputs[i]);
            List<List<Integer>> lists = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                List<Integer> list = Arrays.stream(inputs1[i][j].split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                lists.add(list);
            }
            System.out.println("Merge k sorted list : "+mergeKSortedLists(lists).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(" ")));
        }
    }
}

/**
 * t.c. o(Nlog(k)), where K is the number of lists
 * official answer
 *
 * import java.util.*;
 * import java.util.stream.Collectors;
 *
 * class Solution {
 *
 *     public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
 *       List<Integer> res = new ArrayList<>();
 *       PriorityQueue<Element> heap = new PriorityQueue<>(lists.size(), Comparator.comparingInt(e -> e.val));
 *       // push first number of each list into the heap
 *       for (List<Integer> list : lists) {
 *           heap.add(new Element(list.get(0), list, 0));  // 1
 *       }
 *       while (!heap.isEmpty()) {
 *           Element e = heap.poll();
 *           res.add(e.val);
 *           int headIndex = e.headIndex + 1;
 *           // if there are more numbers in the list, push into the heap
 *           if (headIndex < e.currentList.size()) {
 *               heap.add(new Element(e.currentList.get(headIndex), e.currentList, headIndex));
 *           }
 *       }
 *       return res;
 *     }
 *     private static class Element {
 *         private int val;
 *         private List<Integer> currentList;
 *         private int headIndex;
 *
 *         public Element(int val, List<Integer> currentList, int headIndex) {
 *             this.val = val;
 *             this.currentList = currentList;
 *             this.headIndex = headIndex;
 *         }
 *     }
 *     //Driver code
 *     public static void main(String[] arg){
 *       String[] inputs = {"3","1"};
 * 	    String[][] inputs1 = {{"1 3 5", "2 4 6", "7 10"}, {"1 2 3"}};
 *       for(int i = 0; i < inputs.length; i++) {
 *         int n = Integer.parseInt(inputs[i]);
 *         List<List<Integer>> lists = new ArrayList<>(n);
 *         for (int j = 0; j < n; j++) {
 *             List<Integer> list = Arrays.stream(inputs1[i][j].split(" ")).map(Integer::parseInt).collect(Collectors.toList());
 *             lists.add(list);
 *         }
 *         System.out.println("Merge k sorted list : "+Solution.mergeKSortedLists(lists).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(" ")));
 *       }
 *     }
 * }
 */
