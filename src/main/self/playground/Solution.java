package self.playground;

import java.util.*;

public class Solution {

    /**
     * Quick sort
     * @param array
     * @return
     */
    public int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    private int[] quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }

        int positionPivot = partition(array, start, end);
        quickSort(array, start, positionPivot - 1);
        quickSort(array, positionPivot + 1, end);
        return array;
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                swap(array, ++i, j);
            }
        }

        swap(array, i + 1, end);
        return i + 1;
    }

    private void swap(int[] array, int positionX, int positionY) {
        int tmp = array[positionX];
        array[positionX] = array[positionY];
        array[positionY] = tmp;
    }

    /**
     * Merge Sort
     * @param
     */
    public int[] mergeSort(int[] array) {
        return split(array);
    }

    private int[] split(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int mid = array.length / 2;

        return sort(split(Arrays.copyOfRange(array, 0, mid)), split(Arrays.copyOfRange(array, mid, array.length)));
    }

    private int[] sort(int[] arrayA, int[] arrayB) {
        int r = 0;
        int[] arrayRet = new int[arrayA.length + arrayB.length];

        int a = 0;
        int b = 0;
        while (a < arrayA.length || b < arrayB.length) {
            if (a < arrayA.length && b < arrayB.length) {
                if (arrayA[a] <= arrayB[b]) {
                    arrayRet[r] = arrayA[a++];
                } else {
                    arrayRet[r] = arrayB[b++];
                }
            } else if (a < arrayA.length) {
                arrayRet[r] = arrayA[a++];
            } else {
                arrayRet[r] = arrayB[b++];
            }
            r++;
        }

        return arrayRet;
    }

    /**
     * Heap sort
     * @param args
     */
    class MinHeap {
        private final int MAX_SIZE;
        private int currentSize;
        private int[] array;

        MinHeap(int maxSize) {
            if (maxSize < 0) {
                throw new IllegalArgumentException("maxSize must be greater than 0");
            }

            this.MAX_SIZE = maxSize;
            this.currentSize = 0;
            this.array = new int[maxSize + 1];
        }

        void insert(int element) {
            array[++currentSize] = element;
            minHeapify(1);
        }

        int minPeak() {
            return array[1];
        }

        private void minHeapify(int position) {
            if (isLeaf(position)) {
                return;
            }

            if (array[position] > array[leftChild(position)]) {
                swap(position, leftChild(position));
                minHeapify(leftChild(position));
            }

            if (array[position] > array[rightChild(position)]) {
                swap(position, rightChild(position));
                minHeapify(rightChild(position));
            }
        }

        private int leftChild(int position) {
            return position * 2;
        }

        private int rightChild(int position) {
            return position * 2 + 1;
        }

        private boolean isLeaf(int position) {
            return leftChild(position) > MAX_SIZE || rightChild(position) > MAX_SIZE;
        }

        private void swap(int x, int y) {
            int tmp = array[x];
            array[x] = array[y];
            array[y] = tmp;
        }
    }

    /**
     * Topological sort
     * @param args
     */
    static class Graph {
        boolean[] visited;
        ArrayList<Integer>[] neighbors;

        Graph(int vertices) {
            visited = new boolean[vertices];
            neighbors = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                neighbors[i] = new ArrayList<Integer>();
            }
        }
    }

    public static void main(String[] args) {
//        int[] array = new int[] {2,1,5,70,0,6};
//        Solution sol = new Solution();
//        int[] sortedArr = sol.quickSort(array);
//        int[] sortedArr = sol.mergeSort(array);
//        for (int element: sortedArr) {
//            System.out.println(element);
//        }
        HashSet<List<Integer>> abc = new HashSet<>();
        List<Integer> a = Arrays.asList(1,2,3);
        List<Integer> b = Arrays.asList(1,3,2);
        Collections.sort(b);
        abc.add(a);
        System.out.println(abc.contains(b));


        // topological sort
        /**
         * g.addEdge(5, 2);
         *         g.addEdge(5, 0);
         *         g.addEdge(4, 0);
         *         g.addEdge(4, 1);
         *         g.addEdge(2, 3);
         *         g.addEdge(3, 1);
         */
//        Graph graph = new Graph(6);
//        graph.neighbors[5].add(2);
//        graph.neighbors[5].add(0);
//        graph.neighbors[4].add(0);
//        graph.neighbors[4].add(1);
//        graph.neighbors[2].add(3);
//        graph.neighbors[3].add(1);
//        sol.topicalSort(graph);

//        List<Integer> m = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> n = Arrays.asList(2,4,5);
//        ArrayList<Integer> res = sol.findBoth(m, n);
//        res.forEach(System.out::println);

    }

    public ArrayList<Integer> findBoth(ArrayList<Integer> m, ArrayList<Integer> n) {
        if (m.size() == 0 || n.size() == 0) {
            return new ArrayList<>();
        }

        HashSet<Integer> nSet = new HashSet<>(n);
        HashSet<Integer> res = new HashSet<>();
        for (Integer value: n) {
            if (nSet.contains(value)) {
                res.add(value);
            }
        }

        return new ArrayList<>(res);

//        Collections.sort(m);
//        Collections.sort(n);
//        //
//        int i = 0;
//        int j = 0;
//        HashSet<Integer> res = new HashSet<>();
//        while (i < m.size() && j < n.size()) {
//            int valX = m.get(i);
//            int valY = n.get(j);
//            if (valX > valY) {
//                j++;
//            } else if (valY > valX) {
//                i++;
//            } else {
//                res.add(valX);
//                i++;
//                j++;
//            }
//        }
//        return new ArrayList<>(res);
    }

    public void topicalSort(Graph g) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < g.visited.length; i++) {
            if (g.visited[i]) {
                continue;
            }

            helper(g, stack, i);
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    private void helper(Graph graph, Stack stack, int i) {
        graph.visited[i] = true;

        for (Integer neighbor: graph.neighbors[i]) {
            if (graph.visited[neighbor]) {
                continue;
            }

            helper(graph, stack, neighbor);
        }

        stack.push(i);
    }
}
