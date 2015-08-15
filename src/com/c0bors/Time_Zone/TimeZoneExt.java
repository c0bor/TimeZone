package com.c0bors.Time_Zone;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Oleksiy on 14.08.2015.
 */
public class TimeZoneExt {
    public String name;
    public String timeZoneCode;
    public String detail;

    public String CountTime(String timeZoneCode){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        dateFormat.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        return dateFormat.format(new Date());

    }
    public String[] TimeIds(){

        return TimeZone.getAvailableIDs();
    }


}
