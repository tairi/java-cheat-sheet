package ru.tayrinn.firstlessons;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 02.11.17
 * Time: 0:20
 * To change this template use File | Settings | File Templates.
 */
public class MOON {
        public static void main(String[] args) {
        System.out.println(getWeight(888));
    }

    public static double getWeight(int weightEarth) {
        //напишите тут ваш код
        double weightMoon = weightEarth*0.17;
        return (weightMoon);
    }
}
