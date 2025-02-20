package com.birselepik._3_AccessModifier;

import com.birselepik._3_week.Week3_01_Access_01_PublicAccessModifier;
import com.birselepik.utils.SpecialColor;

public class _4_AllAccessModifier {

    public static void main(String[] args) {
        Week3_01_Access_01_PublicAccessModifier accessModifier = new Week3_01_Access_01_PublicAccessModifier();
        System.out.println(SpecialColor.BLUE + accessModifier.publicData + SpecialColor.RESET);
        //System.out.println(SpecialColor.YELLOW+accessModifier.defaultData+SpecialColor.RESET);
        //System.out.println(SpecialColor.PURPLE+accessModifier.protectedData+SpecialColor.RESET);
        //System.out.println(SpecialColor.RED+accessModifier.privateData+SpecialColor.RESET);
    }
}
