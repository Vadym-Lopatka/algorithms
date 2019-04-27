package com.vadym.lopatka;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CodilityTest {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{-1, -3}));
    }

    public static int solution(int[] A) {
        int N = A.length;

        if (N == 0)
            return 0;

        if (N > 1) {
            final Set<Integer> set = Arrays.stream(A).parallel()
                    .boxed()
                    .filter(value -> value > 0)
                    .collect(Collectors.toSet());

            for (int i = 1; i <= N + 1; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
        }

        return A[0] + 1;
    }


    /*public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int min = A[0];
        for (int value = 1; value < A.length; value++) {

            if (value > min && A[value] != value) {
                if (isNotPresent(A, value))
                    return value;
            }

        }
        return A[A.length - 1] + 1;
    }

    private static boolean isNotPresent(int[] a, int value) {
        for (int item : a) {
            if (item == value) {
                return false;
            }
        }

        return true;
    }*/
}
