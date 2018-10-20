package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KONSOL {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a;
        int summ = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (a=0;true;){
            String r = reader.readLine();

            if (r.equals("сумма"))
                break;
            else
                a = Integer.parseInt(r);
                summ = summ+a;
        }
        System.out.println(summ);
    }
}

/*1. Программа должна считывать данные с клавиатуры.
2. Программа должна прекращать считывать данные с клавиатуры после того пользователь введет слово «сумма» в нижнем регистре и нажмет Enter.
3. Программа должна корректно работать, если пользователь ввел одно число и слово «сумма».
4. Программа должна корректно работать, если пользователь ввел два числа и слово «сумма».
5. Программа должна корректно работать, если пользователь ввел более двух чисел и слово «сумма».
6. Программа должна выводить текст на экран.*/

