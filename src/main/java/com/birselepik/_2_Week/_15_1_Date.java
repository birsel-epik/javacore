package com.birselepik._2_Week;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class _15_1_Date {

    //Date (GET)
    public static void dateMethod() {
        //java.util.Date date= new Date();
        Date nowDate = new Date();

        System.out.println("Şu andaki zaman: " + nowDate);
        System.out.println("1 Ocak 1970 yılından şimdi ki zamana kadar geçen sürenin milisaniye cinsinden: " + nowDate.getTime());
        System.out.println("Date: " + nowDate.getDate());

        System.out.println("#######################");
        System.out.println("Day: " + nowDate);
        System.out.println("Month: " + nowDate.getMonth()); // Saymaya Sıfırdan başlar 0=Ocak 1=Şubat
        System.out.println("Year: " + nowDate.getYear()); // 1900 (Ekle veya Çıkar)
        System.out.println("Date Yı: " + (2025 - nowDate.getYear()));
        System.out.println("Hours: " + nowDate.getHours());
        System.out.println("Mİnutes: " + nowDate.getMinutes());
        System.out.println("Seconds: " + nowDate.getSeconds());
    }

    //Date (SET)
    public static void dateSetMethod() {

    }

    // 1. YÖNTEM
    public static String nowFormat1() throws NullPointerException {
        Date nowDate = new Date();
        String specialFormat = "Şimdiki Zaman: ".concat(String.valueOf(nowDate.getHours())).concat(":").concat(String.valueOf(nowDate.getMinutes())).concat(":").concat(String.valueOf(nowDate.getSeconds())).toString();
        return specialFormat;
    }

    // 2. YÖNTEM
    public static String nowFormat2() throws NullPointerException {
        Date nowDate = new Date();
        // %s: String
        // %d: Decimal
        // %f: Float
        return String.format("Şimdiki Zaman: %02d:%02d:%02d", nowDate.getHours(), nowDate.getMinutes(), nowDate.getSeconds());
    }

    // 3. YÖNTEM
    public static String nowFormat3() throws NullPointerException {
        Date nowDate = new Date();
        Locale locale = new Locale("tr", "TR");

        // SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss", locale);
        // SimpleDateFormat sdf = new SimpleDateFormat("yyy-MMM-dd HH:mm:ss", locale);
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:ss", locale);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:ss", locale);
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss zzzz", locale);

        String formateDate = String.format("Şimdiki Zaman: %s", sdf.format(nowDate));
        return new Date().toString() + " - " + formateDate;
    }

    // PSVM
    public static void main(String[] args) {
        //dateMethod();

       /* String nowDate1 = nowFormat1();
        System.out.println(nowDate1); */

        String nowDate2 = nowFormat2();
        System.out.println(nowDate2);

        String nowDate3 = nowFormat3();
        System.out.println(nowDate3);
    }
}
