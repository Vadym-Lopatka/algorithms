package com.vadym.lopatka.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import static com.vadym.lopatka.algorithms.sort.OneMoreInsertionSort.askSort;

public class OneMoreInsertionSortTest {

    @Test
    public void askSortTest() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, askSort(new int[]{5, 2, 4, 1, 3}));
    }

    @Test
    public void askSortWithNegativesTest() {
        Assert.assertArrayEquals(new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3}, askSort(new int[]{-5, 1, 3, 2, -2, -4, -1, -3, 0}));
    }

    @Test
    public void askSortOneSizeTest() {
        Assert.assertArrayEquals(new int[]{1}, askSort(new int[]{1}));
    }

    @Test
    public void askSortEmptyArrayTest() {
        Assert.assertArrayEquals(new int[0], askSort(new int[0]));
    }
}