package com.birselepik._1_Week;

import com.birselepik.utils.SpecialColor;

public class _08_2_System {

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
        processContinueJvmContinue();
        processCloseJvmStop();
    }
}
