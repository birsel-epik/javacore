package com.birselepik.tutorials._2_week;

public class _10_2_Loop_While {
    // For döngüsünden farklı, başlangıç değeri vermeyebiliriz.
    public static void main(String[] args) {

        // Aşağıdaki 3 yöntemde sayıyı 1 er 1 er artırır, hepsi aynıdır.
        // i++
        // i=i+1
        // i+=1

        int i = 1;
        while (i <= 20) {
            System.out.print(i + " - ");
            i++;
        }

        // while döngüsü sonsuzluk
        // while(;true) {}
    }
}
