package com.birselepik.controller;

import com.birselepik.dao.IDaoGenerics;
import com.birselepik.dao.StudentDao;
import com.birselepik.dto.StudentDto;

import java.util.ArrayList;

public class StudentController implements IDaoGenerics<StudentDto> {

    // Injection
    private StudentDao studentDao;

    // Parametresiz Constructor
    public StudentController() {
        studentDao = new StudentDao();
    }


    /// ///////////////////////////////////////////////////////////
    // CRUD
    @Override
    public StudentDto create(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto findByName(String name) {
        return null;
    }

    @Override
    public ArrayList<StudentDto> list() {
        return null;
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto delete(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto choose(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto update(int id, StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto delete(int id) {
        return null;
    }

    @Override
    public void chooise() {
    }
}
