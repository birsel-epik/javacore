package com.birselepik.exeptions;

// Öğrenci bulunamazsa Fırlatılacak Özel Excepiton
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
