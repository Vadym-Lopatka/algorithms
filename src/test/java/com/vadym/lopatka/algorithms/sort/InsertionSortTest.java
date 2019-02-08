package com.vadym.lopatka.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {


    @Test
    public void insertionSortTest() {
        int[] unsortedArray = new int[]{5, 2, 4, 1, 3};
        Assert.assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                InsertionSort.sort(unsortedArray, OrderType.ASK)
        );
    }

    @Test
    public void insertionSortOrderedArrayTest() {
        int[] sortedArray = new int[]{1, 2, 3, 4, 5};
        Assert.assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                InsertionSort.sort(sortedArray, OrderType.ASK)
        );
    }

    @Test
    public void insertionSortNonUniqueValuesTest() {
        int[] sortedArray = new int[]{1, 1, 3, 4, 5};
        Assert.assertArrayEquals(
                new int[]{1, 1, 3, 4, 5},
                InsertionSort.sort(sortedArray, OrderType.ASK)
        );
    }


    @Test
    public void insertionSortEmptyArrTest() {
        int[] unsortedArray = new int[]{};
        Assert.assertArrayEquals(
                new int[]{},
                InsertionSort.sort(unsortedArray, OrderType.ASK)
        );
    }


    @Test
    public void DeskInsertionSortTest() {
        int[] unsortedArray = new int[]{5, 2, 4, 1, 3};
        Assert.assertArrayEquals(
                new int[]{5, 4, 3, 2, 1},
                InsertionSort.sort(unsortedArray, OrderType.DESK)
        );
    }

    @Test
    public void DeskInsertionSortOrderedArrayTest() {
        int[] sortedArray = new int[]{5, 4, 3, 2, 1};
        Assert.assertArrayEquals(
                new int[]{5, 4, 3, 2, 1},
                InsertionSort.sort(sortedArray, OrderType.DESK)
        );
    }

    @Test
    public void DeskInsertionSortNonUniqueValuesTest() {
        int[] sortedArray = new int[]{1, 1, 3, 4, 5};
        Assert.assertArrayEquals(
                new int[]{5, 4, 3, 1, 1},
                InsertionSort.sort(sortedArray, OrderType.DESK)
        );
    }


    @Test
    public void DeskInsertionSortEmptyArrayTest() {
        int[] unsortedArray = new int[]{};
        Assert.assertArrayEquals(
                new int[]{},
                InsertionSort.sort(unsortedArray, OrderType.DESK)
        );
    }
}