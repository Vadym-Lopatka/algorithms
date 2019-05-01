package com.vadym.lopatka.algorithms.sort;

public class MergeSort {

    /**
     * the most popolar implementation of merge sort
     *
     * @param arrayToSort - the array that will be sorted
     * @param length      - array's length
     */
    public static void sort(int[] arrayToSort, int length) {

        if (length < 2)
            return;

        int mid = length / 2;
        int[] leftPart = new int[mid];
        int[] rightPart = new int[length - mid];

        for (int i = 0; i < mid; i++)
            leftPart[i] = arrayToSort[i];

        for (int i = mid; i < length; i++)
            rightPart[i - mid] = arrayToSort[i];

        sort(leftPart, mid);
        sort(rightPart, length - mid);

        merge(arrayToSort, leftPart, rightPart, mid, length - mid);
    }


    public static void merge(
            int[] arrayToSort, int[] leftPart, int[] rightPart, int leftBorder, int rightBorder) {

        int i = 0, j = 0, k = 0;
        while (i < leftBorder && j < rightBorder) {
            if (leftPart[i] <= rightPart[j]) {
                arrayToSort[k++] = leftPart[i++];
            } else {
                arrayToSort[k++] = rightPart[j++];
            }
        }
        while (i < leftBorder) {
            arrayToSort[k++] = leftPart[i++];
        }
        while (j < rightBorder) {
            arrayToSort[k++] = rightPart[j++];
        }
    }
}
