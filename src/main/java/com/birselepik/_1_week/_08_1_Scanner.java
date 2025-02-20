package com.birselepik._1_week;

import java.util.Scanner;

public class _08_1_Scanner {

    public static void main(String[] args) {
        // Field en üstte yazmak daha iyi olur
        String name, surname;
        int language;

        // Kullanıcıdan veri alnak istiyorsak
        Scanner klavye = new Scanner(System.in);

        // nextLine() alt satıra geçer. next() aynı satırda imleç yanıp söner.
        System.out.println("Lütfen adınızı giriniz:");
        name = klavye.nextLine();

        System.out.println("Lütfen soyadınızı giriniz:");
        surname = klavye.nextLine();

        System.out.println("Bildiğiniz Diller & Teknolojiler");
        language = klavye.nextInt();

        // Ödev: Char ı kullanmak istersek ne yapacağız? Öğren???
        // Ödev: String'den int geçerken Scanner sorununu nasıl çözebiliriz? (Dillerde direk alt satıra gitti).

        System.out.println("Adınız: " + name + ", Soyadınız: " + surname + "" + "\ndiller: " + language);

        //kullanmadığımız scanner nesnesini kapatalım.
        klavye.close();


        // Benim Örneğim
       /* Scanner scanner = new Scanner(System.in); // Scanner nesnesi oluşturuluyor.

        System.out.println("Bir sayı girin: ");
        int number = scanner.nextInt(); // Kullanıcıdan bir tam sayı al

        System.out.println("Girdiğiniz sayı: " + number);

        // Satır bazında girdi almak için
        scanner.nextLine(); // Bu, önceki nextInt() çağrısından kalan satır sonunu temizler

        System.out.println("Bir metin girin: ");
        String content = scanner.nextLine(); // Kullanıcıdan bir metin al

        System.out.println("Girdiğiniz metin: " + content);

        scanner.close(); // Scanner'ı kapat. Ram i meşgul ediyor. */
    }
}
