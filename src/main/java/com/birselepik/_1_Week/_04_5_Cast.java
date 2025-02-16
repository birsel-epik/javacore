package com.birselepik._1_Week;

public class _04_5_Cast {

    // Cast -> Dönüşüm (Bir verinin başka bir veriye dönüşmesidir)
    // Daha küçük bir türü daha büyük bir veriye dönüştürmek için kullanılır.
    public static void main(String[] args) {

        // 1-) Widening Cast => Implicit Cast (KApalı )
        byte cast1Byte = 100; // Küçük olan veriyi
        int cast1Int = cast1Byte; // Büyük olan verinin içine ekledim (Veri kaybı yoktur)
        System.out.println("cast1Int :" + cast1Int);


        // 2-) Narrowing Cast => Explicit Cast (Açık)
        // Daha büyük bir türü daha küçük bir veriye dönüştürmek için kullanılır.
        int cast2Int = 999999999;
        byte castByte2 = (byte) cast2Int; // tipi değiştiriyoruz
        System.out.println("castByte2: " + castByte2); // Veri kaybı oluyor


        // 3-) char => Int
        char cast3Char = 'B';
        int ascii1 = cast3Char;
        System.out.println(cast3Char + " harfinin ascii olarak karşılığı: " + ascii1);

        int ascii2 = 38;
        char cast3Int = (char) ascii2; // tipi değiştiriyoruz
        System.out.println(ascii2 + " ascii kodunun karşılığı: " + cast3Int);


        // 4-) String => Int
        // 1. Örnek
        String cast4String = "10";
        System.out.println("cast4String :" + cast4String + 20);

        // 2. Örnek
        String cast5String = "10";
        int cast4Int = Integer.valueOf(cast5String);
        System.out.println(cast4Int + 20);

        // 3. Örnek
        String cast6String = "10";
        int cast5Int = Integer.parseInt(cast6String);
        System.out.println(cast5Int + 20);


        // 5-) int => String
        // 1. Örnek
        int cast6Int = 55;
        String cast7String = String.valueOf(cast6Int);
        System.out.println(cast7String);

    }
}
