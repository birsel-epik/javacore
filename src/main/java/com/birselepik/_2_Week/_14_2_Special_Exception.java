package com.birselepik._2_Week;

// aşağıdakiler örnek exeption
// public class _14_2_SpecialException extends Exception
// public class _14_2_SpecialException extends RuntimeException

public class _14_2_Special_Exception extends Exception {

    // Constructor
    public _14_2_Special_Exception(String message) {
        super(message);
    }

    //PSVM
    public static void main(String[] args) throws _14_2_Special_Exception {
        throw new _14_2_Special_Exception("Kendime özel exeption");
    }

}
