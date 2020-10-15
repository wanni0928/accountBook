package com.accountbook.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalendarUtil {
    private LocalDateTime localDateTime;
    private LocalDate localDate;
    private LocalTime localTime;

    public CalendarUtil() {
        this.localDateTime = LocalDateTime.now();
        this.localDate = LocalDate.now();
        this.localTime = LocalTime.now();
    }

    public int getCurrentYear() {
        return LocalDateTime.now().getYear();
    }

    public int getCurrentMonth() {
        return LocalDateTime.now().getYear();
    }

    public int getCurrentDayOfMonth() {
        return LocalDateTime.now().getDayOfMonth();
    }

    public String getCurrentDate() {
        String[] dayOfWeeks = {" 월", " 화", " 수", " 목", " 금", " 토", " 일"};
        int idx = (localDateTime.getDayOfWeek().getValue() - 1) % dayOfWeeks.length;
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + dayOfWeeks[idx];
    }

    public String getCurrentDate(LocalDateTime localDateTime) {
        String[] dayOfWeeks = {" 월", " 화", " 수", " 목", " 금", " 토", " 일"};
        int idx = (localDateTime.getDayOfWeek().getValue() - 1) % dayOfWeeks.length;
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + dayOfWeeks[idx];
    }

    public LocalDateTime setCurrentDate(int year, int month, int day) {
        localDate = LocalDate.of(year, month, day);
        localDateTime = LocalDateTime.of(localDate, localTime);
        return localDateTime;
    }
}
