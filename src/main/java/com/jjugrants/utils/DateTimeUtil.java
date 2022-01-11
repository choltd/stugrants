package com.jjugrants.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String getSysTime() {
        Date date = new Date();
        return sdf.format(date);
    }

    public static Timestamp getTimestamp() {
        return new Timestamp(new Date().getTime());
    }

}
