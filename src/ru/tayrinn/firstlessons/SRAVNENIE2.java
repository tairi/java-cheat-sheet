package ru.tayrinn.firstlessons;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 02.11.17
 * Time: 1:13
 * To change this template use File | Settings | File Templates.
 */
public class SRAVNENIE2 {
       public static int min(int a, int b, int c, int d) {
        //напишите тут ваш код
           int n;
        min(a, b);
        if (c<d)
            n=c;
        else
            n=d;
        if (min(a, b)<n)
            return (min(a, b));
        else
            return (n);
    }

    public static int min(int a, int b) {
        //напишите тут ваш код
        if
            (a<b)
            return (a);
        else
            return (b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-20, -10, -30, -40));
        System.out.println(min(-20, -10, -30, 40));
    }
}
