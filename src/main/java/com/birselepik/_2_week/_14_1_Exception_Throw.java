package com.birselepik._2_week;

import java.io.IOException;
import java.util.Scanner;

public class _14_1_Exception_Throw {

    public static void calcula() throws ArithmeticException {
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

    }

    public static void main(String[] args) throws IOException {
        calcula();
        System.out.println("-------------------------");
        // Bilerek istisna gönder
        throw new NullPointerException("Neden boş verdiniz?");
    }


}
