package com.vadym.lopatka.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void insertionSortTest() {
        int[] unsortedArray = new int[]{5, 12, 40, 1, 8};
        MergeSort.sort(unsortedArray, unsortedArray.length);
        Assert.assertArrayEquals(
                new int[]{1, 5, 8, 12, 40}, unsortedArray
        );
    }
}