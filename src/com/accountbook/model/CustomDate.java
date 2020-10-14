package com.accountbook.model;

public class CustomDate {
    int month=0;
    int date=0;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return month+"월 "+date+"일 ";
//                "지출: "+income+" "+"소비 "+spent;
    }
}