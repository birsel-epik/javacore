package com.birselepik._3_week;

import com.birselepik.utils.SpecialColor;

import java.util.Date;
import java.util.Objects;

// Java Core Bean’ler, uygulamanın farklı bileşenleri arasında bağımlılıkları yönetmek için kullanılır.

/*
1. Kullanıcının Soyisminin ilk üç harfini büyük yazınız ve soyisimi eğer 3 harften fazlaysa geri kalan harflerinin yerine yıldız (*)
 Birsel EPİK , Birsel EPİ*(Maskeleme)
 Tip(loop, conditional)*/

// 2. İsim ayarlanırken, isim baş harfi büyük geri kalan küçük olacak şekilde ayarlanabilir mi?
// 3. İsim dönen bir metod oluşturulabilir mi? Birsel Epik
// 4. İsimde noktalama işaretleri olup olmadığını kontrol eden bir doğrulama ekleyebilir miyiz? varsa noktalamadan itibaren silsin
// 5. İsim veya soyisim boş girildiğinde varsayılan bir değer atanabilir mi?
// 6. İsim ve soyisimde sadece harfler olup olmadığını kontrol edebilir miyiz?
// 7. Kullanıcıdan isim ve soyismini girerken karakter sınırı koyabilir miyiz?

public class Week3_04_Class_BEAN {

    // Field
    private Long id;
    private String name;
    private String surname;
    private Date createdDate;

    // Constructor Metot (parametresiz)
    public Week3_04_Class_BEAN() {
        id = 0L;
        name = "isim alanını yazmadınız";
        this.surname = "soyad alanını yazmadınız";
        this.createdDate = new Date(System.currentTimeMillis());
    }

    // Constructor Metot (parametreli)
    public Week3_04_Class_BEAN(Long id, String name, String surname, Date createdDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.createdDate = createdDate;
    }


    // Method
    public String fullName() {
        return id + " " + name.toString() + " " + this.surname + " " + createdDate;
    }


    // toString
    // Bir yöntem bildiriminin bir üst tipteki bir yöntem bildirimini geçersiz kılmak için tasarlandığını belirtir.
    @Override
    public String toString() {
        return "Week3_04_Class_BEAN {" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", createdDate= " + createdDate + '}';
    }

    // Equals And HashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Week3_04_Class_BEAN bean = (Week3_04_Class_BEAN) o;
        return Objects.equals(id, bean.id) && Objects.equals(name, bean.name) && Objects.equals(surname, bean.surname) && Objects.equals(createdDate, bean.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, createdDate);
    }

    // Getter and Setter
    // ID


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // NAME
    // 2. İsim birlikte ayarlanırken, isim baş harfi büyük geri kalan küçük olacak şekilde ayarlanabilir mi?
    // 4. İsimde noktalama işaretleri olup olmadığını kontrol eden bir doğrulama ekleyebilir miyiz? varsa eğer noktalı işaretten sonra gelen harfleri sil

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessError {
        if (name != null && !name.isEmpty() && name.matches(".*[.,!?;:]+.*")) {
            // throw new IllegalAccessError("isimde geçersiz karakerler var");
            // System.err.println("isimde geçersiz karakterler var.");
            System.out.println(SpecialColor.RED + "İsimde geçersiz karakterler var, bu karakterden sonraki harfleri silindi" + SpecialColor.RESET);
            name = name.replaceAll("[.,!?;:].*", "");
            System.out.println(name);
        }

        /*
            name != null: Değişkenin null olup olmadığını kontrol eder. (Eğer name değişkeni null ise, bu değişkenin hiçbir nesneye referans vermediği anlamına gelir.)
            !name.isEmpty(): Değişkenin boş olup olmadığını kontrol eder.
            Bu kontrollerin birlikte kullanılması, bir String değişkeninin hem null olmadığını hem de boş olmadığını güvenli bir şekilde kontrol etmek için yaygın bir yöntemdir.
        */

        if (name != null && !name.isEmpty()) {
            this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        } else {
            this.name = name;
        }
    }

    // SURNAME
    /*
        1. Kullanıcının Soyisminin ilk üç harfini büyük yazınız ve soyisimi eğer 3 harften fazlaysa geri kalan harflerinin yerine yıldız (*)
        Birsel EPİK , Birsel EPİ* (Maskeleme)
        Tip (loop, conditional)
    */

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (!name.matches("[a-zA-ZğüşıöçĞÜŞİÖÇ]+")) {
            throw new IllegalArgumentException("İsim sadece harf içermelidir!");
        } else if (surname != null && surname.length() >= 3) {
            // this.surname = "EPİ*";
            this.surname = surname.substring(0, 3).toUpperCase() + "*".repeat(surname.length() - 3);
        } else if (surname != null) {
            this.surname = surname.toUpperCase();
        } else {
            this.surname = "";
        }
    }

    // DATE

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    // PSVM
    public static void main(String[] args) throws IllegalAccessException {
        Week3_04_Class_BEAN bean1 = new Week3_04_Class_BEAN();
        bean1.setId(1L);
        bean1.setName("birsel, alya ada");
        bean1.setSurname("Epik");
        //bean1.setSurname("Ada");
        System.out.println(SpecialColor.PURPLE + bean1.getId() + " " + bean1.getName() + " " + bean1.getSurname() + " " + bean1.getCreatedDate() + SpecialColor.RESET);
        System.out.println(SpecialColor.YELLOW + " " + bean1 + " " + SpecialColor.RESET);

        // System.out.println("#################################################################");

        // Week3_04_Class_BEAN bean2 = new Week3_04_Class_BEAN("Birsel2", "Epik222");
        // System.out.println(SpecialColor.YELLOW + " " + bean2 + " " + SpecialColor.RESET);


    }
}
