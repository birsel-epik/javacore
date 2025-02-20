package com.birselepik.Examples;

import java.util.Scanner;

public class _Week1_Examples_3 {

/*
1. 1. Dereceden 1 Bilinmeyenli Denklemi Çözme (Scanner kullanalım)
Soru:
Kullanıcıdan ax + b = 0 denklemindeki a ve b değerlerini alıp x'i hesaplayan programı yazınız.
*/

    public static void main(String[] args) {
        //Scanner
        Scanner inputValue = new Scanner(System.in);

        //Variable
        double aValue, bValue = 0, result;

        System.out.println("Lütfen b değerini giriniz:");
        bValue = inputValue.nextDouble();

        System.out.println("Lütfen a değerini giriniz:");
        aValue = inputValue.nextDouble();

        // if else öğrendikden sonra buraya bakalım. 2. hafta ödevi olarak ekleyelim.
        // ax+b=0 -> x=-b/a
        result = (-bValue / aValue);
        System.out.println("a değeri: \n" + aValue + "b değeri: \n" + bValue + "Sonuç :" + result);

        inputValue.close();
    }
}

