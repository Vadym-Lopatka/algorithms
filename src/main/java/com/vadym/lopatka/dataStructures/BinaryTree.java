package com.vadym.lopatka.dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class BinaryTree {
    private Node root;
    private int size = 0;

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

        size++;
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


    /**
     * @return in-order ordered List (left child, parent, right child)
     */
    public List<Integer> inOrderTraversal() {
        List<Integer> ints = new ArrayList<>(size);
        return traverseInOrder(root, ints);
    }

    /**
     * @return pre-order ordered List (parent, left child, right child)
     */
    public List<Integer> preOrderTraversal() {
        return traversePreOrder(root);
    }

    /**
     * @return post-order ordered List (left child, right child, parent)
     */
    public List<Integer> postOrderTraversal() {
        List<Integer> nodeList = new ArrayList<Integer>();
        traversePostOrder(root, nodeList);
        return nodeList;
    }


    private List<Integer> traverseInOrder(Node node, List<Integer> ints) {
        if (root != null) {

            if (node.left != null)
                traverseInOrder(node.left, ints);

            ints.add(node.value);

            if (node.right != null)
                traverseInOrder(node.right, ints);
        }

        return ints;
    }

    private List<Integer> traversePreOrder(Node root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> ordered = new ArrayList<>(size);

        ordered.add(root.value);
        ordered.addAll(traversePreOrder(root.left));
        ordered.addAll(traversePreOrder(root.right));

        return ordered;
    }

    private void traversePostOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversePostOrder(node.left, list);
        traversePostOrder(node.right, list);
        list.add(node.value);
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
