package ru.tayrinn.firstlessons;

public class StackTraceElement0000 {


    public static void main(String[] args) {

        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        String a = Thread.currentThread().getStackTrace()[2].getClassName();      //класс вызвавший метод
        String b = Thread.currentThread().getStackTrace()[2].getMethodName();

        System.out.println(a + ": " + b + ": "+ s);

        System.out.print(Thread.currentThread().getStackTrace()[2].getMethodName()); // печать метода, который вызвал этот метод
        System.out.print(Thread.currentThread().getStackTrace()[2].getLineNumber()); //номер строки кода, откуда вызван метод
        int gl = Thread.currentThread().getStackTrace().length;                       //количество позиций в стектрейсе  "глубина"

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();    //полный массив
        for (StackTraceElement element : stackTraceElements)
        {
            System.out.println(element.getMethodName());                                     //печать списка всех открытых методов
        }
    }
}
