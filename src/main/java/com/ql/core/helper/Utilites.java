package com.ql.core.helper;

import java.text.SimpleDateFormat;;
import java.util.Date;

public class Utilites {
    public static String getCurrentDateTimeSuffix(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return String.format("_%s_%d", formatter.format(date), date.getTime());
    }
}
