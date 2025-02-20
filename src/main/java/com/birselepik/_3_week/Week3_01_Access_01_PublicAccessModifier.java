package com.birselepik._3_week;

import com.birselepik.utils.SpecialColor;

public class Week3_01_Access_01_PublicAccessModifier {

    public String publicData = "public data"; // Her yerden erişilebilir
    private String privateData = "private data"; // Sadece tanımlandığı sınıf içinden erişilebilir
    protected String protectedData = "protected data"; // Aynı paket ve alt sınıflardan erişilebilir
    String defaultData = "default data"; // (Hiçbir şey yazılmaz) | Sadece aynı paket içinden erişilebilir

    public static void main(String[] args) {
        Week3_01_Access_01_PublicAccessModifier accessModifier = new Week3_01_Access_01_PublicAccessModifier();
        System.out.println(SpecialColor.BLUE + accessModifier.publicData + SpecialColor.RESET);
        System.out.println(SpecialColor.YELLOW + accessModifier.defaultData + SpecialColor.RESET);
        System.out.println(SpecialColor.PURPLE + accessModifier.protectedData + SpecialColor.RESET);
        System.out.println(SpecialColor.RED + accessModifier.privateData + SpecialColor.RESET);
    }
}
