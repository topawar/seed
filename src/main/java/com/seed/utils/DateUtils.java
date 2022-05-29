package com.seed.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String PatternFormatDate(Date date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
