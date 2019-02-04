package com.vadym.lopatka.algorithms;

public class SortingAlgorithms {

    public int[] insertionSort(int[] unsortedArray) {
        if (unsortedArray.length <=0)
            return unsortedArray;

        int[] sortedArray = new int[unsortedArray.length];
        for (int i = 0; i < unsortedArray.length; i++) {
            int currentValue = unsortedArray[i];

            int previousPosition = i-1;
            while (previousPosition > 0 && unsortedArray[previousPosition] > currentValue) {
                sortedArray[previousPosition+1]=unsortedArray[previousPosition];
                previousPosition = previousPosition -1;
            }
            sortedArray[previousPosition+1] = currentValue;
        }

        return sortedArray;
    }
}
