package com.accountbook.view;

import com.accountbook.model.CalenderDatabase;
import com.accountbook.model.CustomDate;

import java.util.List;

public class ShowingCalender implements ShowingCalenderInterface{
    public ShowingCalender() {
        CalenderDatabase.getDb();
    }

    @Override
    public void monthView() {
//        CalenderDatabase calenderDatabase = CalenderDatabase.getDb();
        List<List<CustomDate>> monthList = CalenderDatabase.monthList;
        {
            int i =1;
            for (List<CustomDate> month : monthList) {
                System.out.printf("%4s", i + "월");
                i++;
            }
        }
    }

    @Override
    public void dailyView() {
//        CalenderDatabase calenderDatabase = CalenderDatabase.getDb();
        List<List<CustomDate>> monthList = CalenderDatabase.monthList;
        {
            int i =1;
            for(CustomDate day : monthList.get(0)) {
                System.out.printf("%4s",i+"일");
                if(i%6==0)
                    System.out.println();
                i++;
            }
        }
    }

    public static void main(String[] args) {
        new ShowingCalender().dailyView();
    }
}