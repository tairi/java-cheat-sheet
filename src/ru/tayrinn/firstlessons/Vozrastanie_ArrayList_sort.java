package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Vozrastanie_ArrayList_sort {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();     //создание коллекции (списка)
        for (int i = 0; i < 5; i++) {
            int s = Integer.parseInt(reader.readLine());
            list.add(s);
        }

        Collections.sort(list);                    //сортировка коллекции по убыванию (по умолчанию)
        Collections.reverse(list);                  //реверс - в обратном порядке

        for (int i = 0; i < list.size(); i++)         //вывод на экран значений коллекции с каждой новой строки  (в обратном порядке)
        {
            int j = list.size() - i - 1;
            System.out.println(list.get(j));
        }

        for (int i = 0; i < list.size(); i++)            //вывод на экран значений коллекции с каждой новой строки
        {
            System.out.println(list.get(i));
        }
    }
}
//
