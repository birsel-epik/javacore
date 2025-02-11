package com.birselepik._1_part_javatypes;

public class _03_JavaPrimitiveTypes {
    // Primitive Tupes: 8 tanedir, null değer alamazsınız.

    public static void main(String[] args) {
        // Veri değişken isimlerini yazarken;

        // tam sayılar (4)
        byte b1=127;
        System.out.println("byte: "+b1);

        short s1=32767;
        System.out.println("short: "+s1);

        int i1=2147483647;
        System.out.println("int: "+i1);

        long l1=9223372036854775807L;
        System.out.println("long: "+l1);

        // virgüllü (floating point)
        float f2=3.14f;
        System.out.println("float: "+f2);

        double d2=3.14;
        System.out.println("double: "+d2);

        // boolean (mantıksal, ilk değeri false olarak alır)
        boolean b3=true;
        System.out.println("boolean: "+b3);

        // char
        char c4= '\u4125';
        System.out.println("char: "+c4);

        // Matemetik dünyasında sadece Toplama var. Çıkartma, çarpma, bölme yok.
        // Çıkartma - 2 ye tümleme
        // Çarpma  - kaydırarak toplama yapıyor.
        // Bölme - Çarpma ve kaydırma yapıyor.
        // Bilgisayar dünyası 2 lik sayısal sistemde çalışan, sadece 0 ve 1 lerden oluşan yapılardır.
    }
}

