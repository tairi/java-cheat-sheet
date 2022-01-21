package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        ConsoleHelper.writeMessage("\n \n Пожалуйста, выберите блюдо из списка:" + Dish.allDishesToString() + "\n или введите 'exit', чтобы завершить заказ");

        while (true) {
            String dishName = ConsoleHelper.readString().trim();
            if ("exit".equalsIgnoreCase(dishName)) {
                break;
            }

            try {
                Dish dish = Dish.valueOf(dishName);
                dishes.add(dish);
                writeMessage(dishName + " был успешно добавлен в ваш заказ");
            } catch (Exception e) {
                writeMessage(dishName + " не был обнаружен");
            }
        }

        return dishes;
    }
   /*  - для вывода message в консоль
-  - для чтения строки с консоли
- List<Dish> getAllDishesForOrder() - просит пользователя выбрать блюдо и добавляет его в список.

    1. Метод writeMessage класса ConsoleHelper должен выводить полученную строку в консоль.
2. Метод readString класса ConsoleHelper должен возвращать строку считанную с консоли.
3. Метод getAllDishesForOrder класса ConsoleHelper должен возвращать список блюд выбранных пользователем.*/

}
