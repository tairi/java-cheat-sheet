package ru.tayrinn.firstlessons;  //ИМЯ ПАКЕТА

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 25.10.17
 * Time: 1:12
 * To change this template use File | Settings | File Templates.
 */
public class LESSON04 { //ИМЯ КЛАССА
   private static String TEXT = "Kiss my metal shiny ass";  //ПЕРЕМЕННАЯ КЛАССА
   public static void main(String[] args) throws IOException     // МЕТОД main()
   {
    //  ВЫВОД ТЕКСТА НА ЭКРАН       ОДНОСТРОЧНЫЙ КОММЕНТАРИЙ
      System.out.println(TEXT); //Выведет на экран одну строку с переходом на следующую
      /*
        Это многострочный комментарий.
        Код ниже выведет на экран три одинаковые строчки.
       */
      String s = "Ho-ho-ho!";          // ОБЪЯВЛЕНИЕ ПЕРЕМЕННОЙ
      printTextMoreTimes(s, 3);         //ВЫЗОВ МЕТОДА
   }

                                       //  АРГУМЕНТЫ МЕТОДА
   public static void printTextMoreTimes(String s, int count) // ЗАГОЛОВОК МЕТОДА
   {
     // ЦИКЛ
      for (int i = 0 /*стартовое значение*/; i < count /*условие завершения*/; i++ /*действие после "тела"*/)
     // ТЕЛО ЦИКЛА
      {
         System.out.println(s);
      }
   }

}
