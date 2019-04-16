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

    public static boolean isStringContainsUniqueChars(String string) {
        final int uniqueSymbolsAmount = 128; // ASCII
        if (string == null || string.length() > uniqueSymbolsAmount)
            return false;

        final boolean[] booleans = new boolean[uniqueSymbolsAmount];
        for (int i = 0; i < string.length(); i++) {

            final int index = string.charAt(i);
            if (booleans[index])
                return false;
            else
                booleans[index] = true;
        }

        return true;
    }

    public static boolean isItPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        //count letters
        final int[] letters = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            final int charIndex = s1.charAt(i);
            letters[charIndex]++;
        }

        //compare
        for (int i = 0; i < s2.length(); i++) {
            final int index = s2.charAt(i);
            letters[index]--;
            if (letters[index] < 0)
                return false;
        }

        return true;
    }
}
