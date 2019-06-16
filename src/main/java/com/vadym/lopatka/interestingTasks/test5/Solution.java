package com.vadym.lopatka.interestingTasks.test5;

import java.util.stream.IntStream;

public class Solution {

    static void minimumBribes(int[] q) {
        int bribes = 0;

        for (int i = 1; i < q.length + 1; i++) {
            int value = q[i - 1];

            if (value > (i + 2)) {
                System.out.println("Too chaotic");
                return;
            }

            final int index = i - 1;
            long count = IntStream.range(Math.max(0, q[index] - 2), index)
                    .filter(j -> q[j] > q[index])
                    .count();
            bribes += count;
        }

        System.out.println(bribes);
    }


    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4}); // 3
        minimumBribes(new int[]{2, 5, 1, 3, 4}); // Too chaotic
    }
}
