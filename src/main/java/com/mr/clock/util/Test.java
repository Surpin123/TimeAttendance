package com.mr.clock.util;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        /*Date date = new Date();
        System.out.println(date);*/
        System.out.println(DateTimeUtil.timeNow());
        System.out.println(DateTimeUtil.timeNow());
        System.out.println(DateTimeUtil.dateTimeNow());
        System.out.println(Arrays.toString(DateTimeUtil.now()));
        System.out.println(DateTimeUtil.getLastDay(2023, 2));
        System.out.println(DateTimeUtil.dateOf("2023-05-01 12:12:30"));
        System.out.println(DateTimeUtil.dateOf(2023, 05, 01, "12:12:30"));
        System.out.println(DateTimeUtil.checkTimeStr("2323:233:233"));
    }
}
