package com.java.restservice.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {

    public boolean checkDate() {
        Calendar myDate = Calendar.getInstance(); // set this up however you need it.
        int dow = myDate.get(Calendar.DAY_OF_WEEK);
        return ((dow >= Calendar.MONDAY) && (dow <= Calendar.FRIDAY));
    }

    //working hours:9-18
    public boolean checkHours() {
        Calendar cal = Calendar.getInstance();
        String HOUR_FORMAT = "HH:mm";
        SimpleDateFormat sdfHour = new SimpleDateFormat(HOUR_FORMAT);
        String hour = sdfHour.format(cal.getTime());
        String start = "09:00";
        String end = "18:00";
        return ((hour.compareTo(start) >= 0)
                && (hour.compareTo(end) <= 0));


    }
}
