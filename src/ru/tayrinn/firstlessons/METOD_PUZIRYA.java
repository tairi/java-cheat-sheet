package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class METOD_PUZIRYA<stackTraceElements> {


/*
Задача по алгоритмам
*/

        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] array = new String[20];
            for (int i = 0; i < array.length; i++) {
                array[i] = reader.readLine();
            }

            sort(array);

            for (String x : array) {
                System.out.println(x);
            }
        }

        public static void sort(String[] array) {
            //напишите тут ваш код
            // Метод sort() должен вызывать метод isGreaterThan().
            //Выведенные слова должны быть отсортированы в алфавитном порядке.

            System.out.print(Thread.currentThread().getStackTrace()[2].getMethodName()); // печать метода, который вызвал этот метод


            ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));        //список по изначальному массиву
            ArrayList<String> list1 = new ArrayList<String>();                            //второй список - новая сортировка

            for (int j=0; j<array.length; j++) {
                String s = list.get(0);
                int max = 0;
                for (int i = 1; i < list.size(); i++) {  //определяем минимум из 2х
                    if (isGreaterThan(s, list.get(i))) {
                        s = s;  //старшая строка
                    }
                    else {s = list.get(i);
                        max = i;  }
                }
                list1.add(0, s);
                list.remove(max);
        /*    System.out.println("Статус после " + j + "-й итерации: \n" +
                                   "начальный массив: " + Arrays.toString(list.toArray()) + "\n" +
                                   "результирующий массив: " + Arrays.toString(list1.toArray()));
        */}

            for (int i=0;i<array.length;i++){
                array[i]=list1.get(i);
            }

        }

        //Метод для сравнения строк: 'а' больше чем 'b'
        public static boolean isGreaterThan(String a, String b) {
            return a.compareTo(b) > 0;
        }

    }

