package com.birselepik.tutorials._3_week;

// POJO: "Plain Old Java Object" teriminin kısaltmasıdır ve
// özellikle Java dünyasında, basit, standart Java sınıflarını tanımlamak için kullanılır.
// Sadece fields + getter and setter


import com.birselepik.utils.SpecialColor;

// this: global nesneyi işaret eder.
public class Week3_03_Class_POJO {

    // Field
    private String name;
    private String surname;


    // Getter And Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        // name = _name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname.toUpperCase();
    }

    public static void main(String[] args) {
        Week3_03_Class_POJO pojo = new Week3_03_Class_POJO();
        pojo.setName("Birsel");
        pojo.setSurname("Epik");
        String fullName = pojo.getName().toString() + " " + pojo.getSurname().toString();
        System.out.println(SpecialColor.BLUE + fullName + SpecialColor.RESET);
    }

}
