package com.birselepik._2_Week;

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

    // formatter2 (Best Practice)
    public static void formatter2() {
        // Eğer String.format() yazarsak kapatmak zorunda değiliz. GC (Garbarage Collector) otomatik çalışır.
        String formatterString = String.format("formatter2: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", "Birsel", 10203040, 34.44);
        System.out.println(formatterString);
    }

    // formatter3
    public static void formatter3() {

    }


    // formatter4
    public static void formatter4() {
        // printf (f yapısı formatter, formatları düzgün gözükmesi için. JAVA syntax yapısı C dilinden geliyor.)
        System.out.printf("formatter4: Merhabalar Adınız: %s, T.C: %d, Fiyat: %f", "Birsel", 10203040, 34.44);
    }


    public static void main(String[] args) {
        // formatter1();
        // formatter2();
        formatter3();
        // formatter4();
    }
}
