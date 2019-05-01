package com.vadym.lopatka.dataStructures;

import org.junit.Assert;
import org.junit.Test;

public class MyExperimentsTest {

    private static int factorial(int n) {
        if (n == 0) return 1;

        return n * factorial(n - 1);
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    @Test
    public void factorialTest() {
        Assert.assertEquals(1, factorial(1));
        Assert.assertEquals(2, factorial(2));
        Assert.assertEquals(6, factorial(3));
    }

    @Test
    public void fibonacciTest() {
        Assert.assertEquals(13, fibonacci(7));
    }
}