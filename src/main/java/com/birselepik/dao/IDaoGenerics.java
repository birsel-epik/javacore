package com.birselepik.dao;

import com.birselepik.dto.StudentDto;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDaoGenerics<T> {
    // CRUD OPERATIONS

    // CREATE
    T create(T t);

    // FIND BY NAME
    T findByName(String name);

    // LIST
    ArrayList<T> list();

    // UPDATE
    T update(T t);

    // DELETE
    T delete(T t);

    //CHOOSE
    public T choose(T t);

    // BODY METHOD
    default Connection getInterfaceConnection() {
        return null;
    }

    // Öğrenci Güncelle
    StudentDto update(int id, StudentDto studentDto);

    // Öğrenci Sil
    StudentDto delete(int id);

    // Console Seçim (Öğrenci)
    void chooise();
}
