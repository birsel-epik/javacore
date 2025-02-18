package com.birselepik._2_Week;

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
    public static String[] arrayMethod2() throws ArrayIndexOutOfBoundsException {
        String[] city = {"Malatya", "İstanbul", "Malatya", "Elazığ", "İzmir", "Ankara"}; // içinde olmayan data yoksa, null yazmak zorunda değiliz yazmasakta çalışır

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

    // for each
    public static void arrayMethod4() {
        String[] city = arrayMethod2(); // yukarıdaki String dizisini çağırıyoruz

        // for each döngüsü
        for (String temp : city) { // temp = Geçici data
            System.out.println(temp);
        }

        System.out.println();

        // Döngünün renklendirilmiş versiyonu
        for (String temp : city) { // temp = Geçici data
            System.out.println(_15_4_Special_Color.BLUE + temp + _15_4_Special_Color.RESET);
        }
    }


    // PSVM
    public static void main(String[] args) {
        // arrayMethod1();
        // arrayMethod2();
        // arrayMethod3();
        arrayMethod4();
    }
} // end class
