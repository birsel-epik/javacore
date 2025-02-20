package com.birselepik._2_week;

public class _10_3_Loop_DoWhile {
    // do-while Şartlar sağlansın veya sağlanmasın mutlaka 1 kere çalışır.
    public static void main(String[] args) {
        // Aşağıdaki 3 yöntemde sayıyı 1 er 1 er artırır, hepsi aynıdır.
        // i++
        // i=i+1
        // i+=1

        int i = -5;
        do {
            System.out.print(i + " - ");
            i++;
        }
        while (i <= 20);
    }
}
