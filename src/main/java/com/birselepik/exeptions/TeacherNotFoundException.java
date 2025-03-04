package com.birselepik.exeptions;

public class TeacherNotFoundException extends RuntimeException {
  public TeacherNotFoundException(String message) {
    super(message);
  }
}
