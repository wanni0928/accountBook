package com.accountbook.view;

import com.accountbook.model.CalenderDatabase;
import com.accountbook.model.Date;

import java.util.List;
import java.util.Scanner;

public class ShowingCalender implements ShowingCalenderInterface{
    public ShowingCalender() {
    }

    @Override
    public void monthView() {
        CalenderDatabase calenderDatabase = CalenderDatabase.getDb();
        List<List<Date>> monthList = calenderDatabase.monthList;
        {
            int i =1;
            for (List<Date> month : monthList) {
                System.out.printf("%4s", i + "월");
                i++;
            }
        }
    }

    @Override
    public void dailyView() {
        CalenderDatabase calenderDatabase = CalenderDatabase.getDb();
        List<List<Date>> monthList = calenderDatabase.monthList;
        {
            int i =1;
            for(Date day : monthList.get(0)) {
                System.out.printf("%4s",i+"일");
                if(i%6==0)
                    System.out.println();
                i++;
            }
        }
    }

    public static void main(String[] args) {
        new ShowingCalender();
    }
}