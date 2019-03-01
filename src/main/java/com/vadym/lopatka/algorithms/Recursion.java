package com.vadym.lopatka.algorithms;

import java.util.Arrays;

public class Recursion {

    /**
     * Sum all integers in the array.
     *
     * It is clear that it is more effective to do it with a loop.
     * But I did it to show the approach with recursion.
     *
     * @param array
     * @return - the sum of the integers of the array
     */
    public static int sum(int[] array) {
        int length = array.length;

        if (length == 0)
            return 0;

        if (length == 1)
            return array[0];
        else
            return array[length - 1] + sum(Arrays.copyOf(array, length - 1));
    }

}
