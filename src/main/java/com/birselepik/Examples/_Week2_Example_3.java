package com.birselepik.Examples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _Week2_Example_3 {

    /*
    Kullanıcıdan Girilen Sayının Faktoriyelini Bulma
    Soru:
    Kullanıcıdan bir tam sayı alarak faktöriyelini hesaplayan iterative ve recursive metota göre  programı yazınız.
    Kullanıcı sıfırdan küçük sayı verene kadar hesalama yapsın
    */

    /* Hocanın Çözümü */

    public static void main(String[] args) {
        // Iterative
        // Variables
        // result:1 vermeliyiz ki, 1 sayısı çarpmada etkisizdir ve başlangıç değerimizdir.
        long number, result=1;

        // Scanner
        Scanner scanner = new Scanner(System.in);

        //Sonsuz Döngü
        while (true) {

        }
    }


    /// /////////////////////////////////

    /*
    Kullanıcıdan Girilen Sayının Faktoriyelini Bulma
    Soru:
    Kullanıcıdan bir tam sayı alarak faktöriyelini hesaplayan iterative ve recursive metota göre  programı yazınız.
    */

    /* Benim Çözümüm */
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = -1; // Başlangıç değeri, geçersiz bir durumu temsil eder.

        // Kullanıcıdan geçerli bir tam sayı al
        while (true) { // sonsz döngü
            System.out.println("Bir pozitif tam sayı girin: ");
            try {
                number = scanner.nextInt();
                if (number < 0) {
                    System.out.println("Hata: Negatif bir sayı girdiniz. Lütfen pozitif bir tam sayı girin.");
                } else {
                    break; // Geçerli bir sayı alındığında döngüden çık
                }
            } catch (InputMismatchException e) {
                System.out.println("Hata: Geçersiz giriş. Lütfen bir tam sayı girin.");
                scanner.next(); // Hatalı girişi temizle
            }
        }

        // Faktöriyel hesaplama
        long iterativeSonuc = fektoriyelIterative(number);
        long recursiveSonuc = faktoriyelRecursive(number);

        System.out.println(number + " sayısının faktöriyeli (iteratif): " + iterativeSonuc);
        System.out.println(number + " sayısının faktöriyeli (özyinelemeli): " + recursiveSonuc);

        scanner.close(); // Scanner'ı kapat
    }


    // iterative yöntemle faktöriyel hesaplama
    public static long fektoriyelIterative(int n) {
        long sonuc = 1;
        for (int i = 0; i <= n; i++) {
            sonuc *= i;
        }
        return sonuc;
    }


    // recursive yöntemle faktöriyel hesaplama
    public static long faktoriyelRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * faktoriyelRecursive(n - 1);
        }
    }

}
