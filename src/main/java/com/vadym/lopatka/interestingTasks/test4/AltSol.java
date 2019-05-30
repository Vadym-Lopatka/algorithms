package com.vadym.lopatka.interestingTasks.test4;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AltSol {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int workHours = Integer.parseInt(bufferedReader.readLine().trim());

        int dayHours = Integer.parseInt(bufferedReader.readLine().trim());

        String pattern = bufferedReader.readLine();

        List<String> result = Result.findSchedules(workHours, dayHours, pattern);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

class Result {

    /*
     * Complete the 'findSchedules' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER workHours
     *  2. INTEGER dayHours
     *  3. STRING pattern
     */
    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        int hoursToCover = workHours;
        int daysToCover = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '?') {
                hoursToCover -= Character.getNumericValue(pattern.charAt(i));
            } else {
                daysToCover++;
            }
        }

        return getPermutations(dayHours, daysToCover, hoursToCover)
                .stream()
                .map(permutation -> mapPermutationByPattern(permutation, pattern))
                .sorted()
                .collect(Collectors.toList());
    }

    private static String mapPermutationByPattern(List<Integer> permutation, String pattern) {
        StringBuilder scheduleLine = new StringBuilder();
        int index = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '?') {
                scheduleLine.append(permutation.get(index));
                index++;
            } else {
                scheduleLine.append(pattern.charAt(i));
            }
        }

        return scheduleLine.toString();
    }

    private static List<List<Integer>> getPermutations(int maxHoursPerDay, int daysToCover, int sumHoursToCover) {
        Set<List<Integer>> permutations = new HashSet<>();

        if ((maxHoursPerDay * daysToCover) == sumHoursToCover) { //one possible permutation
            List<Integer> permutation = new ArrayList<>();
            for (int i = 0; i < daysToCover; i++) {
                permutation.add(maxHoursPerDay);
            }
            permutations.add(permutation);
        } else { // several permutations
            buildPermutations(permutations, maxHoursPerDay, daysToCover, sumHoursToCover);
        }

        return new ArrayList<>(permutations);
    }

    /**
     *
     * @param permutations
     * @param maxHoursPerDay
     * @param daysToCover
     * @param sumHoursToCover
     */
    private static void buildPermutations(Set<List<Integer>> permutations, int maxHoursPerDay, int daysToCover, int sumHoursToCover) {
        int[] nums = new int[daysToCover];

        if (sumHoursToCover < maxHoursPerDay) {
            nums[0] = sumHoursToCover;
        } else {
            for (int i = 0; i < nums.length; i++) {
                int sum = Arrays.stream(nums).sum();

                if (sum >= sumHoursToCover) { // in previous iteration I added more hours than needed. Here I am fixing it
                    int lastFilledIndex = i - 1;
                    nums[lastFilledIndex] = nums[lastFilledIndex] - (sum - sumHoursToCover);
                } else {
                    if (sum <= sumHoursToCover) { // setting one more day by maxHoursPerDay value
                        nums[i] = maxHoursPerDay;
                    } else { // sum==sumHoursToCover is matched
                        break;
                    }
                }
            }
        }
        permute(permutations, nums, 0);
    }

    private static void permute(Set<List<Integer>> permutations, int[] arr, int fromIndex) {
        if (fromIndex == arr.length) {
            permutations.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return;
        }
        for (int toIndex = fromIndex; toIndex < arr.length; toIndex++) {
            swap(arr, fromIndex, toIndex);
            permute(permutations, arr, fromIndex + 1);
            swap(arr, fromIndex, toIndex);
        }
    }

    private static void swap(int[] arr, int fromIndex, int toIndex) {
        int tempArray = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex] = tempArray;
    }
}

