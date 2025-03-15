package com.birselepik.controller;

import com.birselepik.dao.IDaoGenerics;
import com.birselepik.dao.StudentDao;
import com.birselepik.dto.StudentDto;
import com.birselepik.utils.SpecialAnnotation;
import com.birselepik.utils.SpecialColor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StudentController implements IDaoGenerics<StudentDto> {

    // INJECTION (DI)
    private final StudentDao studentDao;

    // Parametresiz Constructor
    public StudentController() {
        this.studentDao = new StudentDao();
    }

    // CREATE
    @Override
    @SpecialAnnotation
    public Optional<StudentDto> create(StudentDto studentDto) {
        if (studentDto == null || studentDao.findById(studentDto.getId()).isPresent()) {
            System.out.println(SpecialColor.RED + "❌ Geçersiz veya mevcut olan öğrenciden dolayı eklenemez " + SpecialColor.RESET);
            return Optional.empty();
        }
        Optional<StudentDto> createdStudent = studentDao.create(studentDto);
        createdStudent.ifPresentOrElse(
                temp -> System.out.println(SpecialColor.GREEN + "✅Başarılı Öğrenci Başarıyla Eklendi" + SpecialColor.RESET),
                () -> System.out.println(SpecialColor.RED + "❌Başarısız Öğrenci Eklenmedi" + SpecialColor.RESET)
        );
        return createdStudent;
    }

    // FIND BY NAME
    @Override
    @SpecialAnnotation
    public Optional<StudentDto> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Geçersiz isim girdiniz");
        }
        return studentDao.findByName(name.trim());
    }

    // FIND BY ID
    @Override
    @SpecialAnnotation
    public Optional<StudentDto> findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("❌ Geçersiz ID girdiniz");
        }
        return studentDao.findById(id);
    }

    // LIST
    @Override
    @SpecialAnnotation
    public List<StudentDto> list() {
        List<StudentDto> studentDtoList = Optional.of(studentDao.list()).orElse(Collections.emptyList());
        if (studentDtoList.isEmpty()) {
            System.out.println(SpecialColor.YELLOW + " Henüz Kayıtlı bir öğrenci bulunmamaktadır" + SpecialColor.RESET);
        }
        return studentDtoList;
    }

    // UPDATE
    @Override
    @SpecialAnnotation
    public Optional<StudentDto> update(int id, StudentDto studentDto) {
        if (id <= 0 || studentDto == null) {
            throw new IllegalArgumentException("❌ Güncelleme için geçerli bir öğrenci bilgisi giriniz");
        }
        return studentDao.update(id, studentDto);
    }

    // DELETE
    @Override
    @SpecialAnnotation
    public Optional<StudentDto> delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("❌ Silmek için geçerli bir öğrencisi ID giriniz");
        }
        return studentDao.delete(id);
    }

    // CHOOISE(Switch-case)
    @Override
    @SpecialAnnotation
    public void chooise() {
        studentDao.chooise();
    }
}
