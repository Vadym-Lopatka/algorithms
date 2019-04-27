package com.vadym.lopatka.interestingTasks;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public class LinkedListOperations {

    public static LinkedNode sumTwoLists(LinkedNode first, LinkedNode second) {
        LinkedNode head = new LinkedNode(0);
        LinkedNode p = first, q = second, curr = head;

        int additionalValue = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.value : 0;
            int y = (q != null) ? q.value : 0;
            int sum = additionalValue + x + y;
            additionalValue = sum / 10;
            curr.next = new LinkedNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (additionalValue > 0)
            curr.next = new LinkedNode(additionalValue);

        return head.next;
    }

    // O(1) space && O(n^2) time
    public LinkedNode getKthElementToLast(LinkedNode node, int k) {

        while (node.next != null) {
//            iterator.next().va
        }

        return node;
    }

    /*private static LinkedNode doSum(LinkedNode tempHead, LinkedNode next, LinkedNode first, LinkedNode second, int additionalValue) {

        if (first.getNext() != null || second.getNext() != null) {

            int sum = additionalValue + first.getValue() + second.getValue();
            LinkedNode newOne = new LinkedNode(sum % 10);
            if (next == null)
                next = newOne;
            else {
                next.setNext(newOne);
            }
            tempHead.setNext(doSum(tempHead, next, first.getNext(), second.getNext(), sum / 10));
        }

        return tempHead.getNext();
    }*/
}
