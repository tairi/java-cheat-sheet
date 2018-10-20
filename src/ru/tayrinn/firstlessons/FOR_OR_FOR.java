package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FOR_OR_FOR {
  /*  public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double summ=0;
        int i=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;true;) {
            String name1 = reader.readLine();
            int a = Integer.parseInt(name1);
            if (a!= -1) {
                    summ +=a;
                    ++i; }
            else break;
        }
        System.out.println(summ/i);
    }                                  */

    public static void main(String[] args) throws Exception {
            //напишите тут ваш код
            double summ=0;
            int i;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (i=0;true;i++) {
                String name1 = reader.readLine();
                int a = Integer.parseInt(name1);
                if (a!= -1) {
                        summ +=a;
                }
                else break;
            }
            System.out.println(summ/i);
        }
}

  /*Требования:
  1. Программа должна считывать данные с клавиатуры.
  2. Программа должна выводить данные на экран.
  3. После ввода -1 программа должна корректно завершить работу.
  4. Если последовательно ввести: 1, 2, 2, 4, 5 и -1, программа должна вывести 2.8.
  5. Если последовательно ввести: -100, 0, 100 и -1, программа должна вывести 0.0.
  6. Если последовательно ввести: 1 и -1, программа должна вывести 1.0.
  7. Выведенный результат должен соответствовать заданию для любых входных данных.*/