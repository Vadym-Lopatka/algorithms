package com.vadym.lopatka.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private MergeSort algorithm;

    @Before
    public void before() {
        algorithm = new MergeSort();
    }


    @Test
    public void insertionSortTest() {
        int[] unsortedArray = new int[]{5, 12, 40, 1, 8};
        Assert.assertArrayEquals(
                new int[]{1, 5, 8, 12, 40},
                algorithm.sort(unsortedArray, OrderType.ASK)
        );
    }

//    @Test
//    public void insertionSortOrderedArrayTest() {
//        int[] sortedArray = new int[]{1, 2, 3, 4, 5};
//        Assert.assertArrayEquals(
//                new int[]{1, 2, 3, 4, 5},
//                algorithm.sort(sortedArray, OrderType.ASK)
//        );
//    }
//
//    @Test
//    public void insertionSortNonUniqueValuesTest() {
//        int[] sortedArray = new int[]{1, 1, 3, 4, 5};
//        Assert.assertArrayEquals(
//                new int[]{1, 1, 3, 4, 5},
//                algorithm.sort(sortedArray, OrderType.ASK)
//        );
//    }
//
//
//    @Test
//    public void insertionSortEmptyArrTest() {
//        int[] unsortedArray = new int[]{};
//        Assert.assertArrayEquals(
//                new int[]{},
//                algorithm.sort(unsortedArray, OrderType.ASK)
//        );
//    }


}