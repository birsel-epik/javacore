## 3. Ders Ödevi (8 Şubat)

**SORU-1**

- String'ten int geçerken Scanner nasıl çözebiliriz?

 ```sh 
System.out.println("Bildiğiniz Diller & Teknolojiler");
language=klavye.nextInt();
```

**CEVAP-1:**

- Java'da Scanner sınıfını kullanarak klavyeden veri girişi yaparken,
  nextInt() veya benzeri sayısal veri alma metotları kullanıldıktan sonra, kullanıcıdan alınan satır sonunu temizlemek
  için bir **nextLine()** çağrısı yapılması gereklidir. Bu, özellikle nextInt() gibi metotlar kullanıldığında,
  kullanıcıdan alınan sayısal girdiden sonra klavyeden boş bir satır kalması durumunu düzeltir.

**SORU-2**
null değeri ne zaman kullanabilirim ?

**CEVAP-2:**
**_Week1_Example_6**
