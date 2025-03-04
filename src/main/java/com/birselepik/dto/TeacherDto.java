package com.birselepik.dto;

import java.io.Serializable;

/**
 *
 *
 * @param persondto
 * @param subject
 * @param yearsOfExperience
 * @param salary
 * TeacherDto bir Record olarak tanımlanmıştır.
 * Record'lar Javada Immutable (değiştirilemez) veri taşıma nesneleridir.
 * Inheritace (Desteklemez) ancak Composition yöntemi ile PersonDto kullanabiliriz.
 */

/*
Dikkat:
1-) Record => public record Deneme(PARAMETRELER) {}
2-) Constructor public Deneme {}
*/


// RECORD
public record TeacherDto(
        PersonDto personDto,      // (Composition) PersonDto içindeki ortak alanları kullanır
        String subject,           // Öğretmenin Uzmanlık Alanı/Branşı
        int yearsOfExperience,    // Öğretmenin toplam deneyim yılı
        boolean isTenured,        // Kadrolu mu? (true, false)
        double salary             // Öğretmenin maaşı
) implements Serializable {

    // Varsayışan Constructorlar ile Veri doğrulaması
    public TeacherDto {
        if(personDto == null) throw new IllegalArgumentException("Tacher içinde Person bilgisi boş geçilemez");
        if(subject == null || subject.isBlank() || subject.isEmpty()) throw new IllegalArgumentException("Öğretmenin uzmanlık alanını boş geçtiniz!");
        if(yearsOfExperience < 0) throw new IllegalArgumentException("Deneyim yılınız sıfırdan küçük yazılmaz.");
        if(salary < 0) throw new IllegalArgumentException("Maaş negatif olamaz!");
    }

    // Method
    public String fullName() {
       return personDto.id+ " " +personDto.name+" "+personDto.surname;
    }

    public String experienceLevel(){
        return yearsOfExperience > 10 ? "Kıdemli Öğretmen" : "Yeni Öğretmen";
    }

} // end Record
