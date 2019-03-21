package ru.tayrinn.firstlessons;

import java.util.Date;

public class DATESSchet {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) { // Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
        //     Date yearStartTime = new Date(); //создание объекта этого года -??
        //вытащить из строки год, потом отсчатить от начала миллисекунды
        //        long getTime //милисекунды с 1янв 1970г
        //        String textRead = date;
        //        String[] words = textRead.split(" ");
        //        String years = "JUN 1 "+ words[3];


        //        Date parsingDate01 = new Date();
        //        SimpleDateFormat ft = new SimpleDateFormat("MMM d yyyy");//превращение формата строки в формат даты (начало года по входным данным)
        //        try {
        //            parsingDate01 = ft.parse(years);
        //        } catch (ParseException e) {
        //            e.printStackTrace();
        //        }
        //
        //        Date parsingDate = new Date();  //превращение формата строки в формат даты (входные данные)
        //        try {
        //            parsingDate = ft.parse(date);
        //        } catch (ParseException e) {
        //            e.printStackTrace();
        //        }
        //        long msTimeDistance = parsingDate.getTime() - parsingDate01.getTime();
        //        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках
        //
        //        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней

        Date datestart = new Date(date);
        Date dataend = new Date(date);

        int y=dataend.getYear();
        datestart.setTime(0);
        datestart.setDate(1);
        datestart.setYear(y);
        datestart.setMonth(0);

        //        Wed Jan 01 03:00:00 MSK 2020 датастарт
        //     Thu Jan 02 00:00:00 MSK 2020 дадаенд

        long dayend=dataend.getTime()-datestart.getTime();
        long day=((dayend/60/60/1000)+3)/24;


        boolean rezult;
        if (day%2!=0) rezult = false;
        else rezult = true;

        return rezult;
    }
}
