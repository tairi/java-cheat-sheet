package ru.tayrinn.secondlessons;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalField;

public class Human extends Animal{
    public String address;
    //true - 0 - female, false - 1 - male
    public Boolean gender;

    private LocalDate birthDate;

    public boolean realZodiacEqualAstronomicalZodiac(){
        Month month = birthDate.getMonth();
        Integer dayOfMonth = birthDate.getDayOfMonth();
        return !((month == Month.NOVEMBER && dayOfMonth >= 30) || (month == Month.DECEMBER && dayOfMonth <= 17));
    }

    public void printTruthAboutZodiac(){
        if (realZodiacEqualAstronomicalZodiac())
            System.out.println("Вам всю жизнь врали, вы не стрелец, а змееносец!");
        else {
            System.out.println("Да, вам всю жизнь рассказывали правду о знаке зодиака");
        }
    }

    public                                                  void                            outAsString         ()                  {
//  модификатор видимости   статический ли метод?           тип возвращаемого значения      название метода     параметры метода    начало описания метода
        String st = "Human{" +
                "address='" + address + "\',\n" +
                "gender=" + gender + ",\n" +
                "name='" + name + "\',\n" +
                '}';
        System.out.println(st);
    }

    @Override
    public String toString() {
        return "Human{" +
                "address='" + address + '\'' +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                '}';
    }
}
