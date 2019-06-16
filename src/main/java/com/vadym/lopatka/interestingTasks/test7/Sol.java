package com.vadym.lopatka.interestingTasks.test7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sol {
//    static long countTriplets(List<Long> arr, long r) {
//        int count = 0;
//        for (Long v : arr) {
//            if (v % r == 0)
//                count++;
//        }
//
//        return count * (count - 1) / 3;
//    }

    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;

            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }

            if (potential.containsKey(key) && a % r == 0) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }

            potential.put(a, potential.getOrDefault(a, 0L) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        List<Long> list = Arrays.asList(1l, 5l, 5l, 25l, 125l);
        long triplets = countTriplets(list, 5);
        System.out.println(triplets);
    }

    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> key2count = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String key = generateKey(s.substring(i, j));
                if (!key2count.containsKey(key)) {
                    key2count.put(key, 0);
                }
                key2count.put(key, key2count.get(key) + 1);
            }
        }
        return key2count.values().stream().mapToInt(count -> count * (count - 1) / 2).sum();
    }

    static String generateKey(String str) {
        return str.chars().sorted().mapToObj(letter -> String.valueOf((char) letter)).collect(Collectors.joining());
    }

    static void checkMagazine(String[] magazine, String[] note) {
        if (magazine.length < note.length) {
            System.out.println("No");
        } else {
            Map<String, Long> magMap = Arrays.stream(magazine)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<String, Long> noteMap = Arrays.stream(note)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Long magValue;
            for (Map.Entry<String, Long> noteEntry : noteMap.entrySet()) {
                magValue = magMap.get(noteEntry.getKey());
                if (magValue == null || noteEntry.getValue() > magValue) {
                    System.out.println("No");
                    return;
                }
            }
            System.out.println("Yes");
        }
    }


    static long arrayManipulation(int n, int[][] queries) {
        long[] store = new long[n];
        int from, to, summand;

        for (int i = 0; i < queries.length; i++) {
            from = queries[i][0];
            to = queries[i][1];
            summand = queries[i][2];

            store[from - 1] += summand;
            if (to < n) store[to] -= summand;
        }

        long max = 0;
        long temp = 0;

        for (int i = 0; i < n; i++) {
            temp += store[i];
            if (temp > max) max = temp;
        }

        return max;
    }
}
