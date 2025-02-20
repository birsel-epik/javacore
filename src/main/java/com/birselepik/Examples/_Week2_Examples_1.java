package com.birselepik.Examples;

import java.util.Scanner;

public class _Week2_Examples_1 {

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
        // 1-) Kullanıcı pozitif bir sayı girmezse? (Math.abs(), Negatif sayı çarp)
        // 2-) Kullanıcı harf girerse
        // 3-) Sıfır (Çift)

        if (number < 0) {
            System.out.println("Negatif bir sayı girdiniz");
        } else {
            System.out.println("Pozitif bir sayı girdiniz");
        }

        if (number % 2 == 0) {
            System.out.println(number + " sayı Çift sayıdır");
        } else {
            System.out.println(number + " sayı Tek sayıdır");
        }


        // 4. Örnek Sayının durumunu kontrol ediliyor
        // Validation
        // 1-) Kullanıcı pozitif bir sayı girmezse? (Math.abs(), Negatif sayı çarp)
        // 2-) Kullanıcı harf girerse
        // 3-) Sıfır (Çift)
        Scanner inputValue = new Scanner(System.in);
        System.out.println("Bir sayı girin");

        // Kullanıcının girdiği değeri al
        String input = inputValue.nextLine();

        try{
            // Girdiği değeri tam sayıya çevir
            int number2 = Integer.parseInt(input);

            // Pozitif, negatif veya sıfır kontrolü
            if (number2 > 0) {
                System.out.println("Girilen sayı pozitiftir.");
            }
            else if (number2 < 0) {
                System.out.println("Girilen sayı negatiftir.");
            }
            else {
                System.out.println("Sıfır çift bir sayıdır.");
            }
        }
        catch (NumberFormatException e) {
            // Hatalı giriş durumunda
            System.out.println("Lütfen bir sayı girin");
        }

        /* if (number < 0) {
            System.out.println("Negatif bir sayı girdiniz");
            //number=Math.abs(number);
            number = number * (-1);
        } */

        klavye.close();
        inputValue.close();
    }
}
