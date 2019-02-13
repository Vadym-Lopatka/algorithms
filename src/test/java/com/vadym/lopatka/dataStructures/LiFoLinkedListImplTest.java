package com.vadym.lopatka.dataStructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LiFoLinkedListImplTest {
    private MyLinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new LiFoLinkedListImpl();
    }

    @Test
    public void add() {
        linkedList.add(3);
        linkedList.add(33);
        linkedList.add(333);

        Assert.assertEquals(3, linkedList.getSize());
    }

    @Test
    public void get() {
        linkedList.add(1);
        linkedList.add(11);
        linkedList.add(111);

        Assert.assertEquals(111, linkedList.get());
        Assert.assertEquals(11, linkedList.get());
        Assert.assertEquals(1, linkedList.get());
    }
}