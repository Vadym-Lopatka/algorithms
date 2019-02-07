package com.vadym.lopatka.algorithms.sort;

public class MergeSort {

    public int[] sort(int[] arrayToSort, OrderType orderType) {
        return doMergeSort(arrayToSort, 0, arrayToSort.length / 2, arrayToSort.length);
    }

    // A, p ,q, r
    private int[] doMergeSort(int[] arrayToSort, int start, int middle, int finish) {
        int[] firstPart = new int[middle - start + 1];
        int[] secondPart = new int[finish - middle];

        for (int i = 0; i < firstPart.length; i++) {
            firstPart[i] = arrayToSort[start + i - 1];
        }
        for (int i = 0; i < secondPart.length; i++) {
            secondPart[i] = arrayToSort[middle + i];
        }

        return new int[0];
    }
}
