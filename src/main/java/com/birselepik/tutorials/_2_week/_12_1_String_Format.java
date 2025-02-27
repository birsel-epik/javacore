package com.birselepik.tutorials._2_week;

// Formatter
// %s: String
// %d: Decimal
// %f: Float

/*
    Garbarage Collectors:
    Yalnızca ama yalnızca kapalı olmayan dosya, scanner, formatter vb. yapılarda otomatik kapanmaz.
    Eğer biz bunu manuel olarak kapatmazsak bu kapatılmayan nesneyi temizleyebilir ancak açık olan dosyayı kapatmaz.
    Kapatınca RAM i temizliyor. Kapatılmazsa cache belleği kullanmaya devam ediyor.
*/

import com.birselepik.utils.SpecialColor;

import java.util.Formatter;

public class _12_1_String_Format {

    // formatter1
    public static void formatter1() {
        // Eğer new Formatter yazarsak close() ile manuel kapatmak zorundayız.
        Formatter formatter = new Formatter();
        formatter.format("formatter1: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", "Birsel", 10203040, 34.44);
        System.out.println(formatter);

        formatter.close(); // Belleği serbest bırakmak için kapatıyoruz
    }

    // formatter2 (Best Practice) [String.format]
    public static void formatter2() {
        // Eğer String.format() yazarsak kapatmak zorunda değiliz. GC (Garbarage Collector) otomatik çalışır.
        String formatterString = String.format("formatter2: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", "Birsel", 10203040, 34.44);
        System.out.println(formatterString);
    }

    // formatter3 (Best Practice)
    public static void formatter3() {
        String formatterString = String.format("formatter3: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", "Birsel", 10203040, 34.44);
        System.out.println(formatterString);
    }

    // formatter4 (printf)
    public static void formatter4() {
        // printf (f yapısı formatter, formatları düzgün gözükmesi için. JAVA syntax yapısı C dilinden geliyor.)
        System.out.printf("formatter4: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", "Birsel", 10203040, 34.44);
    }

    // formatter5
    public static void formatter5() {
        String name = "Birsel";
        int tcNumber = 10203040;
        double price = 34.44;
        System.out.printf("formatter5: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", name, tcNumber, price);
    }

    // formatter6
    public static void formatter6() {
        String name = "Birsel";
        int tcNumber = 10203040;
        double price = 34.44;
        System.out.printf("formatter6-1: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", name, tcNumber, price);
        System.out.println();
        System.out.printf("formatter6-2: Merhabalar Adınız: %10s, T.C: %d, Fiyat: %f", name, tcNumber, price); // %10s: sağdan 10 karakter boşluk bırakıyoruz
        System.out.println();
        System.out.printf("formatter6-3: Merhabalar Adınız: %-15s, T.C: %d, Fiyat: %f", name, tcNumber, price); // %-15s: soldan 15 karakter boşluk bırakıyoruz
        System.out.println();
        System.out.printf("formatter6-4: Merhabalar Adınız: %s, T.C: %15d, Fiyat: %f", name, tcNumber, price); // %15s: sağdan 15 karakter boşluk bırakıyoruz
        System.out.println();
        System.out.printf("formatter6-5: Merhabalar Adınız: %s, T.C: %d, Fiyat: %.3f", name, tcNumber, price); // %.3f Ondalık sayılarda virgülden sonra kaç karakter olsun
    }

    // formatter7 (Best Practice) [Special Color - 1]
    public static void formatter7() {
        String formatterString = String.format("formatter7: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", "Birsel", 10203040, 34.44);
        System.out.println(SpecialColor.YELLOW + formatterString + SpecialColor.RESET);
        System.out.println();
        System.out.println(formatterString);
    }

    // formatter8 (Best Practice) [Special Color - 2]
    public static void formatter8() {
        String formatterString =
                String.format("Merhabalar" + SpecialColor.GREEN + " Adınız:%s " + SpecialColor.RESET + "|" + SpecialColor.RED + " T.C: %d " + SpecialColor.RESET + "|" + SpecialColor.BLUE + " Fiyat: %.3f " + SpecialColor.RESET + "", "Birsel", 10203040, 34.44);
        System.out.println(SpecialColor.YELLOW + formatterString + SpecialColor.RESET);
        System.out.println();
        System.out.println(formatterString);
    }


    public static void main(String[] args) {
        // formatter1();
        // formatter2();
        // formatter3();
        // formatter4();
        // formatter5();
        // formatter6();
        // formatter7();
        formatter8();
    }
}
