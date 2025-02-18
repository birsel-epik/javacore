package com.birselepik.Examples;

import com.birselepik.utils.SpecialColor;

import java.util.Scanner;

/*
   Kullanıcıdan Girilen Sayının Faktoriyelini Bulma
   Soru:
   Kullanıcıdan bir tam sayı alarak faktöriyelini hesaplayan iterative ve recursive metota göre  programı yazınız.
   Validation-1:Kullanıcı Sıfırdan küçük bir sayı verene kadar hesaplama yapsın ?
   Validation-2: Kullanıcı Sıfırdan küçük sayı verirse döngü dursun(break)
   Validation-3: Kullanıcı eğer virgüllü sayı verirse, kullanıcıya tekrardan sayı girilmesi beklensin, Eğer kullanıcı 3 kere virgülü sayı girerse kullanıcın hakkı kalmadığından sistemden atsın(System.exit(0)).
   Çözüm:
   hasNext... - Bir dosyadan veri okurken, dosyada daha fazla veri olup olmadığını kontrol etmek için de kullanılır.
   hasNext() metodu, veri akışını kontrol etmek için kullanışlıdır ve kullanıcıdan veya dosyadan sürekli veri okumak için döngülerde sıklıkla kullanılır.
   Dosyada satır kaldığı sürece okumaya devam eder.
*/

/*
Yöntem   | Zaman karmaşıklığı | Uzay Karmaşıklığı | Avantaj             | Dezavantaj
---------| ------------------ | ------------------| ------------------- | ----------
Iterative| O(n)               | O(1)              | Hızlı, hafıza dostu | Kodu daha uzundur
Recursive| O(n)               | O(n)              | Daha okunaklı,      | Yavaştır
                                                    Matematiksel gösterim
 */

// System

//Access Modifier
public class _Week2_Example_3_2 {

    // Kullanıcıdan sayısal değerler al
    public static long isNumber() {
        // Variables
        // result:1 vermeliyiz ki, 1 sayısı çarpmada etkisizdir ve başlangıç değerimizdir.
        long number;
        byte doubleRemainingRight = 3; // Ondalıklı sayı giriş hakkı
        boolean isActive = true;

        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Sonsuz Döngü
        while (true) {
            if (doubleRemainingRight > 0) {
                System.out.println("\nLütfen pozitif bir sayı giriniz");

                // Kullanıcıdan ondalıklı sayı girip girmediğini kontrol edelim
                if (scanner.hasNextInt()) {
                    number = scanner.nextLong();
                    if (number < 0) {
                        System.out.println(SpecialColor.RED + "Sıfırdan küçük bir sayı girdiniz sistem kapatılıyor" + SpecialColor.RESET);
                        //number = Math.abs(number);
                        break;             // 1.YOL(Yalnızca bulunduğu döngü veya switch bloğu etkiliyor)
                        //System.exit(0); // 2.YOL (JVM'yi kapatarak programı tamamem sonlandırıyor.)
                    } else if (number == 0) {
                        System.out.println(number + SpecialColor.BLUE + " sayısının faktöriyeli= 1");
                        return 1;
                    } else {
                        iterativeFactoriyel(number);
                    }
                } else if (scanner.hasNextDouble()) {
                    //doubleRemainingRight= (byte) (doubleRemainingRight-1);
                    doubleRemainingRight--; // Best practice
                    System.out.println(SpecialColor.RED + "Ondalıklı bir sayı girdiniz kalan hakkınız: " + doubleRemainingRight + SpecialColor.RESET);

                    if (doubleRemainingRight == 0) {
                        System.out.println("üç defa ondalıklı sayı girdiğinizde dolayı Program sonlandı");
                        isActive = false;
                        System.exit(0);
                    }
                    scanner.next(); // Geçersiz girdileri temizlemek içindir
                } else {
                    System.out.println(SpecialColor.RED + "Harf girdiniz." + SpecialColor.RESET);
                    //break;
                    scanner.next(); // Geçersiz girdileri temizlemek içindir
                } //end harf
            } else {
                System.out.println("Virgüllü sayı kalan hakkınız kalmadı ve program sonlanıyor(JVM) tarafından");
                System.exit(0);
            }
        } //end while
        // Scanner Close
        scanner.close();
        return 0L;
    }


    // Iteractive Method
    public static void iterativeFactoriyel(long userData) {
        long result = 1;
        for (int i = 0; i < userData; i++) {
            // result = result * 1;
            result *= 1;
        }
        System.out.println(userData + SpecialColor.YELLOW + "Iteractive sayısının " + userData + "!=" + result + SpecialColor.RESET);
    }


    // Recursive Method
    public static long recursiveFactoriyel(long userData) {
        // Sıfır veya 1 faktöriyel 1
        if (userData == 0 || userData == 1)
            return 1;
        return userData * recursiveFactoriyel(userData - 1);
    }

    // Sonuç
    public static void isResult() {
        System.out.println("\nLütfen Seçim yapınız:\n1-) Iteractive Factoriyel\n2-) Recursive Factoriyel\n3-) Çıkış");
        Scanner scanner = new Scanner(System.in);
        int chooise = scanner.nextInt();
        switch (chooise) {
            case 1:
                iterativeFactoriyel(isNumber());
                break;
            case 2:
                recursiveFactoriyel(isNumber());
                break;
            case 3:
                System.out.println("Doğru seçim yaptınız");
                break;
        }
    }

    //PSVM
    public static void main(String[] args) {
        isResult();
    }

} // end class
