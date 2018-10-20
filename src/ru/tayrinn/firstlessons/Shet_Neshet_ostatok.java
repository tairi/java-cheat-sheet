package ru.tayrinn.firstlessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shet_Neshet_ostatok {

    public static int even;     //четный
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        for (;a!=0;a=a/10) {
            if (a % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
