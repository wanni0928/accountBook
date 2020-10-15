package com.accountbook.domain;
import java.util.ArrayList;
import java.util.List;

public class CalenderDatabase {
    static private CalenderDatabase db = null;
    static public List<List<CustomDate>> monthList;
    private CalenderDatabase() {
        monthList = new ArrayList<>();
        for(int i = 1; i<13; i++) {
            List<CustomDate> dayList = new ArrayList<>();
            for(int j = 1; j<32; j++) {
                CustomDate customDate = new CustomDate();
                customDate.setDate(j); customDate.setMonth(i);
                dayList.add(customDate);
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
    public CustomDate getDate(int month, int day) {
        CustomDate customDate = monthList.get(month-1).get(day-1);
        return customDate;
    }

}
