package com.birselepik.project_step2_file;

import com.birselepik.utils.SpecialColor;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

// Öğrenci Yönetim Sistemi
public class StudentManagementSystem {
    Scanner scanner = new Scanner(System.in); // Scanner nesnesi oluşturuluyor.

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
        // Eğer students.txt yoksa otomatik oluştur
        createFileIfNotExist();

        // Program başlarken Öğrenci Listesini hemen yüklesin
        loadStudentsListFromFile();
    }

    /// /////////////////////////////////////////
    // Login
    // Register

    /// /////////////////////////////////////////
    // FileIO

    // File If Not Exists (Eğer students.txt yoksa, oluştur)
    private void createFileIfNotExist() {
        // student.txt
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println(SpecialColor.PURPLE + FILE_NAME + " adında dosya oluşturuldu " + SpecialColor.RESET);

            } catch (IOException ioException) {
                System.out.println(SpecialColor.CYAN + " Dosya oluşturulurken hata oluştu " + SpecialColor.RESET);
                ioException.printStackTrace();
            }
        }
    }

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
            System.out.println(SpecialColor.BLUE + " Dosyadan yüklenen öğrenci sayısı: " + SpecialColor.RESET);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(SpecialColor.RED + " Dosyadan yüklenen Öğren Kayıdı bulunamadı " + SpecialColor.RESET);
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
                new StudentDto(++studentCounter, dto.getName(), dto.getSurname(), dto.getMidTerm(), dto.getFinalTerm(), dto.getBirthDate(), dto.geteStudentType())
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
                temp.seteStudentType(dto.geteStudentType());

                // Güncellenmiş öğrenci bilgileri
                System.out.println(SpecialColor.GREEN + temp + "\nÖğrenci bilgileri güncellendi!" + SpecialColor.RESET);

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

    /// Enum Öğrenci Türü Method
    private EStudentType studentTypeMethod() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(SpecialColor.PURPLE + "Öğrenci türünü seçiniz.\n1-) Lisans\n2-) Yüksek Lisans\n3-) Doktora " + SpecialColor.RESET);
//        int typeChooise = scanner.nextInt();
//        EStudentType switchCaseStudent = switch (typeChooise) {
//            case 1 -> EStudentType.UNDERGRADUATE;
//            case 2 -> EStudentType.GRADUATE;
//            case 3 -> EStudentType.PHD;
//            default -> EStudentType.OTHER;
//        };
//        return switchCaseStudent;

        while (true) {
            System.out.println(SpecialColor.PURPLE + "Öğrenci türünü seçiniz.\n1-) Lisans\n2-) Yüksek Lisans\n3-) Doktora " + SpecialColor.RESET);
            try {
                int typeChooise = Integer.parseInt(scanner.nextLine().trim());
                EStudentType switchCaseStudent = switch (typeChooise) {
                    case 1 -> EStudentType.UNDERGRADUATE;
                    case 2 -> EStudentType.GRADUATE;
                    case 3 -> EStudentType.PHD;
                    case 4 -> EStudentType.OTHER;
                    default -> {
                        System.out.println(SpecialColor.RED + "Geçersiz seçim! Lütfen 1-3 arasında bir sayı giriniz." + SpecialColor.RESET);
                        yield null;
                    }
                };
                if (switchCaseStudent != null) {
                    return switchCaseStudent;
                }
            } catch (NumberFormatException e) {
                System.out.println(SpecialColor.RED + "Geçersiz giriş! Lütfen bir sayı giriniz." + SpecialColor.RESET);
            }
        }
    }

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
            System.out.println(SpecialColor.BLUE + "Lütfen Seçim Yapınız" + SpecialColor.RESET);

            // Seçim yap
            //int chooise = scanner.nextInt();
            //scanner.nextLine(); // durma yerimiz

            int chooise;
            try {
                chooise = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(SpecialColor.RED + " Geçersiz seçim! Lütfen bir sayı giriniz." + SpecialColor.RESET);
                continue;
            }

            switch (chooise) {
                // add (Öğrenci Ekle)
                case 1:
                    System.out.println("Öğrenci Adı");
                    String name = scanner.nextLine();
                    try {
                        name = validateNameInput(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println(SpecialColor.RED + e.getMessage() + SpecialColor.RESET);
                        break;
                    }

                    System.out.println("Öğrenci Soyadı");
                    String surname = scanner.nextLine();

                    System.out.println("Öğrenci Doğum Tarihi YYYY-MM-DD");
                    //LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                    LocalDate birthDate;
                    try {
                        birthDate = LocalDate.parse(scanner.nextLine());
                    } catch (DateTimeParseException e) {
                        System.out.println(SpecialColor.RED + " Geçersiz tarih formatı! Lütfen YYY-MM-DD formatında giriniz." + SpecialColor.RESET);
                        break;
                    }

                    System.out.println("Vize Puanı (0-100)");
                    //double midTerm = scanner.nextDouble();
                    double midTerm;
                    try {
                        midTerm = validateDoubleInput(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println(SpecialColor.RED + e.getMessage() + SpecialColor.RESET);
                        break;
                    }

                    System.out.println("Final Puanı (0-100)");
                    //double finalTerm = scanner.nextDouble();
                    double finalTerm;
                    try {
                        finalTerm = validateDoubleInput(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println(SpecialColor.RED + e.getMessage() + SpecialColor.RESET);
                        break;
                    }

                    try {
                        studentManagementSystem.add(new StudentDto(++studentCounter, name, surname, midTerm, finalTerm, birthDate, studentTypeMethod()));
                    } catch (IllegalArgumentException e) {
                        System.out.println(SpecialColor.RED + " Hata: " + e.getMessage() + SpecialColor.RESET);
                    } catch (Exception e) {
                        System.out.println(SpecialColor.RED + " Bir hata oluştu: " + e.getMessage() + SpecialColor.RESET);
                        break;
                    }

                    studentManagementSystem.add(new StudentDto(++studentCounter, name, surname, midTerm, finalTerm, birthDate, studentTypeMethod()));
                    break;

                // list (Öğrenci Listele)
                case 2:
                    try {
                        studentManagementSystem.list();
                        System.out.println(SpecialColor.BLUE + " Aranacak öğrenci ismini yazınız: " + SpecialColor.RESET);
                        String searchName = scanner.nextLine();
                        studentManagementSystem.search(searchName);
                    } catch (StudentNotFoundException e) {
                        System.out.println(SpecialColor.RED + e.getMessage() + SpecialColor.RESET);
                    } catch (Exception e) {
                        System.out.println(SpecialColor.RED + " Bir hata oluştu: " + e.getMessage() + SpecialColor.RESET);
                    }
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
                    // studentManagementSystem.list();
                    // System.out.println(SpecialColor.BLUE + "Güncelleme yapılacak Öğrenci ID'si giriniz" + SpecialColor.RESET);
                    // int id = scanner.nextInt(); // Eğer int sonrası String gelecekse bunu yazmalıyız
                    // scanner.nextLine();
                    try {
                        studentManagementSystem.list();
                        System.out.println(SpecialColor.BLUE + " Güncelleme yapılacak Öğrenci ID'si giriniz" + SpecialColor.RESET);
                        int id;
                        try {
                            id = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println(SpecialColor.RED + " Geçersiz ID! Lütfen bir sayı giriniz." + SpecialColor.RESET);
                            break;
                        }

                        System.out.println("Yeni Öğrenci Adı");
                        String nameUpdate = scanner.nextLine();

                        System.out.println("Yeni Öğrenci Soyadı");
                        String surnameUpdate = scanner.nextLine();

                        System.out.println("Öğrenci Doğum Tarihi");
                        LocalDate birthDateUpdate = LocalDate.parse(scanner.nextLine());

                        System.out.println("Vize Puanı (0-100)");
                        double midTermUpdate;
                        try {
                            midTermUpdate = validateDoubleInput(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println(SpecialColor.RED + e.getMessage() + SpecialColor.RESET);
                            break;
                        }


                        System.out.println("Final Puanı (0-100)");
                        double finalTermUpdate;
                        try {
                            finalTermUpdate = validateDoubleInput(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println(SpecialColor.RED + e.getMessage() + SpecialColor.RESET);
                            break;
                        }

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
                            //e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            System.out.println(SpecialColor.RED + "Validation Hatası: " + e.getMessage() + SpecialColor.RESET);
                        }
                    } catch (Exception e) {
                        System.out.println(SpecialColor.RED + "Bir hata oluştu: " + e.getMessage() + SpecialColor.RESET);
                    }
                    break;


                // delete (Öğrenci Sil)
                case 5:
                    // studentManagementSystem.list();
                    // System.out.println(SpecialColor.BLUE + " Silinecek Öğrenci ID");
                    // int deleteID = scanner.nextInt();
                    // studentManagementSystem.delete(deleteID);
                    try {
                        studentManagementSystem.list();
                        System.out.println(SpecialColor.BLUE + " Silinecek Öğrenci ID" + SpecialColor.RESET);
                        int deleteID = Integer.parseInt(scanner.nextLine().trim());
                        try {
                            deleteID = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println(SpecialColor.RED + "Geçersiz ID! Lütfen bir sayı giriniz." + SpecialColor.RESET);
                            break;
                        }
                        studentManagementSystem.delete(deleteID);
                    } catch (NumberFormatException e) {
                        System.out.println(SpecialColor.RED + "Bir hata oluştu: " + e.getMessage() + SpecialColor.RESET);
                    }
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

    // Double değer validasyonu için yardımcı metod
    private double validateDoubleInput(String input) {
        try {
            double value = Double.parseDouble(input);
            if (value < 0 || value > 100) {
                throw new IllegalArgumentException(SpecialColor.RED + " Not değeri 0 ile 100 arasında olmalıdır!" + SpecialColor.RESET);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SpecialColor.RED + " Geçersiz sayı formatı! Lütfen bir sayı giriniz." + SpecialColor.RESET);
        }
    }

    private String validateNameInput(String input) {
        try {
            String name = input.trim();
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException(SpecialColor.RED + " İsim boş olamaz!" + SpecialColor.RESET);
            } else if (name != null && !name.isEmpty() && name.matches(".*[.,!&%*+^'=`|?;:]+.*")) {
                System.out.println(SpecialColor.RED + " İsimde geçersiz karakterler var!" + SpecialColor.RESET);
            } else if (name.length() > 30) {
                throw new IllegalArgumentException(SpecialColor.PURPLE + " İsim 30 karakterden fazla olamaz!" + SpecialColor.RESET);
            }
        } catch (Exception e) {
            throw new StudentNotFoundException(SpecialColor.RED + e.getMessage() + SpecialColor.RESET);
        }
        return input;
    }


} // end class
