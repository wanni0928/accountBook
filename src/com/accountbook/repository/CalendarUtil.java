package com.accountbook.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalendarUtil {
    private final LocalDateTime localDateTime;

    public CalendarUtil() {
        this.localDateTime = LocalDateTime.now();
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
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getCurrentDate(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public LocalDateTime setCurrentDate(int year, int month, int day) {
        return LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.now());
    }
}
