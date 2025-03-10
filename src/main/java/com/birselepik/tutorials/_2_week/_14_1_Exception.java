package com.birselepik.tutorials._2_week;

import java.io.IOException;
import java.util.Scanner;

public class _14_1_Exception {

    // 1. Örnek - Hata döndürdü
    // public static void main(String[] args) {
    //     int number1 = 25;
    //     int number2 = 0;
    //     int result = number1 / number2;
    //     /*
    //     Exception in thread "main" java.lang.ArithmeticException: / by zero
    //  at com.birselepik._2_Week._14_1_Exception.main(_14_1_Exception.java:7)
    //      */
    //     System.out.println(result);
    //     System.out.println("Son 10.00 satır");
    // }


    // 2. Örnek (throws - > hata gelebileceğini önceden bildiriyoruz)
    public static void main(String[] args) throws ArithmeticException, IOException {
        Scanner inputValue = new Scanner(System.in);
        int number1, number2;

        System.out.println("Number 1 giriniz:");
        number1 = inputValue.nextInt();

        System.out.println("Number 2 giriniz:");
        number2 = inputValue.nextInt();

        try {
            int result = number1 / number2;
            System.out.println(result);
        } catch (ArithmeticException ai) {
            ai.printStackTrace(); // hatayı consol da loglasın
            //ai.getMessage();
        } catch (Exception e) { // bütün istisnas kütüphanelerini çağırıyor
            e.printStackTrace(); // hatayı consol da loglasın
        } finally {
            System.out.println("istisna olsa da olmasa da yapılacak iş");
            inputValue.close(); // scanner i kapatıyoruz
        }

        System.out.println("Son 10.00 satır");
        /*
        java.lang.ArithmeticException: / by zero
        at com.birselepik._2_Week._14_1_Exception.main(_14_1_Exception.java:35)
        */
    }

}
