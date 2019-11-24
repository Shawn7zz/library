package com.lan.library.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Xiang Lan
 * Created on 2019-07-19 14:23
 */
public class TimeUtils {

    public static Timestamp addTime(Timestamp timestamp, int day) {
        Date date = new Date(timestamp.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 30);
        return new Timestamp(calendar.getTime().getTime());
    }
}
