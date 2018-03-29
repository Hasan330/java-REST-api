package com.hasan;

import java.util.Calendar;

public abstract class Helpers {

    public static Calendar createDate(int day, int month, int year){
        System.out.println("Creating calendar object for: " +day+"/"+month+"/"+year);
        Calendar calObj = Calendar.getInstance();
        calObj.set(year, month-1, day);
        return calObj;
    }

}
