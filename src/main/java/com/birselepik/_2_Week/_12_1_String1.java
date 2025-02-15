package com.birselepik._2_Week;

public class _12_1_String1 {
    public static void main(String[] args) {
        // 1. YOL
        //String vocabulary = new String(" JAva öğreNİYOrum ");

        // 2. YOl
        // String vocabulary = new String();

        // 3. YOL
        // vocabulary= " JAva öğreNİYOrum ";
        String vocabulary1 = " Java öğreNİYOrum ";
        String vocabulary2 = " Java öğreNİYOrum ";

        // Eğer boşluklar olmadan işlem yapmak isteniyorsa önce trim() çalıştırılmalıdır
        // vocabulary1 = vocabulary1.trim();


        // length()
        System.out.println("Harf Sayısı: " + vocabulary1.length());

        // toUpperCase() => Hepsi BÜYÜK karakter yap.
        System.out.println("BÜYÜK HARF: " + vocabulary1.toUpperCase());


        // toLowerCase() => Hepsi küçük karakter yap.
        System.out.println("küçük harf: " + vocabulary1.toLowerCase());


        // trim (Başında veya sonundaki boşlukları alır)
        System.out.println("Trim: " + vocabulary1.trim().length());
        System.out.println("Trim: " + vocabulary1.trim());


        System.out.println("------------------------");

        // equals: Eşit mi= ==
        System.out.println("==  " + vocabulary1 == vocabulary2);
        System.out.println("equals: " + vocabulary1.equals(vocabulary2));
        System.out.println("equalsIgnoreCase: " + vocabulary1.equalsIgnoreCase(vocabulary2)); // yazıların küçük veya büyük olduğuna değil, aynı harf olup olmadığına bakar


        System.out.println("------------------------");

        // startsWith(): ile mi başlıyor
        // endsWith(): ile mi bitiyor
        System.out.println("startsWith: " + vocabulary1.startsWith("J") + " ile mi başlıyor?");
        System.out.println("endsWith: " + vocabulary1.endsWith(" ") + " ile mi başlıyor?");


        // charAt (Sıfırdan saymaya başlar ve verdiğimiz sayı ilgili kelimenin harfini bize verir. Saymaya 1 den başlar)
        System.out.println("charAt: " + vocabulary1.charAt(1));

        System.out.println("------------------------");

        //subString: parçalama 2 yöntem var.
        // 1: Süpürme
        // 2: Aralarında
        System.out.println("subString: " + vocabulary1.substring(1));
        System.out.println("subString + trim: " + vocabulary1.trim().substring(1));
        System.out.println("subString + trim + toLowerCase: " + vocabulary1.trim().substring(1).toLowerCase());

        System.out.println("subString arasındaki değerler: " + vocabulary1.substring(1, 10)); // 1<=VOCABUL<=10-1 (arasında)
        String vocabulary3 = "Java";

        // Hatalı: Aşağıdaki yöntemde vocabulary3 değeri 4 karakter olduğu için hata verecektir. Bu nedenle if ile kontol sağlanmaktadır.
        // System.out.println("subString arasındaki değerler: " + vocabulary3.substring(1, 10)); // 1<=VOCABUL<=10-1 (arasında)

        // Hatasız:
        if (vocabulary3.length() >= 10) {
            System.out.println("subString arasındaki değerler: " + vocabulary3.substring(1, 10)); // 1<=VOCABUL<=10-1 (arasında)
        } else {
            System.out.println("Verdiğiniz kelime en fazla: " + vocabulary3.length() + " karakter vardır");
        }
    }
}
