package com.techacademy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    //仕様1：指定日の曜日を算定する
    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable String val1) {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
        String weekString = "";
        try {
            Date Current_Date = sdFormat.parse(val1);
            Calendar cal = Calendar.getInstance();
            cal.setTime(Current_Date);

        int week = cal.get(Calendar.DAY_OF_WEEK);

        switch(week) {
        case Calendar.MONDAY:
            weekString = "Monday";
            break;
        case Calendar.TUESDAY:
            weekString = "Tuesday";
            break;
        case Calendar.WEDNESDAY:
            weekString = "Wednesday";
            break;
        case Calendar.THURSDAY:
            weekString = "Thursday";
            break;
        case Calendar.FRIDAY:
            weekString = "Friday";
            break;
        case Calendar.SATURDAY:
            weekString = "Saturday";
            break;
        case Calendar.SUNDAY:
            weekString = "Sunday";
            break;
        }
        }
        catch (ParseException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        return weekString;




     }

    //仕様2：四則演算を行なう
    //足し算
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }
    //引き算
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果：" + res;
    }
    //掛け算
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果：" + res;
    }
    //割り算
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }



}
