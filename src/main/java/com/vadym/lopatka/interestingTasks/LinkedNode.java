package com.vadym.lopatka.interestingTasks;

public class LinkedNode {
    Integer value;
    LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder before = new StringBuilder("LinkedNode{");
        LinkedNode linkedNode = this;

        while (linkedNode != null) {
            before.append(linkedNode.value).append(",");
            linkedNode = linkedNode.next;
        }

        return before.toString() + '}';
    }
}