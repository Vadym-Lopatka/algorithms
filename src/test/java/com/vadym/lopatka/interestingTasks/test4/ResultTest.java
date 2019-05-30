package com.vadym.lopatka.interestingTasks.test4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class ResultTest {
    @Test
    public void findSchedulesOnePossible() {
        List<String> actualResult = Result.findSchedules(56, 8, "???8???");
//        List<String> actualResult = Result.generateScheduler(56, 8, "???8???");
        List<String> correctResult = Arrays.asList("8888888");

        Assert.assertThat(actualResult, is(correctResult));
    }


    @Test
    public void findSchedulesSeveralVariants() {
        List<String> actualResult = Result.findSchedules(3, 2, "??2??00");
//        List<String> actualResult = Result.generateScheduler(3, 2, "??2??00");
        List<String> correctResult = Arrays.asList("0020100", "0021000", "0120000", "1020000");

        Assert.assertThat(actualResult, is(correctResult));
    }

    @Test
    public void findSchedulesOneMore() {
        List<String> actualResult = Result.findSchedules(3, 1, "???????");
//        List<String> actualResult = Result.generateScheduler(3, 2, "??2??00");
        List<String> correctResult = Arrays.asList(
                "0000111",
                "0001011",
                "0001101",
                "0001110",
                "0010011",
                "0010101",
                "0010110",
                "0011001",
                "0011010",
                "0011100",
                "0100011",
                "0100101",
                "0100110",
                "0101001",
                "0101010",
                "0101100",
                "0110001",
                "0110010",
                "0110100",
                "0111000",
                "1000011",
                "1000101",
                "1000110",
                "1001001",
                "1001010",
                "1001100",
                "1010001",
                "1010010",
                "1010100",
                "1011000",
                "1100001",
                "1100010",
                "1100100",
                "1101000",
                "1110000");

        Assert.assertThat(actualResult, is(correctResult));
    }


}