package com.vadym.lopatka;

import static java.lang.Integer.numberOfTrailingZeros;
import static java.lang.Math.max;

public class CodilityMy2BinaryGap {


    public static void main(String[] args) {

        int s = 3;
        final String s1 = Integer.toBinaryString(s);
        System.out.println(s1);
        System.out.println(Integer.toBinaryString(~(s)));

//        System.out.println(solution(1041));
//        System.out.println(solution1(1041));
//        System.out.println(solution(1041) == 5);
    }

    public static int solution1(int n) {
        int max = 0;
        while ((n >>>= numberOfTrailingZeros(~(n | n - 1))) != 0)
            max = max(numberOfTrailingZeros(n), max);

        return max;
    }

    public static int solution(int N) {
        int work = N;
        while (work > 0 && (work & 1) == 0) {
            work >>= 1;
        }
        work >>= 1;

        int max = 0;
        int zeros = 0;

        while (work > 0) {
            if ((work & 1) == 0) {
                zeros++;
            } else {
                max = max(max, zeros);
                zeros = 0;
            }
            work >>= 1;
        }
        return max;



 /*       // write your code in Java SE 8
        final String binaryString = Integer.toBinaryString(N);

        int gapKeyCounter = 0;
        int gapCounter = 0;
//        final TreeSet<Integer> gaps = new TreeMap<>();
        final TreeMap<Integer, Integer> gaps = new TreeMap<>();

        boolean endOfTheGap = false;

        for (int i = 0; i < binaryString.length(); i++) {
            final char charAt = binaryString.charAt(i);
            if (charAt == '0') {
                if (endOfTheGap) {
                    gaps.put(gapKeyCounter++, gapCounter++);
                    endOfTheGap = false;
                } else {
                    gaps.put(gapKeyCounter, gapCounter++);
                }
            } else {
                endOfTheGap = true;
                gapCounter = 0;
            }
        }

        if (gapKeyCounter <= 1 && !endOfTheGap)
            return 0;

        return gaps.values().stream().max(Integer::compare).get();*/
    }

}
