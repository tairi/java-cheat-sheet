package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 25.10.17
 * Time: 1:39
 * To change this template use File | Settings | File Templates.
 */
public class KVADRAT_A {
        public static void main(String[] args) throws IOException {
        int a;
        //напишите тут ваш код
        Scanner num = new Scanner(System.in);           //1 способ: считывание с консоли (клавиатуры)- создание объекта
        FileInputStream fileInputStream = new FileInputStream("test.txt");    //создание пути считывания из фаила
        Scanner num2 = new Scanner(fileInputStream);                          //создание объекта считывания из фаила
        num2.nextInt();                                                       //пропуск числа: "считай число"
        num2.nextInt();
        int b = num2.nextInt();                                               //присвоение переменной "считай число"
        a = num.nextInt();                                                    //присвоение переменной "считай с консоли"
        System.out.println("a2="+(a*a));
        System.out.println("Считывание 1 методом: b = " + b);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));   //2 способ: считывание из фаила - создание объекта
        bufferedReader.readLine();                                                        //пропуск строки в фаиле
        bufferedReader.readLine();
        System.out.println("Считывыние 2 методом:" + Integer.parseInt(bufferedReader.readLine()));                  //вывод строки на экран
    }

}