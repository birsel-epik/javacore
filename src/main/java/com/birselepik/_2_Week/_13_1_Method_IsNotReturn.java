package com.birselepik._2_Week;

public class _13_1_Method_IsNotReturn {

    // 1- METOTLAR (Returnsuz Parametresiz)
    // İşlem sonunda geriye birşey döndürmeyecekse "Void" kullanılır.
    // Metotlar camelCase kuralına göre yazılır
    public void metotReturnsuzParametresiz() {
        System.out.println("Metot Returnsuz Parametresiz");
    }


    // 2- METOTLAR (Returnsuz Parametreli)
    // İşlem sonunda geriye bir değer dönecekse, başka yere gönderecek bir şey döndürecekse "Return" kullanılır.
    public void metotReturnsuzParametreli1(String name) {
        System.out.println("Metot Returnsuz Parametreli" + name);
    }

    public static void metotReturnsuzParametreli2(String name) {
        System.out.println("Metot Returnsuz Parametreli" + name);
    }

    // Overloading (Aşırı Yükleme)
    // (Aynı metot içinde her şey aynı olsun fakat parametrenin sayısı veya parametrenin türü değişik olacak)
    public static void metotReturnsuzParametreli3(String name, String surname) {
        System.out.println("Adınız: " + name + " Soyadınız :" + surname);
    }

    // new ???

    // static (duran) (Proje içerisinde ortak metotları, bileşenleri kullanacağımız zaman static yapıyı kullanıyoruz. Diğer yazılımcılarda kuşşanabilir.
    // Güvenliği ihlal edecek yapılarda kulanmıyoruz.)
    public static void main(String[] args) {
        _13_1_Method_IsNotReturn data1 = new _13_1_Method_IsNotReturn();
        data1.metotReturnsuzParametresiz();

        // instance (new) oladan (sadece static olanları çağırabiliriz)
        _13_1_Method_IsNotReturn.metotReturnsuzParametreli2("Static Yapı: Birsel");
        _13_1_Method_IsNotReturn.metotReturnsuzParametreli3("Birsel", "Epik");
    }
}
