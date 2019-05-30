package com.vadym.lopatka.interestingTasks.test2;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'reformatDate' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY dates as parameter.
     */

    public static List<String> reformatDate(List<String> dates) {
        // Write your code here
        SimpleDateFormat formatBefore = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat formatAfter = new SimpleDateFormat("yyyy-MM-dd");

        return dates.stream()
                .map(lineWithTH -> lineWithTH.replaceFirst("[a-zA-Z]{2}", ""))
                .map(lineWithoutTH -> getDateFromString(lineWithoutTH,formatBefore))
                .map(formatAfter::format)
                .collect(Collectors.toList());

    }

    private static Date getDateFromString(String source, SimpleDateFormat dateFormat) {
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }


}

public class Solution {
//    20th Oct 2052 → 2052-10-20
//    6th Jun 1933 → 1933-06-06
//    26th May 1960 → 1960-05-26
    public static void main(String[] args) throws IOException, ParseException {
        List<String> list = new ArrayList<>();
        list.add("20th Oct 2052");
        list.add("6th Jun 1933");
        list.add("26th May 1960");

        List<String> result = Result.reformatDate(list);
        System.out.println(result);
    }

    public static void date(String dateString) throws ParseException {

        // This Regular Expression will replace st to blank
        String dateString1 = dateString.replaceFirst("[a-zA-Z]{2}", "");
        //create Date Format and Parse it based on input

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date rightNow = simpleDateFormat.parse(dateString1);

        // Now create Date format for output type. and format the input
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(rightNow);
        System.out.println(formattedDate);
    }
}
