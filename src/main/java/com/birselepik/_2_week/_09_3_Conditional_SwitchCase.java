package com.birselepik._2_week;

import java.util.Scanner;

public class _09_3_Conditional_SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen sayı giriniz: ");
        int inputValue = scanner.nextInt();

        // Multiple if/else else/if Conditional
        if (inputValue == 1) {
            System.out.println("Sayı 1");
        } else if (inputValue == 2) {
            System.out.println("Sayı 2");
        } else if (inputValue == 3) {
            System.out.println("Sayı 3");
        } else if (inputValue == 4) {
            System.out.println("Sayı 4");
        } else if (inputValue == 5) {
            System.out.println("Sayı 5");
        } else {
            System.out.println("Sayı: " + inputValue + " 1<= NUMBER <=5 dışındadır.");
        }


        // switch-case Conditional
        switch (inputValue) {
            case 1:
                System.out.println("Sayı 1");
                break;
            case 2:
                System.out.println("Sayı 2");
                break;
            case 3:
                System.out.println("Sayı 3");
                break;
            case 4:
                System.out.println("Sayı 4");
                break;
            case 5:
                System.out.println("Sayı 5");
                break;

            default:
                System.out.println("Sayı: " + inputValue + " 1<= NUMBER <=5 dışındadır.");
                break;
        }

        scanner.close();
    }
}
