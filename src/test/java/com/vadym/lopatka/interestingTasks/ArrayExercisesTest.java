package com.vadym.lopatka.interestingTasks;

import org.junit.Assert;
import org.junit.Test;


public class ArrayExercisesTest {

    @Test
    public void rotationLeftTest() {
        Assert.assertArrayEquals(
                new int[]{5, 1, 2, 3, 4},
                ArrayExercises.rotationLeft(new int[]{1, 2, 3, 4, 5}, 4)
        );
    }
}