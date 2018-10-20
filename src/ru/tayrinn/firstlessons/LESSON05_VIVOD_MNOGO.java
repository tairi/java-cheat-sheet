package ru.tayrinn.firstlessons;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 25.10.17
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
public class LESSON05_VIVOD_MNOGO {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i = i + 1){         //цикл
            System.out.println("Какой-нибудь текст" + i);
        }
        System.out.println(String.format("%1$s \n %1$s \n %1$s \n %1$s %1$s %1$s %2$s %3$s %1$s %1$s", "20", "21", "22"));
    }   //вывод одинаковых значений без копирования одинаковых команд: % - начало строки, 1$, 2$ - порядковый номер значения, s - обозначения типа переменной
}