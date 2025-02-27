package com.birselepik.tutorials._2_week;

public class _09_3_Conditional_Terniary {
    public static void main(String[] args) {
        // 1. YÖNTEM
        int number = 5;

        if (number > 0)
            System.out.println("Pozitif sayıdır");
        else
            System.out.println("Negatif sayıdır");

        // 2. YÖNTEM (Terniary)
        String result = (number > 0) ? "Pozitif sayıdır" : "Negatif sayıdır";
        System.out.println(result);
    }
}
