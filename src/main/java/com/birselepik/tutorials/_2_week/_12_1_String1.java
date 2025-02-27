package com.birselepik.tutorials._2_week;

public class _12_1_String1 {
    public static void main(String[] args) {
        // 1. YOL
        //String vocabulary = new String(" JAva öğreNİYOrum ");

        // 2. YOl
        // String vocabulary = new String();

        // 3. YOL
        // vocabulary= " JAva öğreNİYOrum ";
        // String Pool -> Bellek Yönetimi
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

        // subString: parçalama 2 yöntem var.
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

        // Contains: içerisinde bu string içerik geçiyor mu?
        System.out.println("Geçiyor mu?: " + vocabulary1.contains("Java"));


        // Split ???


        // Replace (Değiştirme)
        vocabulary1 = vocabulary1.replace("Java", "Java 2025"); // orijinal veriyi değiştirmiş oluyoruz
        // System.out.println("Değiştir: " + vocabulary1.replace("Java", "Java 2025"));
        System.out.println(vocabulary1); // İçeriğin irijinali değişmiyor aslında, sadece o anda ekrana değişen içeriği yansıtıyoruz.


        // Birleştirme
        // 1. YÖNTEM
        // her artıda bir döngüde işlemi yapıyor, birden fazla döngü
        String concatenations = vocabulary1 + vocabulary2 + vocabulary3;
        System.out.println(concatenations);

        // Birleştirme (Concat)
        // 2. YÖNTEM
        System.out.println("Concat: " + vocabulary1.concat(" jsp").concat(" jsf"));


        // Birleştirme (StringBuilder)
        // (API ler ile çalışılırken, karşı taraftan gelen verinin türünü bilmiyorak StringBuilder yapısı kullanılır. Daha hızlıdır)
        // Tek bir döngüde birleştirme işlemi yapıyor
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(vocabulary1).append(" jsp").append(" jsf");
        String dataToString1 = stringBuilder.toString(); // toString -> Stringe çevir
        System.out.println(dataToString1);


        // Birleştirme (StringBuffer)
        // (API ler ile çalışılırken, karşı tarafdan gelen verinin türünü bilmiyorak StringBuffer yapısı kullanılır. Daha eski ve yavaş yöntem. Tür güvenliği için daha önemli)
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(vocabulary1).append(" jsp").append(" jsf");
        String dataToString2 = stringBuffer.toString();
        System.out.println(dataToString2);


        // Hash code -> Her bir nesnenin kendisine ait parmak izidir
        System.out.println(vocabulary1.hashCode());
        System.out.println(vocabulary2.hashCode());
        System.out.println(vocabulary3.hashCode());

    }
}
