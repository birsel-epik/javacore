package com.birselepik.project_step1_file;

import com.birselepik.utils.SpecialColor;

import java.io.*;
import java.util.ArrayList;

// Öğrenci Yönetim Sistemi
public class StudentManagementSystem {

    // Field
    private ArrayList<StudentDto> studentDtoList = new ArrayList<>();
    private int studentCounter = 0;
    private static final String FILE_NAME = "students.txt";


    // static
    static {
    }

    // Parametresiz Constructor
    public StudentManagementSystem() {
        // Program başlarken Öğrenci Listesini hemen yüklesin
        loadStudentsListFromFile();
    }

    /// /////////////////////////////////////////
    // Login
    // Register

    /// /////////////////////////////////////////
    // FileIO Create
    // File Create
    private void saveToFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(studentDtoList);
        } catch (IOException io) {
            System.out.println(SpecialColor.RED + "Dosya ekleme hatası!" + SpecialColor.RESET);
            io.printStackTrace();
        }
    }


    // File Read
    // Öğrenci Listesinden Yükle (Dosya)
    private void loadStudentsListFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentDtoList = (ArrayList<StudentDto>) objectInputStream.readObject();
            studentCounter = studentDtoList.size();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(SpecialColor.RED + " Öğrenci kaydı bulunamadı! " + SpecialColor.RESET);
            fileNotFoundException.printStackTrace();
        } catch (IOException io) {
            System.out.println(SpecialColor.RED + " Dosya okuma hatası! " + SpecialColor.RESET);
            io.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /// /////////////////////////////////////////

    // CRUD Operations
    // Öğrenci Ekle
    public void add(StudentDto dto) {
        studentDtoList.add(new StudentDto(++studentCounter, dto.getName(), dto.getSurname(), dto.getBirthDate(), dto.getGrade()));
        System.out.println(SpecialColor.GREEN + " Öğrenci Eklendi " + SpecialColor.RESET);

        // File Ekle
        saveToFile();
    }


    // Öğrenci Listesi
    public void list() {
        // öğrenci yoksa
        if (studentDtoList.isEmpty()) {
            System.out.println(SpecialColor.RED + " Kayıtlı öğrenci yok! " + SpecialColor.RESET);
            return;
        } else {
            studentDtoList.forEach(System.out::println);
        }
    }


    // Öğrenci Ara
    public void search(String name) {
        studentDtoList.stream()
                .filter(temp -> temp.getName().equalsIgnoreCase(name)) // -> thin function - Arrow function gibi çalışır
                .forEach(System.out::println);  // Bir Nesne yazdırır ve sonra satırı sonlandırır.
    }


    // Öğrenci Güncelle
    // ğrenci Sil

    /// /////////////////////////////////////////

    // FileIO Create
    // Öğrenci Dosyalarını kaydeden metot
    // Öğrenci Dosyalarını okuyan metot

    /// /////////////////////////////////////////

    // Toplam Öğrenci Sayısı
    // Öğrenci Not Ortalamasını Hesapla
    // En Yüksek veya En Düşük Not Alan Öğrenci
    // Öğrenci Sıralaması (Doğum Günü)
    // Console Seçim (Öğrenci Ekle)


} // end class
