package com.accountbook.model;
import java.util.ArrayList;
import java.util.List;

public class CalenderDatabase {
    static private CalenderDatabase db = null;
    static public List<List<Date>> monthList;
    private CalenderDatabase() {
        monthList = new ArrayList<>();
        for(int i = 1; i<13; i++) {
            List<Date> dayList = new ArrayList<>();
            for(int j = 1; j<32; j++) {
                Date date = new Date();
                date.setDate(j); date.setMonth(i);
                dayList.add(date);
            }
            monthList.add(dayList);
        }
//        for(List<Date> month : monthList) {
//            for (Date day : month) {
//                System.out.println(day);
//            }
//        }
//        System.out.println(getDate(3,2));
    }
    public static CalenderDatabase getDb() {
        if(db == null) {
            db = new CalenderDatabase();
        }
        return db;
    }
    public Date getDate(int month, int day) {
        Date date = monthList.get(month-1).get(day-1);
        return date;
    }

}
