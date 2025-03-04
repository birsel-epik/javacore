package com.birselepik.controller;

import com.birselepik.dao.IDaoGenerics;
import com.birselepik.dao.StudentDao;
import com.birselepik.dto.StudentDto;
import com.birselepik.utils.SpecialColor;

import java.util.List;

public class StudentController implements IDaoGenerics<StudentDto> {

    // INJECTION
    private final StudentDao studentDao;

    // Parametresiz Constructor
    public StudentController() {
        this.studentDao = new StudentDao();
    }

    // CREATE
    @Override
    public StudentDto create(StudentDto studentDto) {
        StudentDto createdStudent = studentDao.create(studentDto);
        if (createdStudent == null) {
            System.out.println(SpecialColor.RED + "❌ Öğrenci oluşturulamadı. Geçerli bilgiler giriniz." + SpecialColor.RESET);
        }
        return createdStudent;
    }


    // FIND BY NAME
    @Override
    public StudentDto findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public StudentDto findById(int id) {
        return null;
    }

    // LIST
    @Override
    public List<StudentDto> list() {
        return studentDao.list();
    }

    // UPDATE
    @Override
    public StudentDto update(int id, StudentDto studentDto) {
        return studentDao.update(id, studentDto);
    }

    // DELETE
    @Override
    public StudentDto delete(int id) {
        return studentDao.delete(id);
    }

    // CHOOISE(Switch-case)
    @Override
    public void chooise() {
        studentDao.chooise();
    }
}
