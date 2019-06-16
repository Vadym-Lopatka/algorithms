package com.vadym.lopatka.algorithms.sort;

public class OneMoreInsertionSort {


    public static int[] askSort(int[] arr) {
        if (arr.length > 1) {
            int tmp;
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] < arr[j]) {
                        tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                    }
                }
            }
        }

        return arr;
    }


}
