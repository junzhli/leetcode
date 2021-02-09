package self.alg.heap.minHeap;

public class Solution {
    static class MinHeap implements self.alg.heap.minHeap.MinHeap {
        private int curSize;
        private int maxSize;
        private int[] heapTree;

        public MinHeap(int maxSize) {
            this.maxSize = maxSize;
            this.heapTree = new int[this.maxSize + 1]; // index 0 is reversed for nothing. as it'll be easier to traverse its parent or child with n/2 or 2*n, 2*n + 1
            this.curSize = 0;
            this.heapTree[0] = Integer.MIN_VALUE; //!!!!!! important
        }

        @Override
        public void insert(int element) {
            if (curSize >= maxSize) {
                return;
            }

            heapTree[++curSize] = element;

            int current = curSize;
            while (heapTree[current] < heapTree[parent(current)]) {
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
        public void minHeap() {
            for (int i = curSize / 2; i >= 1; i--) {
                minHeapify(i);
            }
        }

        @Override
        public int remove() {
            int popped = heapTree[1]; // remove the top one out of the heap
            heapTree[1] = heapTree[curSize--]; // move the last element to the top for decreasing the heap curr size;
            minHeapify(1); // heapify again
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

        private void minHeapify(int pos) {
            if (isLeaf(pos)) {
                return;
            }

            if (heapTree[pos] > heapTree[leftChild(pos)] ||
            heapTree[pos] > heapTree[rightChild(pos)]) {
                if (heapTree[leftChild(pos)] > heapTree[rightChild(pos)]) { //   5
                    swap(pos, rightChild(pos));                             //  ' '
                    minHeapify(rightChild(pos));                            //  3 2
                } else {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }
}
