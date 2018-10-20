package ru.tayrinn.firstlessons;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 30.10.17
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
public class KONVERTR {
    public static void main(String[] args) {
    System.out.println(convertCelsiumToFahrenheit(41));
    }

    public static double convertCelsiumToFahrenheit(int Celsium) {
        //напишите тут ваш код
       /* int celsium = (tf-32)*5/9;*/
        double tf=Celsium*9/5.0+32;
        return tf;
    }
}
