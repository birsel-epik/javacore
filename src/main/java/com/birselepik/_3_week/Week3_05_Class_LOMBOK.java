package com.birselepik._3_week;

// Java'da POJO sınıfları genellikle getter, setter ve constructor gibi birçok tekrar eden kod içerdiğinden,
// **Lombok** kütüphanesi POJO'ları daha az kod ile yazmayı sağlar.

import lombok.*;

import java.util.Date;

@NoArgsConstructor // parametresiz Constructor
@AllArgsConstructor // parametreli Constructor
// @Data
@Getter
@Setter
@ToString
@Builder

public class Week3_05_Class_LOMBOK {

    // Field
    private Long id;
    private String name;
    private String surname;
    private Date createdDate;

    public static void main(String[] args) {
        Week3_05_Class_LOMBOK lombok = Week3_05_Class_LOMBOK.builder()
                .id(1L)
                .name("Birsel")
                .surname("Epik")
                .createdDate(new Date(System.currentTimeMillis()))
                .build();

        System.out.println(lombok);
    }

}
