package com.vadym.lopatka.algorithms;

public class SortingAlgorithms {

    public int[] insertionSort(int[] arrayToSort) {
        if (arrayToSort.length <=0)
            return arrayToSort;

        for (int i = 1; i < arrayToSort.length; i++) {
            int currentValue = arrayToSort[i];

            int previousPosition = i-1;
            while (previousPosition >= 0 && arrayToSort[previousPosition] > currentValue) {
                arrayToSort[previousPosition+1]=arrayToSort[previousPosition];
                previousPosition = previousPosition -1;
            }
            arrayToSort[previousPosition+1] = currentValue;
        }

        return arrayToSort;
    }
}
