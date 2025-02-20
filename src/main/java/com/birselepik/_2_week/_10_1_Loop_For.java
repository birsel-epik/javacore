package com.birselepik._2_week;

public class _10_1_Loop_For {
    public static void main(String[] args) {
        // Aşağıdaki 3 yöntemde sayıyı 1 er 1 er artırır, hepsi aynıdır.
        // i++
        // i=i+1
        // i+=1

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " ");
        }

        System.out.println("\n ____________________________________ \n");

        for (int i = 1; i <= 20; i++) {
            System.out.print(i + " - ");
        }

        System.out.println("\n ____________________________________ \n");

        // for döngüsü sonsuzluk
        // for(;;) {}
        int number = 1;
        for (; ; ) {
            System.out.print(number + " ");
            number++;
            if (number >= 50)
                break;
            ;
        }

    }
}
