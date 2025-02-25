package com.birselepik.project_step2_file;

import com.birselepik.utils.SpecialColor;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Öğrenci Yönetim Sistemi
public class StudentManagementSystem {

    // Field
    // Generic yapılar: Tür güvenliğini sağlayacak, hata yapmayı aza indirgeyecek yapılardır.
    // Wrapper Türler yazılır (Primitive yazılmaz.)
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
            System.out.println(SpecialColor.RED + " Dosya Ekleme Hatası" + SpecialColor.RESET);
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
                temp.setMidTerm(dto.getMidTerm());
                temp.setFinalTerm(dto.getFinalTerm());

                // Güncellenmiş öğrenci bilgileri
                System.out.println(SpecialColor.GREEN + temp + "Öğrenci bilgileri güncellendi!" + SpecialColor.RESET);

                // Dosya kaydet
                saveToFile();
                return;
            }
        }
        System.out.println(SpecialColor.RED + " Öğrenci bulunamadı! " + SpecialColor.RESET);
    }


    // Öğrenci Sil
    public void delete(int id) {
        /*
            studentDtoList.removeIf(temp -> temp.getId() == id);
            System.out.println(SpecialColor.BLUE + " Öğrenci bilgileri silindi!" + SpecialColor.RESET);
            saveToFile();
        */
        boolean removed = studentDtoList
                .removeIf(temp -> temp.getId() == id);
        if (removed) {
            System.out.println(SpecialColor.RED + " Öğrenci Silindi " + SpecialColor.RESET);
            // Silinen Öğrenciyi dosyaya kaydet
            saveToFile();
        } else {
            System.out.println(SpecialColor.YELLOW + " Öğrenci Silinmedi " + SpecialColor.RESET);
        }
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
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        // Sonsuz while
        while (true) {
            System.out.println(SpecialColor.YELLOW + "1. Öğrenci Ekle");
            System.out.println("2. Öğrenci Listele");
            System.out.println("3. Öğrenci Ara");
            System.out.println("4. Öğrenci Güncelle");
            System.out.println("5. Öğrenci Sil");
            System.out.println("6. Öğrenci Toplam Sayısı");
            System.out.println("7. Öğrenci Rastgele Gelsin");
            System.out.println("8. Öğrenci Not Hesapla");
            System.out.println("9. Öğrenci En Yüksek, En Düşük Notları Göster");
            System.out.println("10. Öğrenci Sıralaması Doğum Gününe Göre Göster" + SpecialColor.RESET);
            System.out.println(SpecialColor.RED + "11. Çıkış" + SpecialColor.RESET);
            System.out.println(SpecialColor.YELLOW + "Lütfen Seçim Yapınız" + SpecialColor.RESET);

            // Seçim yap
            int chooise = scanner.nextInt();
            scanner.nextLine(); // durma yerimiz

            switch (chooise) {
                // add (Öğrenci Ekle)
                case 1:
                    System.out.println("Öğrenci Adı");
                    String name = scanner.nextLine();

                    System.out.println("Öğrenci Soyadı");
                    String surname = scanner.nextLine();

                    System.out.println("Öğrenci Doğum Tarihi YYYY-MM-DD");
                    LocalDate birthDate = LocalDate.parse(scanner.nextLine());

                    System.out.println("Vize Puanı");
                    double midTerm = scanner.nextDouble();

                    System.out.println("Final Puanı");
                    double finalTerm = scanner.nextDouble();

                    studentManagementSystem.add(new StudentDto(++studentCounter, name, surname, midTerm, finalTerm, birthDate));
                    break;

                // list (Öğrenci Listele)
                case 2:
                    studentManagementSystem.list();
                    break;


                // search (Öğrenci Ara)
                case 3:
                    studentManagementSystem.list();
                    System.out.println(SpecialColor.BLUE + " Aranacak öğrenci ismini yazınız" + SpecialColor.RESET);
                    String searchName = scanner.nextLine();
                    studentManagementSystem.search(searchName);
                    break;


                // update (Öğrenci Güncelle)
                case 4:
                    studentManagementSystem.list();
                    System.out.println(SpecialColor.BLUE + "Güncelleme yapılacak Öğrenci ID'si giriniz" + SpecialColor.RESET);
                    int id = scanner.nextInt(); // Eğer int sonrası String gelecekse bunu yazmalıyız
                    scanner.nextLine();

                    System.out.println("Yeni Öğrenci Adı");
                    String nameUpdate = scanner.nextLine();

                    System.out.println("Yeni Öğrenci Soyadı");
                    String surnameUpdate = scanner.nextLine();

                    System.out.println("Öğrenci Doğum Tarihi");
                    LocalDate birthDateUpdate = LocalDate.parse(scanner.nextLine());

                    System.out.println("Vize Puanı");
                    double midTermUpdate = scanner.nextDouble();

                    System.out.println("Final Puanı");
                    double finalTermUpdate = scanner.nextDouble();

                    StudentDto studentDtoUpdate = StudentDto.builder()
                            .name(nameUpdate)
                            .surname(surnameUpdate)
                            .midTerm(midTermUpdate)
                            .finalTerm(finalTermUpdate)
                            .birthDate(birthDateUpdate)
                            .build();

                    try {
                        studentManagementSystem.update(id, studentDtoUpdate);
                    } catch (StudentNotFoundException e) {
                        System.out.println(SpecialColor.RED + e.getMessage());
                        e.printStackTrace();
                    }
                    break;


                // delete (Öğrenci Sil)
                case 5:
                    studentManagementSystem.list();
                    System.out.println(SpecialColor.BLUE + " Silinecek Öğrenci ID");
                    int deleteID = scanner.nextInt();
                    studentManagementSystem.delete(deleteID);
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
                    System.out.println(SpecialColor.YELLOW + " Sistemdem çıkış yapılıyor..." + SpecialColor.RESET);
                    System.exit(0);
                    // return; // bunu yazarsak break gerek yoktur
                    break;

                default:
                    System.out.println(SpecialColor.RED + "Geçersiz seçim yapınız! Lütfen tekrar deneyiniz" + SpecialColor.RESET);
                    break;
            }

        }
    }

} // end class
