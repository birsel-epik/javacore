package com.birselepik._4_week;

public class Week4_01_Enum {
    public static void main(String[] args) {
        EStudentType studentType = EStudentType.GRADUATE;
        System.out.println(studentType);
        System.out.println(studentType.name());
        System.out.println(studentType.ordinal());
    }
}