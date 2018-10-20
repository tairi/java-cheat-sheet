package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CIKLE_V_HAS {
    public static void main(String[] args) throws Exception {
            //напишите тут ваш код
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            double a = Double.parseDouble(s);
            if ((a <= 3 && a > 0) || (a > 5 && a <= 8) || (a > 10 && a <= 13) || (a > 15 && a <= 18) || (a > 20 && a <= 23) || (a > 25 && a <= 28) || (a > 30 && a <= 33) ||
                    (a > 35 && a <= 38) || (a > 40 && a <= 43) || (a > 45 && a <= 48) || (a > 50 && a <= 53) || (a > 55 && a <= 58))
                System.out.println("зелёный");
            else if ((a > 3 && a <= 4) || (a > 8 && a <= 9) || (a > 13 && a <= 14) || (a > 18 && a <= 19) || (a > 23 && a <= 24) || (a > 28 && a <= 29) || (a > 33 && a <= 34) ||
                    (a > 38 && a <= 39) || (a > 43 && a <= 44) || (a > 48 && a <= 49) || (a > 53 && a <= 54) || (a > 58 && a <= 59))
                System.out.println("жёлтый");
            else
                System.out.println("красный");
        }
}
   //использование логических выражений