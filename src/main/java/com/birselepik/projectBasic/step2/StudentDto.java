package com.birselepik.projectBasic.step2;

import com.birselepik.utils.SpecialColor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

// LOMBOK
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode

public class StudentDto implements Serializable {

    // Serileştirme
    private static final long serialVersionUID = 5563646556456565465L;

    // Field
    private Integer id;
    private String name;
    private String surname;
    private EStudentType eStudentType;  // Enum Öğrenci Türü
    private Double midTerm;             // Vize notu
    private Double finalTerm;           // Final notu
    private Double resultTerm;          // Sonuç Notu: (Viz e%40 + Final %60)
    private LocalDate birthDate;        // Doğum günü
    private Date createdDate;           // Sistem otomatik tarihi


    // static (Nesne boyunca 1 kere oluşturuluyor)
    static {
        System.out.println(SpecialColor.BLUE + "static StudentDto Yüklendi" + SpecialColor.RESET);
    }


    // Parametresiz Constructor
    public StudentDto() {

    }

    //  Parametreli Constructor
    public StudentDto(Integer id, String name, String surname, Double midTerm, Double finalTerm, LocalDate birthDate, EStudentType eStudentType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.midTerm = midTerm;
        this.finalTerm = finalTerm;
        this.birthDate = birthDate;
        this.createdDate = new Date(System.currentTimeMillis());
        this.resultTerm = calculateResult();
        this.eStudentType = eStudentType;
    }

    // Metotlar

    // Vize ve Final Calculate
    private Double calculateResult() {
        if (midTerm == null || finalTerm == null) return 0.0;
        else return (midTerm * 0.4) + (finalTerm * 0.6);

    }

    // Not Validasyon
//    public void validateGrade(Double grade, String fieldName) {
//        if (grade < 0 || grade > 100) {
//            throw new IllegalArgumentException(SpecialColor.RED + fieldName + " 0 ile 100 arasında olmalıdır!" + SpecialColor.RESET);
//        }
//    }


    // Getter And Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       /* if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(SpecialColor.RED + " İsim boş olamaz!" + SpecialColor.RESET);
        }
        if (name != null && !name.isEmpty() && name.matches(".*[.,!?;:]+.*")) {
            System.out.println(SpecialColor.RED + "İsimde geçersiz karakterler var!" + SpecialColor.RESET);
        }
        if (name.length() > 30) {
            throw new IllegalArgumentException(SpecialColor.PURPLE + " İsim 30 karakterden fazla olamaz!" + SpecialColor.RESET);
        }*/

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
/*        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException(SpecialColor.RED + " Soyisim boş olamaz!" + SpecialColor.RESET);
        }
        if (surname != null && !surname.isEmpty() && surname.matches(".*[.,!?;:]+.*")) {
            System.out.println(SpecialColor.RED + "Soyisimde geçersiz karakterler var!" + SpecialColor.RESET);
        }
        if (surname.length() > 30) {
            throw new IllegalArgumentException(SpecialColor.PURPLE + " Soyisim 30 karakterden fazla olamaz!" + SpecialColor.RESET);
        }*/
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
       /* if (birthDate == null || birthDate.trim().isEmpty()) {
            throw new IllegalArgumentException(SpecialColor.RED + " Doğum tarihi boş olamaz!" + SpecialColor.RESET);
        }
        LocalDate now = LocalDate.now();
        if (birthDate.isAfter(now)) {
            throw new IllegalArgumentException(SpecialColor.PURPLE + " Doğum tarihi bugünden sonra olamaz!" + SpecialColor.RESET);
        }
        // Öğrenci en az 18 yaşında olsun
        if (birthDate.isAfter(now.minusYears(18))) {
            throw new IllegalArgumentException(SpecialColor.PURPLE + " Öğrenci en az 18 yaşında olmalıdır!" + SpecialColor.RESET);
        }*/
        this.birthDate = birthDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Double getMidTerm() {
        return midTerm;
    }

    public void setMidTerm(Double midTerm) {
        // Vize notu validasyonu
        // validateGrade(midTerm, "Vize notu");
        this.midTerm = midTerm;

        this.resultTerm = calculateResult();
    }

    public Double getFinalTerm() {
        return finalTerm;
    }

    public void setFinalTerm(Double finalTerm) {
        // Final notu validasyonu
        // validateGrade(finalTerm, "Final notu");
        this.finalTerm = finalTerm;

        this.resultTerm = calculateResult();
    }

    public Double getResultTerm() {
        return resultTerm;
    }

    public void setResultTerm(Double resultTerm) {
        this.resultTerm = resultTerm;
    }

    public EStudentType geteStudentType() {
        return eStudentType;
    }

    public void seteStudentType(EStudentType eStudentType) {
        this.eStudentType = eStudentType;
    }
} // end Student
