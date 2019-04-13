package com.vadym.lopatka.dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class BinaryTree {
    private Node root;

    public boolean add(Integer value) {
        if (root == null)
            root = new Node(value);
        else {
            addValueToNode(root, value);
        }

        return true;
    }

    private void addValueToNode(Node node, Integer value) {
        if (value >= node.value) {
            if (node.right != null)
                addValueToNode(node.right, value);
            else {
                node.right = new Node(value, node);
            }
        } else {
            if (node.left != null)
                addValueToNode(node.left, value);
            else {
                node.left = new Node(value, node);
            }
        }
    }

    public int getLowest() {
        return Optional.ofNullable(root)
                .map(this::findLowest)
                .orElseThrow(() -> new IllegalStateException("tree is empty"));
    }

    private int findLowest(Node node) {
        if (node.left != null)
            return findLowest(node.left);

        return node.value;
    }

    public int getHighest() {
        return Optional.ofNullable(root)
                .map(this::findHighest)
                .orElseThrow(() -> new IllegalStateException("tree is empty"));
    }

    private int findHighest(Node node) {
        if (node.right != null)
            return findHighest(node.right);

        return node.value;
    }

    public boolean addAll(List<Integer> integers) {
        integers = Optional.ofNullable(integers).orElse(new ArrayList<>());
        integers.forEach(this::add);
        return true;
    }

    public boolean addAll(IntStream stream) {
        stream.forEach(this::add);
        return true;
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
