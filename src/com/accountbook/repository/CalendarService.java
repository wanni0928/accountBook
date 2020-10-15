package com.accountbook.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class CalendarService {
    private final Calendar calendar;

    public CalendarService() {
        this.calendar = Calendar.getInstance();
    }

    public void setSpecificYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    public void setSpecificMonth(int month) {
        final int[] months = {
                Month.JANUARY.getValue(), Month.FEBRUARY.getValue(), Month.MARCH.getValue(),
                Month.APRIL.getValue(), Month.MAY.getValue(), Month.JUNE.getValue(),
                Month.JULY.getValue(), Month.AUGUST.getValue(), Month.SEPTEMBER.getValue(),
                Month.OCTOBER.getValue(), Month.NOVEMBER.getValue(), Month.DECEMBER.getValue()
        };
        calendar.set(Calendar.MONTH, months[month - 1]);
    }

    public void setSpecificDayOfMonth(int day){
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    public void setSpecificDate(int year, int month, int day) {
        this.setSpecificYear(year);
        this.setSpecificMonth(month);
        this.setSpecificDayOfMonth(day);
    }

    public void setCurrentDate() {
        calendar.set(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
    }

    public int getCurrentYear() {
        return calendar.get(Calendar.YEAR);
    }

    public int getCurrentMonth() {
        return calendar.get(Calendar.MONTH) == 0 ? 12 : calendar.get(Calendar.MONTH);
    }

    public int getCurrentDayOfMonth() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getCurrentMonthMaxDay() {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public void test() {
        calendar.set(2020, 2,1);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(calendar.get(Calendar.MONTH) + " " + actualMaximum);
    }
}
