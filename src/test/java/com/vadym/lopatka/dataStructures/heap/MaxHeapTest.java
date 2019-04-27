package com.vadym.lopatka.dataStructures.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class MaxHeapTest {

    @Test
    public void isEmpty() {
        final MaxHeap heap = new MaxHeap(5);
        Assert.assertTrue(heap.isEmpty());
    }

    @Test
    public void isFull() {
        final MaxHeap heap = new MaxHeap(5);
        Assert.assertFalse(heap.isFull());

        IntStream.range(0, 5).forEach(heap::add);
        Assert.assertTrue(heap.isFull());
    }

    @Test(expected = IllegalStateException.class)
    public void addToFullAndGetException() {
        final MaxHeap heap = new MaxHeap(1);
        heap.add(144);
        heap.add(244); //throws exception -> the heap is full
    }

    @Test
    public void addAll() {
        final MaxHeap heap = new MaxHeap(10);
        Assert.assertEquals(heap.size(), 0);

        heap.addAll(IntStream.range(10, 20).toArray());
        Assert.assertEquals(heap.size(), 10);
        Assert.assertTrue(heap.isFull());
    }

    @Test
    public void maxHeapPropertyTest() {
        final MaxHeap heap = new MaxHeap(5);
        heap.addAll(IntStream.range(1, 4).toArray());

        Assert.assertEquals(3, heap.getMax());
    }

    @Test
    public void buildMaxMaxHeapExtractTest() {
        final MaxHeap heap = new MaxHeap(5);
        heap.addAll(IntStream.range(2, 7).toArray());
        final int sizeBeforeExtract = heap.size();

        Assert.assertEquals(6, heap.getMax());
        Assert.assertEquals(6, heap.getMax());
        Assert.assertEquals(6, heap.getMax());
        int extractedMax = heap.extractMax();
        Assert.assertEquals(6, extractedMax);

        Assert.assertEquals(heap.size(), sizeBeforeExtract - 1);
        Assert.assertEquals(5, heap.getMax());
    }
}