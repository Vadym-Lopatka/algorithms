package com.vadym.lopatka;

import java.io.IOException;
import java.util.TreeSet;


public class Solution {

    static long repeatedString(String s, long n) {
        String letterToFind = "a";
        int countInString = s.length() - s.replaceAll(letterToFind, "").length();
        long multiplicator = n / s.length();

        long length = multiplicator * s.length();
        long result = multiplicator * countInString;
        if (length == n) {
            return result;
        } else {
            String remainder = s.substring(0, Math.toIntExact(n - length));
            int countInRemainder = remainder.length() - remainder.replaceAll(letterToFind, "").length();
            return result + countInRemainder;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(repeatedString("aba", 10));
    }

    static int hourglassSum(int[][] arr) {
        TreeSet<Integer> sums = new TreeSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sums.add(getSum(i, j, arr));
            }
        }

        return sums.last();
    }

    static int getSum(int i, int j, int[][] arr) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                + arr[i + 1][j + 1]
                + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
    }

}
