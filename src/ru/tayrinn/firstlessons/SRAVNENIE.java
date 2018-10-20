package ru.tayrinn.firstlessons;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 02.11.17
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */
public class SRAVNENIE {
    public static int min(int a, int b, int c) {
        //напишите тут ваш код
        int m;
        if (a<b)
            m=a;
        else
            m=b;
        if (m<c)
            return (m);
        else
            return (c);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(10, 5, 10));
    }
}
