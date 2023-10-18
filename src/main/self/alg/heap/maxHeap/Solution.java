package self.alg.heap.maxHeap;

// round 2
// good read
// https://medium.com/@ankur.singh4012/implementing-max-heap-in-java-ea368dadd273
public class Solution {
    static class MaxHeap implements self.alg.heap.maxHeap.MaxHeap {
        private int curSize;
        private int maxSize;
        private int[] heapTree;

        public MaxHeap(int maxSize) {
            this.maxSize = maxSize;
            this.heapTree = new int[this.maxSize + 1]; // index 0 is reversed for nothing. as it'll be easier to traverse its parent or child with n/2 or 2*n, 2*n + 1
            this.curSize = 0;
            this.heapTree[0] = Integer.MAX_VALUE; //!!!!!! important
        }

        @Override
        public void insert(int element) {
            if (curSize >= maxSize) {
                return;
            }

            heapTree[++curSize] = element;

            int current = curSize;
            while (heapTree[current] > heapTree[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        @Override
        public void print() {
            for (int i = 1; i <= curSize / 2; i++) {
                System.out.print(" PARENT : " + heapTree[i]
                        + " LEFT CHILD : " + heapTree[2 * i]
                        + " RIGHT CHILD :" + heapTree[2 * i + 1]);
                System.out.println();
            }
        }

        @Override
        public void maxHeap() {
            for (int i = curSize / 2; i >= 1; i--) { // start from the parent of curSize pos to be more efficient (since no child node under curSize pos)
                maxHeapify(i);
            }
        }

        @Override
        public int remove() {
            int popped = heapTree[1]; // remove the top one out of the heap
            heapTree[1] = heapTree[curSize--]; // move the last element to the top for decreasing the heap curr size;
            maxHeapify(1); // heapify again
            return popped;
        }

        private int parent(int curr) {
            return curr / 2;
        }

        private int leftChild(int curr) {
            return curr * 2;
        }

        private int rightChild(int curr) {
            return curr * 2 + 1;
        }

        private void swap(int a, int b) {
            int tmp = heapTree[a];
            heapTree[a] = heapTree[b];
            heapTree[b] = tmp;
        }

        private boolean isLeaf(int pos) {
            return (pos * 2 >= curSize && pos >= curSize);
        }

        private void maxHeapify(int pos) {
            if (isLeaf(pos)) {
                return;
            }

            if (heapTree[pos] < heapTree[leftChild(pos)] ||
            heapTree[pos] < heapTree[rightChild(pos)]) {
                if (heapTree[leftChild(pos)] < heapTree[rightChild(pos)]) {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                } else {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();

        maxHeap.print();
        System.out.println("The Max val is " + maxHeap.remove());
    }
}
