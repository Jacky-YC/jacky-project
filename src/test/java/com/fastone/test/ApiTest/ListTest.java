package com.fastone.test.ApiTest;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ListTest {

    public static void main(String[] args) throws InterruptedException {

        ZonedDateTime now = ZonedDateTime.now();

        int year = now.getYear();
        int month = now.getMonth().getValue();

        YearMonth beforeYearMonth = YearMonth.of(year, month - 1);

        LocalDate localDate = beforeYearMonth.atDay(1);

        ZonedDateTime beforeDateTime = localDate.atStartOfDay(ZoneId.systemDefault());

        System.out.println(year + " 年 " + month +" 月 ");

        System.out.println(beforeDateTime);


    }

}
