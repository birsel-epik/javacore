package com.birselepik.project_step2_file;

import com.birselepik.utils.SpecialColor;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// Öğrenci Yönetim Sistemi
public class StudentManagementSystem {

    // Field
    // Generic yapılar: Tür güvenliğini sağlayacak, hata yapmayı aza indirgeyecek yapılardır.
    // Wrapper Türler yazılır (Primitive yazılmaz.)
    private ArrayList<StudentDto> studentDtoList = new ArrayList<>();
    private int studentCounter = 0;
    private static final String FILE_NAME = "students.txt";

    // Scanner
    private static final Scanner scanner = new Scanner(System.in);


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

    // C-R-U-D Operations

    // Öğrenci Ekle
    /// Integer id, String name, String surname, Double midTerm, Double finalTerm, LocalDate birthDate
    public void add(StudentDto dto) {
        studentDtoList.add(
                new StudentDto(++studentCounter, dto.getName(), dto.getSurname(), dto.getMidTerm(), dto.getFinalTerm(), dto.getBirthDate())
        );
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
            System.out.println(SpecialColor.BLUE + " Öğrenci Listesi " + SpecialColor.RESET);
            studentDtoList.forEach(System.out::println);
        }
    }


    // Öğrenci Ara
    public void search(String name) {
       /*
           studentDtoList.stream()
           .filter(temp -> temp.getName().equalsIgnoreCase(name)) // -> thin function - Arrow function gibi çalışır
           .forEach(System.out::println);  // Bir Nesne yazdırır ve sonra satırı sonlandırır.
      */

        // Eğer öğrenci varsa true döner
        boolean found = studentDtoList
                .stream()
                .filter(temp -> temp.getName().equalsIgnoreCase(name))
                .peek(System.out::println) // Eper ilgili data varsa yazdırır
                .findAny() // Herhangi bir eşleşen öğrenci var mı yok mu? kontrol et
                .isPresent();

        // Öğrenci yoksa
        if (!found) {
            throw new StudentNotFoundException(name + "isimli öğrenci bulunamadı");
        }
    }


    // Öğrenci Güncelle
    public void update(int id, StudentDto dto) {
        for (StudentDto temp : studentDtoList) {
            if (temp.getId() == id) {
                temp.setName(dto.getName());
                temp.setSurname(dto.getSurname());
                temp.setBirthDate(dto.getBirthDate());
                System.out.println(SpecialColor.GREEN + "Öğrenci bilgileri güncellendi!" + SpecialColor.RESET);
                saveToFile();
                return;
            }
        }
        System.out.println(SpecialColor.RED + " Öğrenci bulunamadı! " + SpecialColor.RESET);
    }


    // Öğrenci Sil
    public void delete(int id) {
        studentDtoList.removeIf(temp -> temp.getId() == id);
        System.out.println(SpecialColor.BLUE + " Öğrenci bilgileri silindi!" + SpecialColor.RESET);
        saveToFile();
    }


    /// /////////////////////////////////////////


    // Toplam Öğrenci Sayısı
    // Rastgele Öğrenci
    // Öğrenci Not Ortalaması Hesapla
    // En Yüksek veya En Düşük Not Alan Öğrenci
    // Öğrenci Sıralaması (Doğum günü)


    /// /////////////////////////////////////////

    // Console Seçim (Öğrenci)
    public void chooise() {
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        // Sonsuz while
        while (true) {
            System.out.println("\n1. Öğrenci Ekle");
            System.out.println("\n2. Öğrenci Listele");
            System.out.println("\n3. Öğrenci Ara");
            System.out.println("\n4. Öğrenci Güncelle");
            System.out.println("\n5. Öğrenci Sil");
            System.out.println("\n6. Öğrenci Toplam Sayısı");
            System.out.println("\n7. Öğrenci Rastgele Gelsin");
            System.out.println("\n8. Öğrenci Not Hesapla");
            System.out.println("\n9. Öğrenci En Yüksek, En Düşük Notları Göster");
            System.out.println("\n10. Öğrenci Sıralaması Doğum Gününe Göre Göster");
            System.out.println("\n11. Çıkış");
            System.out.println("\nLütfen Seçim Yapınız");

            int chooise = scanner.nextInt();
            scanner.nextLine(); // durma yerimiz
            StudentDto studentDto = new StudentDto();
            String name, surname;
            String birthDate;
            Double grade;

            switch (chooise) {
                // add
                case 1:
                    System.out.println("Öğrenci Adı");
                    name = scanner.nextLine();
                    System.out.println("Öğrenci Soyadı");
                    surname = scanner.nextLine();
                    System.out.println("Öğrenci Doğum Tarihi");
                    birthDate = scanner.next();
                    System.out.println("Öğrenci Puanı");
                    grade = scanner.nextDouble();

                    studentDto.setId(studentCounter);
                    studentDto.setName(name);
                    studentDto.setSurname(surname);
                    studentDto.setCreatedDate(new Date(System.currentTimeMillis()));
                    // studentDto.setBirthDate(birthDate);
                    // studentDto.setGrade(grade);

                    studentManagementSystem.add(studentDto);
                    break;

                // list
                case 2:
                    studentManagementSystem.list();
                    break;

                // search
                case 3:
                    studentManagementSystem.search(studentDto.getName());
                    break;

                // update
                case 4:
                    studentManagementSystem.update(studentDto.getId(), StudentDto.builder().build());
                    break;

                // delete
                case 5:
                    studentManagementSystem.delete(studentDto.getId());
                    break;

                // toplam öğrenci sayısı
                case 6:
                    break;


                // Öğrenci Rastgele Gelsin
                case 7:
                    break;


                // Öğrenci Not Hesapla
                case 8:
                    break;


                // Öğrenci En Yüksek, En düşük Notları Göster
                case 9:
                    break;


                // Öğrenci Öğrenci Sıralaması Doğum Gününe Göre Göster
                case 10:
                    break;


                // Çıkış
                case 11:
                    System.out.println("Program sonlandırışıyor...");
                    System.exit(0);
                    // return;
                    // break;

                default:
                    System.out.println("Lütfen Seçiminizi yapınız!");

            }


        }
    }

    // PSVM
    public static void main(String[] args) {

        scanner.close();
    }


} // end class
