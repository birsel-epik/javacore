package com.birselepik.examples;

/*
Java'da constructor ve static blokları, nesne oluşturma ve sınıf başlatma süreçlerinde farklı amaçlara hizmet eder.

Bu iki yapı arasındaki temel farklar:
Constructor: Her nesne oluşturulduğunda çalışır ve nesneye özgü değerler ayarlar.
Static Block: Sınıf yüklendiğinde bir kez çalışır ve statik alanları başlatır.

Temel Farklar
Özellik	            Constructor	                                    Static Block
Çalışma Zamanı	    Her nesne oluşturulduğunda çalışır.	            Sınıf yüklendiğinde bir kez çalışır.
Amaç	            Nesneye özgü başlangıç değerlerini ayarlamak.	Sınıf düzeyinde statik alanları başlatmak.
Erişim	            Her nesne için geçerli.	                        Tüm nesneler için ortaktır.
Geri Dönüş Değeri	Yoktur.	                                        Yoktur (statik bir blok olarak tanımlanır).

*/

import com.birselepik.utils.SpecialColor;

public class _Week3_Examples_3 {

    private int instanceValue;
    static int staticValue;

    // Constructor
    public _Week3_Examples_3(int value) {
        this.instanceValue = value;
    }

    // Static Block
    static {
        staticValue = 10; // Static alan başlatma
        System.out.println("Static  block çalıştı.");
    }

    public void display() {
        System.out.println(SpecialColor.PURPLE + "Instance Value: " + instanceValue + SpecialColor.RESET);
        System.out.println(SpecialColor.YELLOW + "Static Value: " + staticValue + SpecialColor.RESET);
    }

    public static void main(String[] args) {
        _Week3_Examples_3 obj1 = new _Week3_Examples_3(5);
        obj1.display();

        _Week3_Examples_3 obj2 = new _Week3_Examples_3(15);
        obj2.display();
    }
}


