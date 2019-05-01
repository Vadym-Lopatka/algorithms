package com.vadym.lopatka.dataStructures;

/**
 * Stack
 */
public class LiFoLinkedListImpl implements MyLinkedList {
    private static final int defaultStoreSize = 2;
    private int[] store;
    private int size;

    public LiFoLinkedListImpl() {
        this(defaultStoreSize);
    }

    public LiFoLinkedListImpl(int storeSize) {
        this.store = new int[storeSize];
        size = 0;
    }

    @Override
    public void add(int element) {
        if (size >= store.length)
            increaseStoreCapacity();

        store[size] = element;
        size++;
    }

    @Override
    public int get() {
        int index = size - 1;
        int theElement = store[index];

        removeElement(index);
        return theElement;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void increaseStoreCapacity() {
        int newCapacity = store.length * 2;
        int[] ints = new int[newCapacity];
        System.arraycopy(this.store, 0, ints, 0, store.length);

        this.store = ints;
    }

    private void removeElement(int index) {
        store[index] = 0;
        size--;
    }


}
