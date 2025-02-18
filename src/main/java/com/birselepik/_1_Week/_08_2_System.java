package com.birselepik._1_Week;

import com.birselepik.utils.SpecialColor;

import java.util.Scanner;

public class _08_2_System {

    // 1-) System.in
    public static void systemMethod1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir şey yazın: ");
        String input = scanner.nextLine();
        System.out.println("Girdiğiniz: " + input);
        scanner.close();
    }


    // 2-) System.out
    public static void systemMethod2() {
        System.out.println("Merhaba, Dünya!");
        System.out.print("Yan yana yazılır.");
        System.out.printf("\nFormatlı yazdırma: %d + %d = %d", 5, 3, 5 + 3);
    }


    // 3-) System.err
    public static void systemMethod3() {
        System.err.println("Bu bir hata mesajıdır!\n");
    }


    // 4-) System.getProperty - Java Properties
    public static void systemMethod4() {
        System.out.println("Java Versiyonu: " + System.getProperty("java.version"));
        System.out.println("OS Adı: " + System.getProperty("os.name"));
        System.out.println("Kullanıcı Adı: " + System.getProperty("user.name"));
        System.out.println("Çalışma Dizini: " + System.getProperty("user.dir"));
    }


    // 5-) System.getenv - Ortam DEğişkenleri
    public static void systemMethod5() {
        System.out.println("PATH: " + System.getenv("PATH"));
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
    }


    // 6-) System.gc - Çöp Toplayıcı (Garbage Collector)
    public static void systemMethod6() {
        System.out.println("Çöp toplama çağrısı yapılıyor...");
        System.gc();
    }


    // 7-) System.currentTimeMillis - Zaman Ölçme
    public static void systemMethod7() {
        long start = System.currentTimeMillis();

        // 1 milyon döngü çalıştır
        for (int i = 0; i < 1_000_000; i++) {
        }

        long end = System.currentTimeMillis();
        System.out.println("Geçen süre: " + (end - start) + " ms");
    }


    // 8-) System.nanoTime - Nano zaman hesaplama
    public static void systemMethod8() {
        long start = System.nanoTime();

        for (int i = 0; i < 1_000_000; i++) {
        }

        long end = System.nanoTime();
        System.out.println("Geçen süre: " + (end - start) + " ns");
    }

    /// ///////////////////////////////////////////////////

    // Eğer System.exit(0) kullanırsam;
    // 1-) JVM duruyor.
    // 2-) Çalışan Tüm Threadler Sonlanıyor.
    // 3-) Programın işletim sistemmindeki processlerde kapanıyor

    // System.exit
    public static void processCloseJvmStop() {
        System.out.println(SpecialColor.RED + "Program başladı. System.exit(0)\n" + SpecialColor.RESET);
        System.exit(0);
        System.out.println("Bu satır çalışmayacaktır ?");
    }


    // break
    public static void processContinueJvmContinue() {
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Program başladı. Break;");
                System.out.println(SpecialColor.YELLOW + "Sadece döngüden çıkılıyor." + SpecialColor.RESET);
                break;
            }
            System.out.println(i + ".sıra");
        }
        System.out.println(SpecialColor.GREEN + "Bu satır çalışacak\n" + SpecialColor.RESET);
    }


    // PSVM
    public static void main(String[] args) {
        //System
        // processContinueJvmContinue();
        // processCloseJvmStop();
        systemMethod1();
        systemMethod2();
        systemMethod3();
        systemMethod4();
        systemMethod5();
        systemMethod6();
        systemMethod7();
        systemMethod8();
    }
}
