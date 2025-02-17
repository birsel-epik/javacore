package com.birselepik._2_Week;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class _15_3_Local_DateTime {

    // Yeni nesil Date yapısı
    // LocalDateTime1
    public static void localDateFormatGetMethod1() {

        LocalDateTime nowTime = LocalDateTime.now();
        Locale locale = new Locale("tr", "TR");

        // SimpledateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss", locale);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss", locale);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MMM-dd HH:mm:ss", locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MMMM-dd HH:mm:ss", locale);

        // Normal Çıktı
        System.out.println("1Y Şu andaki zaman: " + nowTime);
        System.out.println("2Y Şu andaki zaman: " + nowTime.format(formatter));
    }


    // LocalDateTime2
    public static void localDateFormatGetMethod2() {
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println("Gün: " + nowTime.getDayOfMonth());
        System.out.println("Kaçıncı Ay: " + nowTime.getMonthValue()); // 1 den saymaya başlıyor
        System.out.println("Yıl: " + nowTime.getYear());
        System.out.println("Saat: " + nowTime.getHour());
        System.out.println("Dakika: " + nowTime.getMinute());
        System.out.println("Saniye: " + nowTime.getSecond());

        System.out.println("-----------------------------------");
    }


    // Set Method
    public static void localeDateFormatSetMethod1() {
        Locale locale = new Locale("tr", "TR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyy HH:mm:ss", locale);

        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime newDate = nowTime
                .withDayOfMonth(11) //
                .withMonth(12) //
                .withYear(2029) //
                .withHour(14)
                .withMinute(44)
                .withSecond(23);
        System.out.println("Şu andaki Tarih: " + nowTime);
        System.out.println("Randevu Tarihi: " + newDate.format(formatter));
    }


    // PSVM (Konsole çıktısı)
    public static void main(String[] args) {
        localDateFormatGetMethod1();
        localDateFormatGetMethod2();
        localeDateFormatSetMethod1();
    } //end psvm
} //end class
