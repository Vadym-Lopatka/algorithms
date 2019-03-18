package com.vadym.lopatka.interestingTasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.vadym.lopatka.interestingTasks.LinkedListOperations.sumTwoLists;

public class LinkedListOperationsTest {

    private LinkedNode list1;
    private LinkedNode list2;
    private LinkedNode result;

    @Before
    public void setUp() throws Exception {
        LinkedNode l3 = new LinkedNode(3);
        LinkedNode l2 = new LinkedNode(4);
        list1 = new LinkedNode(2); // 243
        list1.next = l2;
        l2.next = l3;

        LinkedNode k3 = new LinkedNode(4);
        LinkedNode k2 = new LinkedNode(6);
        list2 = new LinkedNode(5); // 564
        list2.next = k2;
        k2.next = k3;

        LinkedNode r3 = new LinkedNode(8);
        LinkedNode r2 = new LinkedNode(0);
        result = new LinkedNode(7); // 807
        result.next = r2;
        r2.next = r3;
    }

    @Test
    public void sumTwoListsTest() {
        LinkedNode actual = sumTwoLists(list1, list2);
        Assert.assertEquals(result.toString(), actual.toString());
    }
}