//package com.vadym.lopatka.interestingTasks.test4;
//
//import java.io.IOException;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int workHours = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int dayHours = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String pattern = bufferedReader.readLine();
//
//        List<String> result = Result.findSchedules(workHours, dayHours, pattern);
//
//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();*/
//    }
//}
//
//class Result {
//
//    /*
//     * Complete the 'findSchedules' function below.
//     *
//     * The function is expected to return a STRING_ARRAY.
//     * The function accepts following parameters:
//     *  1. INTEGER workHours
//     *  2. INTEGER dayHours
//     *  3. STRING pattern
//     */
//
///*    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
////        BigInteger.valueOf(workHours).gcd(BigInteger.valueOf(dayHours)).intValue();
//
//        int hoursToCover = workHours;
//        int daysToCover = 0;
//        for (int i = 0; i < pattern.length(); i++) {
//            if (pattern.charAt(i) != '?') {
//                hoursToCover -= Character.getNumericValue(pattern.charAt(i));
//            } else {
//                daysToCover++;
//            }
//        }
//
//        int greatestCommonDivisor = BigInteger.valueOf(hoursToCover).gcd(BigInteger.valueOf(daysToCover)).intValue();
//        int hoursPerDay = greatestCommonDivisor;
//        if (greatestCommonDivisor > dayHours) {
//            hoursPerDay=dayHours;
//        }
//
//        new int[daysToCover]
//
//        List<String> resultList = new ArrayList<>();
//
//        return Collections.EMPTY_LIST;
//    }
//*/
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> results = new ArrayList<List<Integer>>();
//        if (nums == null || nums.length == 0) {
//            return results;
//        }
//        List<Integer> result = new ArrayList<>();
//        dfs(nums, results, result);
//        return results;
//    }
//
//    public static void dfs(int[] nums, List<List<Integer>> results, List<Integer> result) {
//        if (nums.length == result.size()) {
//            List<Integer> temp = new ArrayList<>(result);
//            results.add(temp);
//        }
//        for (int i=0; i<nums.length; i++) {
//            if (!result.contains(nums[i])) {
//                result.add(nums[i]);
//                dfs(nums, results, result);
//                result.remove(result.size() - 1);
//            }
//        }
//    }
//
//    public static List<String> generateScheduler(int workHours, int dayHours, String pattern){
//        int hoursToCover = workHours;
//        int daysToCover = 0;
//        // first iterate through the pattern to know how many ? characters there are
//        // as well as the number of hours remaining
//        for (int i = 0; i < pattern.length(); i++) {
//            if (pattern.charAt(i) != '?') {
//                hoursToCover -= Character.getNumericValue(pattern.charAt(i));
//            } else {
//                daysToCover++;
//            }
//        }
//        List<List<Integer>> permutations = new ArrayList<>();
//        // get all the lists of work shifts that sum to the remaining number of hours
//        // the number of work shifts in each list is the number of ? characters in pattern
//        generatePermutations(permutations, hoursToCover, daysToCover);
//
//        // after getting all the permutations, we need to iterate through the pattern
//        // for each permutation to construct a list of schedules to return
//        List<String> schedules = new ArrayList<String>();
//        for (List<Integer> permutation : permutations) {
//            StringBuilder newSchedule = new StringBuilder();
//            int permCount = 0;
//            for (int i = 0; i < pattern.length(); i++) {
//                if (pattern.charAt(i) == '?') {
//                    newSchedule.append(permutation.get(permCount));
//                    permCount++;
//                }
//                else {
//                    newSchedule.append(pattern.charAt(i));
//                }
//            }
//            schedules.add(newSchedule.toString());
//        }
//        return schedules;
//    }
//
//    public static void generatePermutations(List<List<Integer>> permutations, int workHours, int unknownCount) {
//        for (int i = 0; i <= workHours; i++) {
//            List<Integer> permutation = new ArrayList<Integer>();
//            permutation.add(i);
//            generatePermutationsHelper(permutations, permutation, workHours - i, unknownCount - 1);
//        }
//    }
//
//    public static void generatePermutationsHelper(List<List<Integer>> permutations, List<Integer> permutation, int remainingHours, int remainingShifts){
//        if (remainingShifts == 0 && remainingHours == 0) {
//            permutations.add(permutation);
//            return;
//        }
//        if (remainingHours <= 0 || remainingShifts <= 0) {
//            return;
//        }
//        for (int i = 0; i <= remainingHours; i++) {
//            List<Integer> newPermutation = new ArrayList<Integer>(permutation);
//            newPermutation.add(i);
//            generatePermutationsHelper(permutations, newPermutation, remainingHours - i, remainingShifts - 1);
//        }
//    }
//
//}
