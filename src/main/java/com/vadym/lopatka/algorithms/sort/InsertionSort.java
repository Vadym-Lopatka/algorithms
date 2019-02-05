package com.vadym.lopatka.algorithms.sort;


public class InsertionSort {

    public int[] sort(int[] arrayToSort, OrderType orderType) {
        if (arrayToSort.length == 0)
            return arrayToSort;

        return (OrderType.ASK.equals(orderType)) ? askSort(arrayToSort) : deskSort(arrayToSort);
    }

    private int[] askSort(int[] arrayToSort) {
        for (int i = 1; i < arrayToSort.length; i++) {
            int currentValue = arrayToSort[i];

            int previousPosition = i - 1;
            while (previousPosition >= 0 && arrayToSort[previousPosition] > currentValue) {
                arrayToSort[previousPosition + 1] = arrayToSort[previousPosition];
                previousPosition = previousPosition - 1;
            }
            arrayToSort[previousPosition + 1] = currentValue;
        }

        return arrayToSort;
    }

    private int[] deskSort(int[] arrayToSort) {

        for (int i = 1; i < arrayToSort.length; i++) {
            int currentValue = arrayToSort[i];

            int previousPosition = i - 1;
            while (previousPosition >= 0 && arrayToSort[previousPosition] < currentValue) {
                arrayToSort[previousPosition + 1] = arrayToSort[previousPosition];
                previousPosition = previousPosition - 1;
            }
            arrayToSort[previousPosition + 1] = currentValue;
        }

        return arrayToSort;
    }
}
