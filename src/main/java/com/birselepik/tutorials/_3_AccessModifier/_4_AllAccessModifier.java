package com.birselepik.tutorials._3_AccessModifier;

import com.birselepik.tutorials._3_week.Week3_01_1_PublicAccessModifier;
import com.birselepik.utils.SpecialColor;

public class _4_AllAccessModifier {

    public static void main(String[] args) {
        Week3_01_1_PublicAccessModifier accessModifier = new Week3_01_1_PublicAccessModifier();
        System.out.println(SpecialColor.BLUE + accessModifier.publicData + SpecialColor.RESET);
        //System.out.println(SpecialColor.YELLOW+accessModifier.defaultData+SpecialColor.RESET);
        //System.out.println(SpecialColor.PURPLE+accessModifier.protectedData+SpecialColor.RESET);
        //System.out.println(SpecialColor.RED+accessModifier.privateData+SpecialColor.RESET);
    }
}
