package com.birselepik.Examples;

import java.util.Scanner;

/*
Kullanıcının Verdiği pozitif bir sayıya kadar toplamını yapan hesaplayan Algoritma ?
Şartlar - 1 : Kullanıcı eğer sayı değeri olarak 100 den fazla değer girerse 100 e kadar olanı toplasın. (break)
Şartlar - 2 : Kullanıcının verdiği sayılar içinde eğer 47 varsa bunu toplamaya dahil etmesin.(continue)
Çıkan sonuç tek mi ? Çift mi ?
*/

public class _Week2_Examples_2 {
    public static void main(String[] args) {
        Scanner inputValue = new Scanner(System.in);
        System.out.println("Lütfen pozitif bir sayı giriniz: ");
        int number = Math.abs(inputValue.nextInt());

        // Başlangıç değer
        int sum = 0;
        // Loop
        for (int i = 1; i <= number; i++) {
            // Eğer 47 varsa toplama
            if (i == 47) {
                System.out.println("Verdiğiniz sayıda 47 olduğu için toplamaya dahil etmiyoruz.");
                continue; // 47 toplama dahil etme
            }

            // Eğer 100 den fazla verilirse
            if (i > 100) {
                System.out.println("Verdiğiniz sayı 100 den büyük olduğu için sadece 1<=NUMBER<=100 e kadar toplama yapılabilir.");
                break; // 100 den sonra toplamayı durdur
            }

            // Toplama
            // sum = sum+1;  // 1. YOL
            sum += i;
        }

        System.out.println("Toplam: " + sum);

        // Çıkan sonuç Çift mi ? Tek mi?
        if (sum % 2 == 0)
            System.out.println(sum + " sayı çift");
        else
            System.out.println(sum + " sayı tek");

        inputValue.close();
    } // end psvm
} // end class
