package ru.tayrinn.firstlessons;

public class UMNOJENIE {
    public static void main(String[] args) {
        for (int i = 1; i < 11; ++i) {
            for (int j = 1; j < 11; ++j) {
                System.out.print(String.format("%3d ", i * j));
            }
            System.out.println("");
        }
    }
}
