package com.birselepik.controller;

import com.birselepik.dao.IDaoGenerics;
import com.birselepik.dao.TeacherDao;
import com.birselepik.dto.TeacherDto;
import com.birselepik.utils.SpecialColor;

import java.util.List;
import java.util.Optional;

public class TeacherController implements IDaoGenerics<TeacherDto> {

    // INJECTION
    private final TeacherDao teacherDao;

    // Parametresiz Constructor
    public TeacherController() {
        this.teacherDao = new TeacherDao();
    }

    // CREATE
    @Override
    public TeacherDto create(TeacherDto teacherDto) {
        TeacherDto createdTeacher = teacherDao.create(teacherDto);
        if (createdTeacher == null) {
            System.out.println(SpecialColor.RED + "❌ Öğretmen oluşturulamadı. Geçerli bilgiler giriniz." + SpecialColor.RESET);
        }
        return createdTeacher;
    }


    // FIND BY NAME
    @Override
    public Optional<TeacherDto> findByName(String name) {
        return teacherDao.findByName(name) ;
    }

    @Override
    public Optional<TeacherDto> findById(int id) {
        return null;
    }

    // LIST
    @Override
    public List<TeacherDto> list() {
        return teacherDao.list();
    }

    // UPDATE
    @Override
    public Optional<TeacherDto> update(int id, TeacherDto teacherDto) {
        return teacherDao.update(id, teacherDto);
    }

    // DELETE
    @Override
    public Optional<TeacherDto> delete(int id) {
        return teacherDao.delete(id);
    }

    // CHOOISE(Switch-case)
    @Override
    public void chooise() {
        teacherDao.chooise();
    }
}
