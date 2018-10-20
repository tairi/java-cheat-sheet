package ru.tayrinn.firstlessons;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 21.10.17
 * Time: 11:46
 * To change this template use File | Settings | File Templates.
 */
public class Home {
    public static Integer a;

    public static void action(String[] args){
        System.out.println("Амиго очень умный");
        a = 10;
        print2("Неведомая фигня", 42);
        print2("Ещё одна неведомая фигня", 43);
    }

    public static void print2(String arg1, Integer arg2){
        System.out.println(a);
        System.out.println(arg1 + " = " + (a + arg2));
//       action(new String[]{});
    }


}
