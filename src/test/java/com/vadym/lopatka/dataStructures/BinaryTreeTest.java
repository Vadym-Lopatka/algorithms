package com.vadym.lopatka.dataStructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    private BinaryTree binaryTree;
    private static final int MIN_VALUE = 1;
    private static final int MEDIUM_VALUE = 4;
    private static final int MAX_VALUE = 7;

    @Before
    public void beforeSetup() {
        /*
         *      The Tree
         *
         *        _4_
         *    __2____6__
         *   _1__3__5__7_
         *
         * */
        binaryTree = new BinaryTree();
        binaryTree.addAll(IntStream.of(MEDIUM_VALUE, 2, 6, MIN_VALUE, 3, 5, MAX_VALUE));
    }

    @Test
    public void addTest() {
        assertTrue(binaryTree.add(MIN_VALUE));
    }

    @Test
    public void addAllTest() {
        binaryTree.addAll(IntStream.of(MEDIUM_VALUE, MIN_VALUE, MAX_VALUE));
    }

    @Test
    public void getLowestTest() {
        assertEquals(MIN_VALUE, binaryTree.getLowest());
    }

    @Test
    public void getHighestTest() {
        assertEquals(MAX_VALUE, binaryTree.getHighest());
    }

    @Test
    public void inOrderTraversalTest() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), binaryTree.inOrderTraversal());
    }

    @Test
    public void preOrderTraversalTest() {
        assertEquals(Arrays.asList(4, 2, 1, 3, 6, 5, 7), binaryTree.preOrderTraversal());
    }

    @Test
    public void postOrderTraversalTest() {
        assertEquals(Arrays.asList(1, 3, 2, 5, 7, 6, 4), binaryTree.postOrderTraversal());
    }
}
