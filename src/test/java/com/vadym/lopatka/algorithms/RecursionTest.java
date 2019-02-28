package com.vadym.lopatka.algorithms;

import org.junit.Assert;
import org.junit.Test;

import static com.vadym.lopatka.algorithms.Recursion.sum;
import static org.junit.Assert.*;

public class RecursionTest {

    @Test
    public void sumTestBaseCase() {
        int[] array = {5, 0, 3, 2};
        Assert.assertEquals(10, sum(array));
    }

    @Test
    public void sumTestWithNegatives() {
        int[] array = {5, 0, 3, 2, 5, -5};
        Assert.assertEquals(10, sum(array));
    }

    @Test
    public void sumTestZeroLength() {
        int[] array = {};
        Assert.assertEquals(0, sum(array));
    }

    @Test
    public void sumTestWithOneElement() {
        int[] array = {5};
        Assert.assertEquals(5, sum(array));
    }

}