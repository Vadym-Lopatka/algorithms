package com.vadym.lopatka.dataStructures;

import java.util.Optional;
import java.util.stream.IntStream;

public class BinaryTree {
    private Node root;

    /**
     * @param value
     * @return
     */
    public boolean add(Integer value) {
        if (root == null)
            root = new Node(value);
        else {
            addValueToNode(root, value);
        }

        return true;
    }

    /**
     * @param stream
     * @return
     */
    public boolean addAll(IntStream stream) {
        stream.forEach(this::add);
        return true;
    }

    /**
     * @return the leftmost element
     */
    public int getLowest() {
        return Optional.ofNullable(root)
                .map(this::findLowest)
                .orElseThrow(() -> new IllegalStateException("tree is empty"));
    }

    /**
     * @return the rightmost element
     */
    public int getHighest() {
        return Optional.ofNullable(root)
                .map(this::findHighest)
                .orElseThrow(() -> new IllegalStateException("tree is empty"));
    }

    private void addValueToNode(Node node, Integer value) {
        if (value >= node.value) {

            if (node.right != null)
                addValueToNode(node.right, value);
            else
                node.right = new Node(value, node);

        } else {

            if (node.left != null)
                addValueToNode(node.left, value);
            else
                node.left = new Node(value, node);
        }
    }

    private int findLowest(Node node) {
        if (node.left != null)
            return findLowest(node.left);

        return node.value;
    }

    private int findHighest(Node node) {
        if (node.right != null)
            return findHighest(node.right);

        return node.value;
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        Node(int value) {
            this.value = value;
        }
    }
}
