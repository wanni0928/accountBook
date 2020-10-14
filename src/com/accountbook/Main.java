package com.accountbook;

import com.accountbook.controller.MoneyController;
import com.accountbook.repository.CalendarService;
import com.accountbook.repository.MoneyService;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        MoneyService moneyService = new MoneyService();
        MoneyController moneyController = new MoneyController(moneyService);

        moneyController.addExpand();
        moneyController.addIncome();
        moneyController.findAll();
//
//        Month month = moneyService.findAll().get(0).getLocalDateTime().getMonth();
//        int dayOfMonth = moneyService.findAll().get(0).getLocalDateTime().getDayOfMonth();

//        LocalDateTime localDateTime = LocalDateTime.now().withMonth(10);
//        localDateTime.

        int year = 2017;
        int month = 2;
        int day = 1;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

//        Calendar cal = Calendar.getInstance();

//        cal.set(year, month - 1, day); //월은 -1해줘야 해당월로 인식

//        System.out.println(dateFormat.format(cal.getTime()));

//        System.out.println("해당년도: "+cal.get(Calendar.YEAR));
//        System.out.println("해당월: "+(cal.get(Calendar.MONTH)+1)); //보여줄때 +1로 하여 사람기준으로 설정
//        System.out.println("첫번째 일: "+cal.getMinimum(Calendar.DAY_OF_MONTH));

//        System.out.println("마지막 일(현재 날짜 기준 최대수): "+cal.getActualMaximum(Calendar.DAY_OF_MONTH)); //기본적으로 이걸 사용

        CalendarService calendarService = new CalendarService();
//        calendarService.test();
        calendarService.setCurrentDate();
        System.out.println(calendarService.getCurrentMonthMaxDay());
        System.out.println(calendarService.getCurrentYear());
        System.out.println(calendarService.getCurrentMonth());
        System.out.println(calendarService.getCurrentDayOfMonth());
    }
}
