package com.birselepik.Examples;

import java.util.Scanner;

public class _Week1_Examples_5 {

//    Soru: String'ten int geçerken Scanner nasıl çözebiliriz?
//    System.out.println("Bildiğiniz Diller & Teknolojiler");
//    language=klavye.nextInt();

//    Cevap: Java'da Scanner sınıfını kullanarak klavyeden veri girişi yaparken,
//    nextInt() veya benzeri sayısal veri alma metotları kullanıldıktan sonra, kullanıcıdan alınan satır sonunu temizlemek
//    için bir nextLine() çağrısı yapılması gereklidir. Bu, özellikle nextInt() gibi metotlar kullanıldığında,
//    kullanıcıdan alınan sayısal girdiden sonra klavyeden boş bir satır kalması durumunu düzeltir.

    public static void main(String[] args) {
        Scanner inputValue = new Scanner(System.in); // Scanner nesnesi oluştur

        // Kullanıcıdan dil sayısını al
        System.out.println("Bildiğiniz Diller sayısını girin:");
        int language = inputValue.nextInt(); // Integer değer al

        // Satır sonunu temizlemek için bir nextLine() çağrısı yapılır
        inputValue.nextLine(); // Bu, önceki nextInt() çağrısından kalan satır sonunu temizler

        // Kullanıcıdan teknolojiler hakkında bilgi al
        System.out.println("Bildiğiniz teknolojileri girin:");
        String techologies = inputValue.nextLine(); // String değeri al

        //Sonuçları göster
        System.out.println("Bildiğiniz Diller:" + language);
        System.out.println("Bildiğiniz Teknolojiler: " + techologies);

        inputValue.close();
    }

}

