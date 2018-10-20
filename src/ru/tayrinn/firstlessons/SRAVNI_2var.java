package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SRAVNI_2var {
    public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());
            int d = Integer.parseInt(reader.readLine());
            int e = Integer.parseInt(reader.readLine());

            int minimum = min(a, b, c, d, e);

            System.out.println("Minimum = " + minimum);
        }


        public static int min(int a, int b, int c, int d, int e) {
            int n;
            int min = Math.min(e, Math.min(Math.min(a,b), Math.min(c,d)));            //1 вариант, короткий, с помощью ф-ции мат.минимума
           return min;
        }

    }

    /*                            2 вариант, длинный
    if (a<=b)
    n=a;
    else
    n=b;
    if (n<c)
    n=n;
    else
    n=c;
    if (n<d)
    n=n;
    else
    n=d;
    if (n<e)
    n=n;
    else
    n=e;
    return n;
     */

    /*Текущая реализация: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
    Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.


    Требования:
    1. Программа должна считывать числа с клавиатуры.
    2. В классе должен быть метод public static void main.
    3. В классе должен быть метод public static min, принимающий 5 параметров типа int.
    4. Метод min должен возвращать минимум из 5 переданных чисел. Если минимальных чисел несколько - вернуть любое из них.
    5. Программа должна выводить строку, которая начинается на "Minimum = ".
    6. Программа должна выводить строку, которая заканчивается минимальным из 5 введенных чисел.*/

