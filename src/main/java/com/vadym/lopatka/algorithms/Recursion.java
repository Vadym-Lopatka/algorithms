package com.vadym.lopatka.algorithms;

import java.util.Arrays;

public class Recursion {

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
