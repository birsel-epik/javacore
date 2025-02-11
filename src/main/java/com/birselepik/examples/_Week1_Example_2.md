```sh
Stack Memory ve Heap Memory, bir programın çalışması sırasında kullanılan iki temel bellek alanıdır. İşte bu iki bellek türünün detaylı açıklamaları:
```

## Stack Memory
**Tanım:** Stack, programın çalışması sırasında geçici verileri saklamak için kullanılan bir bellek alanıdır. Genellikle yerel değişkenler ve fonksiyon çağrıları için kullanılır.
**Yapı:** Stack, LIFO (Last In, First Out - Son Giren İlk Çıkar) prensibi ile çalışır. Yani, en son eklenen eleman en önce çıkar.
**Özellikler:** 
- **Otomatik Yönetim:** Bellek otomatik olarak yönetilir. Bir fonksiyon sona erdiğinde, o fonksiyonda tanımlı tüm yerel değişkenler stack'ten otomatik olarak kaldırılır.
- **Hız:** Stack, hızlı erişim sağlar çünkü bellek yönetimi oldukça basittir.
- **Bellek Boyutu:** Genellikle sınırlıdır. Eğer stack boyutu aşılırsa, "stack overflow" hatası meydana gelir.
- **Veri Türleri:** Yerel değişkenler, fonksiyon parametreleri ve nesne referansları gibi basit veri yapıları için kullanılır.

## Heap Memory
**Dinamik Yönetim:** Bellek, programcı tarafından new veya malloc gibi fonksiyonlar aracılığıyla tahsis edilir ve delete veya free ile serbest bırakılır.
**Hız:** Stack'e göre daha yavaştır çünkü bellek yönetimi karmaşıktır.
**Bellek Boyutu:** Genellikle daha büyüktür ve daha fazla veri saklayabilir. Ancak, heap'te bellek sızıntıları meydana gelebilir, yani serbest bırakılmayan bellek.
**Veri Türleri:** Daha karmaşık veri yapıları, nesneler ve dinamik olarak büyüyen diziler için kullanılır.


## Özet
**Stack Memory**
- Kısa ömürlü, yerel değişkenler ve fonksiyon çağrıları için.
- Otomatik yönetim, hızlı erişim, sınırlı boyut.

**Heap Memory**
- Uzun ömürlü, dinamik veriler için.
- Programcı yönetimi, daha yavaş erişim, daha büyük boyut.

---
**Bu bellek türlerinin her biri, programlama dillerinde farklı durumlar için kullanılır ve optimal bellek yönetimi sağlamak için uygun şekilde seçilmelidir.**

---

## Escape Character
**Escape karakterler, bir dize içinde özel anlamı olan karakterlerin yazılmasını sağlar. Java'da escape karakterler, \ (ters eğik çizgi) ile başlar ve belirli bir karakterin veya işlevin temsil edilmesine olanak tanır.***
```sh
- \': Tek tırnak
- \": Çift tırnak
- \\: Ters eğik çizgi
- \n: Satır sonu ("yeni satıra geçiş")
- \t: Sekme (tab)
- \r: Satır başına dönüş (carriage return)
```

**Örneğin:**
```java
public class EscapeCharacterExample {
    public static void main(String[] args) {
        System.out.println("Boş beyin, \"Şeydanın\" oyun alanıdır!");
        System.out.println("Bu bir tab:\tve buda yeni bir satır:\nVe burası bir satır.");
    }
}
```

## Scanner Class
**Kullanıcıdan girdi almak için kullanılan bir sınıftır. java.util paketinde bulunur ve çeşitli veri türlerinden giriş almak için kullanılabilir.**
- **Kullanıcı Girdisi:** Kullanıcıdan metin, sayılar ve diğer veri türlerini almak için basit bir yol sağlar.
- **Döngü Desteği:** Kullanıcıdan birden fazla girdi almak için döngülerle birlikte kullanılabilir.
- **Veri Türleri:** nextInt(), nextDouble(), nextLine() gibi metotlar ile farklı veri türlerinde girdi alabilirsiniz.


**Örneğin:**

```java
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner nesnesi oluşturuluyor.

        System.out.println("Bir sayı girin: ");
        int number = scanner.nextInt(); // Kullanıcıdan bir tam sayı al

        System.out.println("Girdiğiniz sayı: " + number);

        // Satır bazında girdi almak için
        scanner.nextLine(); // Bu, önceki nextInt() çağrısından kalan satır sonunu temizler

        System.out.println("Bir metin girin: ");
        String content = scanner.nextLine(); // Kullanıcıdan bir metin al

        System.out.println("Girdiğin metin: " + content);

        scanner.close(); // Scanner'ı kapat
    }
}
```

## Önemli Notlar
- **Kapatma:** Scanner nesnesinin kullanımı tamamlandığında scanner.close() metodu ile kapatılması önemlidir.
- **nextLine() Kullanımı:** nextInt() veya nextDouble() gibi metotlardan sonra nextLine() kullanıyorsanız, önceki satır sonunu temizlemek için bir nextLine() çağrısı yapmanız gerekebilir.