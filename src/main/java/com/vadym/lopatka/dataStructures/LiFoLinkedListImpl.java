package com.vadym.lopatka.dataStructures;

public class LiFoLinkedListImpl implements MyLinkedList {
    private int[] store;
    private int size;
    private static final int defaultStoreSize = 10;

    public LiFoLinkedListImpl() {
        this(defaultStoreSize);
    }

    public LiFoLinkedListImpl(int storeSize) {
        this.store = new int[storeSize];
        size = 0;
    }

    @Override
    public void add(int element) {
        int position = store.length - size - 1;
        store[position] = element;
        size++;
    }

    @Override
    public int get() {
        int index = store.length - size;
        int theElement = store[index];

        removeElement(index);
        return theElement;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void removeElement(int index) {
        store[index]=0;
        size--;
    }



}
