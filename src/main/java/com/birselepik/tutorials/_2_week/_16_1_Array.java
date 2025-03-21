package com.birselepik.tutorials._2_week;

import com.birselepik.utils.SpecialColor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class _16_1_Array {

    // Array
    public static String[] arrayMethod1() throws ArrayIndexOutOfBoundsException { // istisnasi durum yaşanabilir, elemenlardan biri eksik olabilir
        // String Dizisi
        // Array da başlangıç değeri veriliyor. (Collection lar da başlangıç değeri verilmez.)
        String[] city = new String[6]; // Eleman sayısı: 5 // diziler 0 dan başlayarak saymaya başlar // Boş data olunca null ekliyor
        city[0] = "İstanbul";
        city[1] = "Malatya";
        city[2] = "Elazığ";
        city[3] = "İzmir";
        city[5] = "Ankara";

        System.out.println(city);
        System.out.println("Eleman Sayısı: " + city.length); // Dizinin eleman sayısı
        System.out.println(city[0]);
        System.out.println("Son Eleman: " + city[6 - 1]);
        System.out.println("Son Eleman: " + city[(city.length) - 1]);

        return city; // String diziyi döndürüyoruz
    }


    // Array
    // 2. YÖNTEM
    public static String[] arrayMethod2() throws NullPointerException {
        // String[] city = {"İstanbul", "Malatya", "Elazığ", "İzmir", null ,"Ankara"}; // içinde olmayan data yoksa, null yazmak zorunda değiliz, yazmasakta çalışır
        String[] city = {"İstanbul", "Malatya", "Elazığ", "İzmir", "", "Ankara"};

        System.out.println(city);
        System.out.println("Eleman Sayısı: " + city.length); // Dizinin eleman sayısı
        System.out.println(city[0]);
        System.out.println("Son Eleman: " + city[6 - 1]);
        System.out.println("Son Eleman: " + city[(city.length) - 1]);

        return city; // String diziyi döndürüyoruz
    }

    public static void arrayMethod3() {
        String[] city = arrayMethod1(); // yukarıdaki String dizisini çağırıyoruz
    }


    // iterative for yöntemi ile dizileri gösterme (iterative = iteklemek)
    public static void arrayMethod4() {
        String[] city = arrayMethod2(); // yukarıdaki String dizisini çağırıyoruz

        System.out.println();
        System.out.println(SpecialColor.RED + "iterative for" + SpecialColor.RESET);

        // iterative for döngüsü
        for (int i = 0; i < city.length; i++) {
            System.out.println(SpecialColor.YELLOW + city[i] + SpecialColor.RESET);
        }
    }


    // for each yöntemi ile dizileri gösterme
    public static void arrayMethod5() {
        String[] city = arrayMethod2(); // yukarıdaki String dizisini çağırıyoruz

        // for each döngüsü
        for (String temp : city) { // temp = Geçici data
            System.out.println(temp);
        }

        System.out.println();
        System.out.println(SpecialColor.RED + "for each" + SpecialColor.RESET);

        // Döngünün renklendirilmiş versiyonu
        for (String temp : city) { // temp = Geçici data
            System.out.println(SpecialColor.BLUE + temp + SpecialColor.RESET);
        }
    }

    // Arrays.sort - Sıralama (küçükten büyüğe doğru sıralama)
    public static void arrayMethod6() {
        String[] city = arrayMethod2(); // yukarıdaki String dizisini çağırıyoruz

        // Dizilerde Sıralama (küçükten büyüğe doğru sıralama)
        //if (city != null)
        Arrays.sort(city);

        for (String temp : city) { // temp = Geçici data
            System.out.println(SpecialColor.GREEN + temp + SpecialColor.RESET);
        }
    }

    /// /////////////////////////////////


    // Arrays.sort - Sıralama (büyükten küçüğe doğru sıralama)
    public static void arrayMethod7() {
        String[] city = arrayMethod2(); // yukarıdaki String dizisini çağırıyoruz

        // Dizilerde Sıralama (büyükten küçüğe doğru sıralama)
        Arrays.sort(city, Collections.reverseOrder());

        for (String temp : city) { // temp = Geçici data
            System.out.println(SpecialColor.BLUE + temp + SpecialColor.RESET);
        }
    }


    // fill (Oto kontrol yapabiliriz. Örn: Boş gelen değer yerine bizim verdiğimiz değeri yazdırabiliriz.)
    // 1. YÖNTEM
    public static void arrayMethod8() {
        int[] number = new int[7];
        Arrays.fill(number, 5); // 5 sayısı ile doldur

        for (int temp : number) { // temp = Geçici data
            System.out.println(SpecialColor.YELLOW + temp + SpecialColor.RESET);
        }
    }

    /// ////////////////////////////////////


    // Random yapısı
    public static int randomNumber() {
        Random random = new Random();
        int rndInt = random.nextInt(9) + 1;
        return rndInt;
    }

    // fill : metodu tek bir değeri dizinin tüm elemanlarına atamak için tasarlanmıştır
    // 2. YÖNTEM
    public static void arrayMethod9() {
        int[] number = new int[7]; // her defasında sayılar değişsin

        Arrays.fill(number, randomNumber()); // 5 sayısı ile doldur

        for (int temp : number) { // temp = Geçici data
            System.out.println(SpecialColor.YELLOW + temp + SpecialColor.RESET);
        }
    }

    // fill
    // 3 - 1. YÖNTEM (iterative for)
    public static void arrayMethod10() {
        int[] number = new int[7]; // her defasında FARKLI sayılar değişsin

        // fill metodu tek bir değeri dizinin tüm elemanlarına atamak için tasarlanmıştır
        Arrays.fill(number, randomNumber());

        // iterative for ile her defasında farklı bir sayı gelsin
        for (int i = 0; i < number.length; i++) {
            // 1. Yöntem
            number[i] = randomNumber();

            // 2. Yöntem (Arrow function yapısı, arka planda çalışan ve kısaltmak için kullanılan yapılardır)
            Arrays.setAll(number, data -> randomNumber());
        }

        for (int temp : number) { // temp = Geçici data
            System.out.println(SpecialColor.RED + temp + SpecialColor.RESET);
        }
    }


    /// //////////////////////////////////////////

    public static String[] arrayMethod11() {
        String[] city = {"İstanbul", "Malatya", "Elazığ", "İzmir", "Ankara", "Aydın", "Mersin", "Adana", "Antalya", "Bursa", "Balıkesir", "Çanakkale"};
        System.out.println(city);
        return city; // String diziyi döndürüyoruz
    }

    public static void arrayMethod12() {
        // Original
        String[] originalCity = arrayMethod11(); // yukarıdaki String dizisini çağırıyoruz

        // Clone
        String[] cloneCity = Arrays.copyOf(originalCity, originalCity.length); // originalCity nin length ine kadar diziyi kopyala

        // Dizilerde Sıralama (küçükten büyüğe doğru sıralama)
        Arrays.sort(cloneCity);
        // Arrays.sort(cloneCity, Collections.reverseOrder()); // (büyükten küçüğe doğru sıralama)

        for (String temp : cloneCity) { // temp = Geçici data
            System.out.println(SpecialColor.BLUE + temp + SpecialColor.RESET);
        }

        // Binary Search
        String searchCity = "Bursa"; // aradığımız data içinde var mı yok mu?
        int index = Arrays.binarySearch(cloneCity, searchCity);
        if (index >= 0) {
            System.out.println(SpecialColor.YELLOW + searchCity + " bu ili bulunmaktadır." + SpecialColor.RESET);
        } else {
            System.out.println(SpecialColor.RED + searchCity + " bu il bulunmamaktadır!" + SpecialColor.RESET);
        }

    }


    // PSVM
    public static void main(String[] args) {
        // arrayMethod1();
        // arrayMethod2();
        // arrayMethod3();
        // arrayMethod4();
        // arrayMethod5();
        // arrayMethod6();
        // arrayMethod7();
        // arrayMethod8();
        // arrayMethod9();
        // arrayMethod10();
        // arrayMethod11();
        arrayMethod12();
    }
} // end class
