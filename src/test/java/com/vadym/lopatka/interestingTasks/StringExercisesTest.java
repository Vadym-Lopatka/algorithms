package com.vadym.lopatka.interestingTasks;

import org.junit.Assert;
import org.junit.Test;

import static com.vadym.lopatka.interestingTasks.StringExercises.reverseString;

public class StringExercisesTest {

    @Test
    public void reverseStringTest() {
        String strToReverse = "gfedcba";
        Assert.assertEquals(reverseString(strToReverse), "abcdefg");
    }

    @Test
    public void reverseNumberAsStringTest() {
        String strToReverse = "1234567";
        Assert.assertEquals(reverseString(strToReverse), "7654321");
    }

    @Test
    public void reverseNullableStringTest() {
        String strToReverse = null;
        Assert.assertEquals(reverseString(strToReverse), "");
    }
}