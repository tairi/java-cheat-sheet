package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа
*/

public class Solution {
    private static long S;

    public static long[] getNumbers(long N) {
        if (N <= 1) return new long[0];

        List<Long> armstrongList = new ArrayList<>();

        for (int i =0; i<=N; i++){
            S = N-i;
            if (getS(S) == S) {
                armstrongList.add(S);
            }
        }

        Collections.sort(armstrongList);

        long[] result = new long[armstrongList.size()];
        
        for (int i = 0; i < armstrongList.size(); i++) {
            result[i] = armstrongList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }


    //все в long
    public static long getS (long s){ //превратили число в список натуральных чисел
        String[] sNums = Long.toString(s).split("");
        long m = sNums.length;
       // ArrayList<Integer> sInt = new ArrayList<>();
        long resultS = 0;
        for (String s1 : sNums) {
            long s0 = Long.parseLong(s1);
            resultS += (long) Math.pow(s0, m); //возвели каждое НЧ в степень m и просуммировали
        }
        return resultS;
    }



}
