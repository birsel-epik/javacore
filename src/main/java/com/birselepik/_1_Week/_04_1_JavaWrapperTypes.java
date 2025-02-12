package com.birselepik._1_Week;

public class _04_1_JavaWrapperTypes {
    // Heap Memory kullanılır.

    public static void main(String[] args) {
        // PRIMITIVE TYPE
        // Veri değişken isimlerini yazarken küçük harfle başlar;
        byte primitiveTypeByte = 127;
        // primitiveTypeByte = null; // primitive type null değer alamaz.
        System.out.println(primitiveTypeByte);
        short primitiveTypeShort = 32767;
        int primitiveTypeInt = 2147483647;
        long primitiveTypeLong = 9223372036854775807L;

        float primitiveTypeFloat=14.23f;
        double primitiveTypeDouble=14.23;

        boolean primitiveTypeBoolean=true;
        char primitiveTypeChar='a';
        ///////////////////////////////////////////////////////////////////

        // WRAPPER TYPE
        // Primitive Type - Wrapper Typen Arasındaki farklar ?
        // Veri değişken isimlerini yazarken büyük harfle başlar;
        // Stack
        Byte wrapperTypeByte = 127;
        wrapperTypeByte = null; // wrapper class null verebiliriz.
        System.out.println(wrapperTypeByte);
        Short wrapperTypeShort = 32767;
        Integer wrapperTypeInt = 2147483647;
        Long wrapperTypeLong = 9223372036854775807L;

        Float wrapperTypeFloat=14.23f;
        Double wrapperTypeDouble=14.23;

        Boolean wrapperTypeBoolean=true;
        Character wrapperTypeChar='a';
    }

}
