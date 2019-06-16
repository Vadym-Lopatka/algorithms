package com.vadym.lopatka.interestingTasks.test7;

import org.junit.Test;

import static com.vadym.lopatka.interestingTasks.test7.Sol.arrayManipulation;
import static org.junit.Assert.*;

public class SolTest {

    @Test
    public void arrayManipulationTest() {

        int[][] queries = new int[4][3];
        queries[0] = new int[]{2, 6, 8};
        queries[1] = new int[]{3, 5, 7};
        queries[2] = new int[]{1, 8, 1};
        queries[3] = new int[]{5, 9, 15};

        assertEquals(31, arrayManipulation(10, queries));
    }
}