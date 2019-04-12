package com.vadym.lopatka.interestingTasks;

public class StringExercises {

    public static String reverseString(String strToReverse) {
        if (strToReverse != null) {
            char[] chars = strToReverse.toCharArray();
            StringBuilder reversed = new StringBuilder(chars.length);

            for (int i = strToReverse.length() - 1; i >= 0; i--)
                reversed.append(chars[i]);

            return reversed.toString();
        }

        return "";
    }
}
