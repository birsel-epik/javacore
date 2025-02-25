## 4.Ders Ödevi (11 Şubat)

**SORU-1**
- switch-case ile if-elseif-else arasındaki farklar nelerdir ?

**CEVAP-1:**
 ```sh 
switch-case:
- Her bir case bloğu sonunda break ifadesi kullanılmadığı sürece, bir case den sonraki tüm case ler çalıştırılabilir (fall-through).

if-elseif-else:
- Herhangi bir koşul sağlandığında, sadece o blok çalıştırılır ve diğerleri atlanır.
```
---


**SORU-2**

- for ile while arasındaki fark ?

**CEVAP-2:**
 ```sh 
for ve while döngüleri, farklı kullanım senaryolarına ve ihtiyaçlara göre seçilir. 
Genellikle, döngünün kaç kez çalışacağı belirli ise for, 
koşulun dinamik olduğu durumlarda ise while kullanılır.
```
---

**SORU-3**

- String Birleştirme (Concatenation) türleri, Concat, StrinBuilder, StringBuffer

**CEVAP-3:**
 ```sh 
concat(): Basit ve doğrudan birleştirme işlemleri için uygun, ancak çok fazla birleştirme yapıldığında performans sorunları olabilir.

StringBuilder: Mutable yapısı ile çok sayıda birleştirme işlemi için daha verimlidir. Tek iş parçacığı için idealdir.

StringBuffer: Thread-safe yapısı ile çoklu iş parçacıkları için uygundur, ancak performansı StringBuilder kadar iyi değildir.
```
---

**SORU-4**

- return, continue, break nedir ? aralarındaki farklar nelerdir ?

**CEVAP-4:**
- return, continue ve break ifadeleri, programlama dillerinde döngüler ve fonksiyonlar üzerinde kontrol akışını yönetmek için kullanılır.

**Amaç:**
 ```sh 
- return: Fonksiyondan çıkış yapar ve bir değer döndürür.
- continue: Döngüdeki geçerli iterasyonu atlar ve bir sonraki iterasyona geçer.
- break: Döngüyü veya switch bloğunu tamamen sonlandırır.
```

**Kapsam:**
 ```sh 
- return: Sadece fonksiyon içinde kullanılır.
- continue ve break: Döngüler ve switch ifadeleri içinde kullanılır.
```

**Sonuç:**
 ```sh 
- return kullanıldığında fonksiyon sona erer.
- continue kullanıldığında döngü devam eder, ancak geçerli iterasyon atlanır.
- break kullanıldığında döngü veya switch ifadesi sona erer.
```
---

**SORU-5**

- static yapı nedir ?

**CEVAP-5:**
```sh 
static yapısı, programlama dillerinde (özellikle Java, C, C++ gibi dillerde) belirli bir değişkenin veya metodun sınıf 
düzeyinde tanımlanmasını ve tüm örnekler (instance) arasında paylaşılarak kullanılmasını sağlayan bir özellik veya anahtar kelimedir.
Ancak, static yapıları dikkatli kullanmak önemlidir, çünkü tüm nesneler arasında paylaşılan veriler üzerinde yapılan değişiklikler, diğer nesneleri de etkileyebilir.

- static Metodlar: Bir sınıf içinde tanımlanan ve nesne oluşturmadan doğrudan sınıf adı ile çağrılabilen metodlardır.
Sadece static değişkenlere erişebilir. 
Genellikle yardımcı metodlar (utility methods) için kullanılır.


- static Bloklar:  Sınıf yüklendiğinde bir kez çalıştırılan kod bloklarıdır.
Sınıf ilk kez kullanıldığında çalıştırılır ve genellikle sınıf düzeyindeki değişkenlerin başlatılması için kullanılır.


Kullanım Alanları:
Paylaşılan Bilgi: Tüm nesnelerin erişebileceği ortak bir bilgi saklamak için.
Yardımcı Metodlar: Nesne oluşturmadan çağrılabilecek metodları tanımlamak için.
Performans: Sıkça kullanılan verilere erişimde performans avantajı sağlamak için.
```
---

**SORU-6**

- Overloading nedir ?

**CEVAP-6:**

 ```sh 
Overloading (aşırı yükleme), bir programlama dilinde aynı isimde birden fazla yöntem (metod) veya operatör tanımlama tekniğidir. 
Overloading, genellikle iki ana şekilde gerçekleşir: metot aşırı yükleme ve operatör aşırı yükleme. İşte detayları:
```
---

**SORU-7**

- Override nedir ?

**CEVAP-7:**

 ```sh 
Override (üstüne yazma), nesne yönelimli programlamada (OOP) bir alt sınıfın (subclass) üst sınıfından 
(superclass) miras aldığı bir metodu yeniden tanımlaması anlamına gelir. Bu, alt sınıfın üst sınıfta tanımlanan metodun 
davranışını değiştirmesine veya genişletmesine olanak tanır. 
Override, genellikle polymorphism (çok biçimlilik) özelliklerini destekler.

Örnek: 

class Hayvan {
    void sesCikar() {
        System.out.println("Hayvan sesi");
    }
}

class Kedi extends Hayvan {
    @Override
    void sesCikar() {
        System.out.println("Miyav");
    }
}

class Kopek extends Hayvan {
    @Override
    void sesCikar() {
        System.out.println("Hav");
    }
}

public class Main {
    public static void main(String[] args) {
        Hayvan h1 = new Kedi();
        Hayvan h2 = new Kopek();

        h1.sesCikar(); // "Miyav" yazdırır
        h2.sesCikar(); // "Hav" yazdırır
    }
}
```
---

**SORU-8**

- String kelime= new String(); , String kelime= ""; iki yapı arasındaki fark ?

**CEVAP-8:**
 ```sh 
- String kelime = new String();
Bu ifade, String sınıfının bir nesnesini oluşturur. Bellekte yeni bir String nesnesi yaratır.
Her zaman yeni bir nesne oluşturur, bu da bellek üzerinde ek yük oluşturabilir.


- String kelime = "";
Bu ifade, boş bir string oluşturur ve Java nın string havuzunu kullanır. Yani, zaten var olan bir boş string nesnesine referans verir.
Bellek yönetimi açısından daha verimlidir çünkü aynı içerik için yalnızca bir nesne oluşturulur.


String kelime1 = new String(); // Yeni bir String nesnesi oluşturur
String kelime2 = ""; // String havuzundan boş bir String referansı alır

// Eşitlik kontrolü
System.out.println(kelime1.equals(kelime2)); // true, çünkü her ikisi de boş string
System.out.println(kelime1 == kelime2); // false, çünkü kelime1 yeni bir nesne, kelime2 ise havuzdan bir referans
```
---

**SORU-9**

- vocabulary1== vocabulary2 ile vocabulary1.equals(vocabulary2));

**CEVAP-9:**
 ```sh 
vocabulary1 == vocabulary2 ile vocabulary1.equals(vocabulary2) ifadeleri, 
Java da string karşılaştırması yaparken farklı işlevler görür ve dolayısıyla eşit değildir.

== operatörü, iki referansın aynı nesneye işaret edip etmediğini kontrol eder.
equals() metodu, iki nesnenin içeriklerini karşılaştırır.


String kelime1 = new String(); // Yeni bir String nesnesi oluşturur
String kelime2 = ""; // String havuzundan boş bir String referansı alır

// Eşitlik kontrolü
System.out.println(kelime1.equals(kelime2)); // true, çünkü her ikisi de boş string
System.out.println(kelime1 == kelime2); // false, çünkü kelime1 yeni bir nesne, kelime2 ise havuzdan bir referans


String vocabulary1 = new String("kelime");
String vocabulary2 = new String("kelime");

System.out.println(vocabulary1 == vocabulary2); // false, çünkü iki farklı nesne
```
---

**SORU-10**

- vocabulary1== vocabulary2 (String kelime= new String();)

**CEVAP-10:**
 ```sh 
Bu durumda false döner. Çünkü new String("kelime") ifadesi, her seferinde yeni bir String nesnesi oluşturur. 
Yani vocabulary1 ve vocabulary2, içerikleri aynı olsa bile bellekte farklı nesnelere işaret eder.
 
String vocabulary1 = new String("kelime");
String vocabulary2 = new String("kelime");

System.out.println(vocabulary1 == vocabulary2); // false, çünkü iki farklı nesne
```
---

**SORU-11**

- ile vocabulary1.equals(vocabulary2)) (String kelime= "";)

**CEVAP-11:**
 ```sh 
String vocabulary1 = "";
String vocabulary2 = "";

System.out.println(vocabulary1 == vocabulary2); // true

vocabulary1 == vocabulary2: true (referanslar aynı)
vocabulary1.equals(vocabulary2): true (içerikler aynı)
```
---

