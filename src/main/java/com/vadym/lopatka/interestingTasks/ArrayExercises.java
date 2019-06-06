package com.vadym.lopatka.interestingTasks;

public class ArrayExercises {

    public static int[] rotationLeft(int[] arr, int nTimesRotate) {
        int[] rotated = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rotated[(i + (arr.length - nTimesRotate)) % arr.length] = arr[i];
        }

        return rotated;
    }
}
