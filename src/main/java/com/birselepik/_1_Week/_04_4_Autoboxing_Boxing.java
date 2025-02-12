package com.birselepik._1_Week;

public class _04_4_Autoboxing_Boxing {

    public static void main(String[] args) {
        // Autoboxing: Primitive => Wrapper Type dönüştürmek
        int primitiveValue = 100;
        Integer wrapperValue = primitiveValue; // Autoboxing
        // wrapperValue = null; // Wrapper Type null değer alabilir.
        System.out.println("primitive type: " + primitiveValue + " -> wrapper type: " + wrapperValue);


        // unboxing: Wrapper Type => Primitive Type dönüştürmek
        Integer wrapperValue2 = 200;
        int primitiveValue2 = wrapperValue2; // Unboxing
        System.out.println("wrapper type2: " + wrapperValue2 + " -> primitive type2: " + primitiveValue2);

    }
}
