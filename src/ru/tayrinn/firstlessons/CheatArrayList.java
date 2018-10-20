package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CheatArrayList {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++)
        {
            String s = reader.readLine();
            list.add(s);
        }
        int min = list.get(0).length(); //длина 0й строки
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < min) { //определение самой короткой строки
                min = list.get(i).length();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (min == list.get(i).length()) { //если значение минимума = длине строки, то печатать строку
                System.out.println(list.get(i));
            }
        }
    }
}
