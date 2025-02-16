package com.birselepik._1_Week;

public class _04_5_Cast {

    // Cast -> Dönüşüm (Bir verinin başka bir veriye dönüşmesidir)
    public static void main(String[] args) {

        // 1-) Widening Cast -> Implicit Cast
        byte cast1Byte = 100; // Küçük olan veriyi
        int cast1Int = cast1Byte; // Büyük olan verinin içine ekledim (Veri kaybı yoktur)
        System.out.println("cast1Int :" + cast1Int);


        // 2-) Narrowing Cast -> Explicit Cast
        int cast2Int = 999999999;
        byte castByte2 = (byte) cast2Int;
        System.out.println("castByte2: " + castByte2); // Veri kaybı oluyor


        // 3-) char => Int
        char cast3Char = 'B';
        int ascii1 = cast3Char;
        System.out.println(cast3Char + " harfinin ascii olarak karşılığı: " + ascii1);

        int ascii2 = 38;
        char cast3Int = (char) ascii2;
        System.out.println(ascii2 + " ascii kodunun karşılığı: " + cast3Int);
    }
}
