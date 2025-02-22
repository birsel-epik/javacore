package com.birselepik.project_step1_file;

import java.util.ArrayList;

// Öğrenci Yönetim Sistemi
public class StudentManagementSystem {

    // Field
    private ArrayList<StudentDto> students = new ArrayList<>();
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

    // Öğrenci Listesinden Yükle (Dosya)
    private void loadStudentsListFromFile() {
    }

    // CRUD Operations
    // Öğrenci Ekle
    // Öğrenci Listesi
    // Öğrenci Ara
    // Öğrenci Güncelle
    // ğrenci Sil

    /// /////////////////////////////////////////

    // FileIO Create
    // Öğrenci Dosyalarını kaydeden metot
    // Öğrenci Dosyalarını okuyan metot

    /// //////////////////////////////////////////

    // Toplam Öğrenci Sayısı
    // Öğrenci Not Ortalamasını Hesapla
    // En Yüksek veya En Düşük Not Alan Öğrenci
    // Öğrenci Sıralaması (Doğum Günü)
    // Console Seçim (Öğrenci Ekle)


} // end class
