package com.birselepik.examples;

import java.util.Scanner;

public class _Week1_Examples_4 {

/*
2. Santigrat (Celsius) - Fahrenheit Dönüştürücü (Scanner kullanlalım)
   Soru:
   Kullanıcıdan Santigrat (Celsius) cinsinden sıcaklık alıp Fahrenheit'e çeviren programı yazınız.
   Formül: F = (C * 9/5) + 32
   Çözüm:
*/

    public static void main(String[] args) {
        //Scanner
        Scanner inputValue = new Scanner(System.in);

        //Variable
        double cValue = 0, fValue;

        System.out.println("Lütfen Celsius sıcaklık değerini giriniz: ");
        cValue = inputValue.nextDouble();

        fValue = (cValue * 9 / 5) + 32;

        System.out.println("Girmiş olduğunu sıcaklık değeri: " + fValue + " Fahrenheit");

        inputValue.close();
    }
}

