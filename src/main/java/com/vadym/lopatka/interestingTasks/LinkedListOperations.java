package com.vadym.lopatka.interestingTasks;

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
}
