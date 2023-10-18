package io.educative.priority_queue_and_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class DataItem<T> {
    private T data;

    public T getData() {
        return data;
    }

    public int getPriority() {
        return priority;
    }

    private int priority;

    public DataItem(T data, int priority) {
        this.data = data;
        this.priority = priority;
    }
}

public class PriorityQueueImpl<T> { // minHeap, root element should contain the lowest priority number
    private List<DataItem<T>> data;

    public PriorityQueueImpl() {
        this.data = new ArrayList<>();
    }

    private int getParent(int index) {
        return Math.floorDiv((index - 1), 2);
    }

    private int getLeftChild(int index) {
        return index * 2 + 1; // ##### index * 2 only applies to array index starting from 1
    }

    private int getRightChild(int index) {
        return getLeftChild(index) + 1; // #### index * 2 + 1 only applies to array index starting from 1
    }

    private void bubbleDown() {
        int index = 0;
        int min = index;
        int n = this.data.size();
        while (index < n) {
            int leftChild = getLeftChild(index);
            int rightChild = getRightChild(index);
            if ((leftChild < n && (this.data.get(leftChild).getPriority() < this.data.get(min).getPriority())) ||
                    (rightChild < n && (this.data.get(rightChild).getPriority() < this.data.get(min).getPriority()))
            ) {
                if (rightChild < n) { // check if rightChild is overflow, otherwise we only check our leftChild
                    min = this.data.get(leftChild).getPriority() < this.data.get(rightChild).getPriority()
                            ? leftChild : rightChild;
                } else {
                    min = leftChild;
                }
            }

            if (min == index) {
                break;
            }
            swap(this.data, min, index);
            index = min;
        }
    }

    private void swap (List<DataItem<T>> array, int x, int y) {
        DataItem<T> tmp = array.get(x);
        array.set(x, array.get(y));
        array.set(y, tmp);
    }

    private void bubbleUp() {
        int index = this.data.size() - 1;
        while (index > 0) {
            int parent = getParent(index);
            if (this.data.get(parent).getPriority() <= this.data.get(index).getPriority()) {
                break;
            }
            swap(this.data, parent, index);
            index = parent;
        }
    }

    public void push(DataItem<T> item) {
        this.data.add(item);
        this.bubbleUp();
    }

    public T pop() {
        DataItem<T> item = this.data.get(0);
        this.data.set(0, this.data.get(this.data.size() - 1)); // swap elements at index 0 and last
        this.data.remove(this.data.get(this.data.size() - 1)); // remove last element from array, shrink size
        this.bubbleDown();
        return item.getData();
    }
}
