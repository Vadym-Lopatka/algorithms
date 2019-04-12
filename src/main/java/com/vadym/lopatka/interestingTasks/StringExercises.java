package com.vadym.lopatka.interestingTasks;

import java.util.Optional;

public class StringExercises {

    public static String reverseString(String strToReverse) {
        return Optional.ofNullable(strToReverse)
                .map(s -> {

                    char[] chars = s.toCharArray();
                    StringBuilder reversedStr = new StringBuilder(chars.length);

                    for (int i = s.length() - 1; i >= 0; i--) {
                        reversedStr.append(chars[i]);
                    }
                    return reversedStr.toString();
                })
                .orElse("");
    }
}
