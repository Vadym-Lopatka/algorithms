package com.vadym.lopatka.interestingTasks;

import org.junit.Assert;
import org.junit.Test;

import static com.vadym.lopatka.interestingTasks.StringExercises.*;

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

    @Test
    public void isStringUniquePositiveTest() {
        Assert.assertTrue(isStringContainsUniqueChars("abc \n*/+-"));
    }

    @Test
    public void isStringUniqueNegativeTest() {
        Assert.assertFalse(isStringContainsUniqueChars("aabc"));
    }

    @Test
    public void isStringUniqueNullableTest() {
        Assert.assertFalse(isStringContainsUniqueChars(null));
    }

    @Test
    public void isItPermutationPositiveTest() {
        Assert.assertTrue(isItPermutation("abc", "bca"));
    }

    @Test
    public void isItPermutationNegativeTest() {
        Assert.assertFalse(isItPermutation("abc", "abcd"));
        Assert.assertFalse(isItPermutation("abc", "xyz"));
    }

    @Test
    public void isItPermutationNullableTest() {
        Assert.assertFalse(isItPermutation(null, null));
        Assert.assertFalse(isItPermutation("", null));
        Assert.assertFalse(isItPermutation(null, ""));
    }

}