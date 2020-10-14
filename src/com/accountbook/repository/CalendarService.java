package com.accountbook.repository;

import java.time.LocalDate;
import java.util.Calendar;

public class CalendarService {
    private final Calendar calendar;

    public CalendarService() {
        this.calendar = Calendar.getInstance();
    }

    public void setCurrentDate() {
        calendar.set(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
//        System.out.println("Year : " + calendar.get(Calendar.YEAR));
//        System.out.println("Month : " + calendar.get(Calendar.MONTH));
//        System.out.println("DAY : " + calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println("Maximum Day : "  + (actualMaximum + 1));
    }

    public int getCurrentYear() {
        return calendar.get(Calendar.YEAR);
    }

    public int getCurrentMonth() {
        return calendar.get(Calendar.MONTH);
    }

    public int getCurrentDayOfMonth() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getCurrentMonthMaxDay() {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + 1;
    }



    public void test(){
        calendar.set(2020,11,1);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(calendar.get(Calendar.MONTH) + " " + actualMaximum);
    }
}
