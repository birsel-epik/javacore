package com.birselepik.Examples;

import java.util.Scanner;

public class _Week3_Examples_2 {

    // Kullanıcının Soyisminin ilk üç harfini büyük yazınız ve soyisimi eğer 3 harften fazlaysa geri kalan harflerinin yerine yıldız (*)
    // Hamit MIZRAK , Hamit MIZ***(Maskeleme)
    // Tip(loop, conditional)


    // Benim çözümüm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan ad ve soyad alma
        System.out.println("Adınızı girin: ");
        String name = scanner.nextLine();

        System.out.println("Soyadınızı girin: ");
        String surname = scanner.nextLine();

        // Soyadın uzunluğunu kontrol et
        String maskedSurname;
        if (surname!=null && surname.length() >= 3) {
            // İlk üç harfi büyük, geri kalanını yıldız ile maskele
            String firstThreeLetters = surname.substring(0, 3).toUpperCase();
            int remainingLenght = surname.length() - 3;
            String stars = "*".repeat(remainingLenght);
            maskedSurname = firstThreeLetters + stars;
        } else {
            // Soyadı 3 harften kısa veya eşitse, hepsini büyük yap
            maskedSurname = surname.toUpperCase();
        }

        // Sonucu yazdırma
        System.out.println("Sonuç: " + name + " " + maskedSurname);

        scanner.close();

    }
}
