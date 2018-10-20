package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MINIMUM {
    public static void main(String[] args) throws Exception {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           int N = Integer.parseInt(reader.readLine());
           int i;
           int maximum=Integer.MIN_VALUE;
           for (i=0;true;++i) {
               if (i == N) break;
               int a = Integer.parseInt(reader.readLine());
               if (a>=maximum)
               maximum = a;
               else maximum = maximum;

           }



           //напишите тут ваш код

           System.out.println(maximum);
       }
}
