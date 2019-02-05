package com.vadym.lopatka.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortingAlgorithmsTest {

    private SortingAlgorithms algorithms;

    @Before
    public void before() {
        algorithms = new SortingAlgorithms();
    }

    @Test
    public void insertionSortTest() {
        int[] unsortedArray = new int[]{5, 2, 4, 1, 3};
        Assert.assertArrayEquals(algorithms.insertionSort(unsortedArray), new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void insertionSortOrderedArrayTest() {
        int[] sortedArray = new int[]{1, 2, 3, 4, 5};
        Assert.assertArrayEquals(algorithms.insertionSort(sortedArray), new int[]{1, 2, 3, 4, 5});
    }
    @Test
    public void insertionSortNonUniqueValuesTest() {
        int[] sortedArray = new int[]{1, 1, 3, 4, 5};
        Assert.assertArrayEquals(algorithms.insertionSort(sortedArray), new int[]{1, 1, 3, 4, 5});
    }


    @Test
    public void insertionSortEmptyArrTest() {
        int[] unsortedArray = new int[]{};
        Assert.assertArrayEquals(algorithms.insertionSort(unsortedArray), new int[]{});
    }
}