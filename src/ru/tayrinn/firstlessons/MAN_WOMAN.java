package ru.tayrinn.firstlessons;


/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 30.10.17
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
public class MAN_WOMAN {
        public static void main(String[] args) {
        //задача из JavaRuch, разъяснить, что значит написанное при условии (сама написала - сама не поняла)
        Man man1 = new Man (5);
        Woman woman1 = new Woman ();
        man1.wife = woman1;    //зелезли в объект, взяли поле класса и запихнули туда объект woman1
        woman1.husband = man1;
            double a = Math.PI; //сохранила в а значение пи из класса Math
            double b=Math.sqrt(20);
            System.out.println(a+"\n"+b);
    }

    public static class Man {
        public int age;         //поле класса
        public int height;
        public Woman wife;

        public Man(int age) {
            this.age = age;
        }
    }

    public static class Woman {
        public int age;
        public int height;
        public Man husband;
    }
}
