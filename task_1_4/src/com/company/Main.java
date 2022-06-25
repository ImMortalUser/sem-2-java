package com.company;

public class Main {

    public static void main(String[] args) {
        TimeAndDate timeAndDate = new TimeAndDate(265,284);
        timeAndDate.getTime();
        timeAndDate.getData();
        timeAndDate.addDay(1300000);
        timeAndDate.getData();
        TimeAndDate.getDataFormat();
        TimeAndDate.changeDataFormat("y.m.d");
        TimeAndDate.getDataFormat();
        timeAndDate.getData();
        timeAndDate.getTimeAndDate();
    }
}
