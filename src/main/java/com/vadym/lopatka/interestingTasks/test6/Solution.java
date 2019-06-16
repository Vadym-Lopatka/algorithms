package com.vadym.lopatka.interestingTasks.test6;

public class Solution {

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int tmp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != (i + 1)) { //should we swap arr[i] ?

                // find other element to swap
                int j = i + 1;
                while (arr[j] != (i + 1)) {
                    j++;
                }

                // do swap
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{2, 3, 4, 1, 5})); //3
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7})); //3
    }
}
