package com.vadym.lopatka.dataStructures.heap;

public class MaxHeap {
    private int[] store;
    private int size;

    public MaxHeap(int capacity) {
        store = new int[capacity + 1];
        size = 0;
        store[0] = Integer.MAX_VALUE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == store.length - 1;
    }


    public void add(int value) {
        if (isFull())
            throw new IllegalStateException("the heap is full");
        store[++size] = value;

        // Traverse up and fix violated property
        int current = size;
        while (store[current] > store[getParentPosition(current)]) {
            swap(current, getParentPosition(current));
            current = getParentPosition(current);
        }
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = store[fpos];
        store[fpos] = store[spos];
        store[spos] = tmp;
    }

    public void addAll(int[] values) {
        for (int value : values) {
            add(value);
        }
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (store[pos] < store[getLeftChildPosition(pos)] ||
                store[pos] < store[getRightChildPosition(pos)]) {

            if (store[getLeftChildPosition(pos)] > store[getRightChildPosition(pos)]) {
                swap(pos, getLeftChildPosition(pos));
                maxHeapify(getRightChildPosition(pos));
            } else {
                swap(pos, getRightChildPosition(pos));
                maxHeapify(getRightChildPosition(pos));
            }
        }
    }

    private boolean isLeaf(int position) {
        return position >= (size / 2) && position <= size;
    }

    private int getRightChildPosition(int position) {
        return (2 * position) + 1;
    }

    private int getLeftChildPosition(int position) {
        return (2 * position);
    }

    private int getParentPosition(int pos) {
        return pos / 2;
    }

    public int getMax() {
        if (isEmpty())
            throw new IllegalStateException("heap is empty");

        return store[1];
    }

    public int extractMax() {
        int popped = store[1];
        store[1] = store[size--];
        maxHeapify(1);
        return popped;
    }
}
