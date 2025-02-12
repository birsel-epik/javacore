package com.birselepik.Examples;

import java.util.Scanner;

public class _Week2_Example_1 {

    public static void main(String[] args) {
        // Scanner sınıfını kullanarak kullanıcıdan girdi alıyoruz.
        Scanner klavye = new Scanner(System.in);

        System.out.println("Lütfen bir sayı girin: ");
        int number = klavye.nextInt(); // Kullanıcıdan bir sayı girmesini iste

        // 1. Örnek Sayının durumunu kontrol ediliyor
        /* if (number > 0) {
            System.out.println("Girdiğiniz sayı pozitif.");
        } else if (number < 0) {
            System.out.println("Girdiğiniz sayı negatif.");
        } else {
            System.out.println("Girdiğiniz sayı sıfır.");
        }*/


        // 2. Örnek Sayının durumunu kontrol ediliyor
       /* if(number%2==0) {
            System.out.println(number+" sayı Çift sayıdır");
        }
        else {
            System.out.println(number+" sayı Tek sayıdır");
        }*/


        // 3. Örnek Sayının durumunu kontrol ediliyor
        // Validation
        // 1-) Kullanıcı pozitif bir syı girmezse? (Math.abs(), Negatif sayı çarp)
        // 2-) Kullanıcı harf girerse
        // 3-) Sıfır (Çift)

        if(number<0) {
            System.out.println("Negatif bir sayı girdiniz");
        }
        else {
            System.out.println("Pozitif bir sayı girdiniz");
        }

        if(number%2==0) {
            System.out.println(number+" sayı Çift sayıdır");
        }
        else {
            System.out.println(number+" sayı Tek sayıdır");
        }


    }
}
