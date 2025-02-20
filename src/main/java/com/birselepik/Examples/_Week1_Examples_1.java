package com.birselepik.Examples;

public class _Week1_Examples_1 {
    public static void main(String[] args) {
        int number1 = 10;
        number1++;
        System.out.printf("Number 1: " + number1);

        System.out.println("\n");

        int number2 = 20;
        ++number2;
        System.out.println("Number 2: " + number2);
    }
}


// 1. Postfix Artış: (number1++)
// Tanım: number1++ ifadesi, "postfix" artış operatörüdür. Bu, mevcut değeri kullanarak bir işlemi gerçekleştirir ve ardından değişkenin değerini bir artırır.
// Çalışma Şekli:
// İlk olarak, number1'ın mevcut değeri kullanılır.
// Sonrasında number1'ın değeri 1 artırılır.


// 2. Prefix Artış: (++number2)
// Tanım: ++number2 ifadesi, "prefix" artış operatörüdür. Bu, önce değişkenin değerini artırır ve ardından yeni değeri kullanır.
// Çalışma Şekli:
// İlk olarak, number2'nin değeri 1 artırılır.
// Sonrasında yeni değeri kullanılır.


// Sonuç:
// Her iki ifade de number1 ve number2 değişkenlerinin değerini 1 artırır, ancak kullanım sırasındaki fark, number1++ mevcut değeri kullanırken, ++number2 yeni artırılmış değeri kullanır.
// Ancak bu durumda, her iki değişken de sonunda aynı sonucu verir (11).
// Bu fark genellikle daha karmaşık ifadelerde, örneğin bir değişkenin başka bir değişkenle birleştirildiği durumlarda daha belirgin hale gelir.