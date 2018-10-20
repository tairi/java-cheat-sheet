package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CIKLE_V_CHAS_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double readTime = Double.parseDouble(s);
        System.out.println(CIKLE_V_CHAS_2(readTime));
    }
    public static String CIKLE_V_CHAS_2(double readTime){
        int roundedTime = (int) Math.ceil(readTime);
        if (roundedTime % 5 == 0)      //% - значение остатка  "если остаток от деления на 5 == 0, то..."
        return "red";
        else if (roundedTime % 5 <= 3)
        return "green";
        else
        return "yellow";

    }
}
       /*(int) Math.ceil(readTime) - округление вверх
         (int) Math.floor(readTime)  - округление вниз
         (int) Math.round(readTime)  - согласно правилам
        */