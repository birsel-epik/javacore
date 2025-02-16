package com.birselepik._2_Week;

public class _13_2_MethodIsReturn {

    // 3-) Return lu Parametresiz
    // İşlem sonunda geriye bir değer dönecekse, başka yere gönderecek bir şey döndürecekse "Return" kullanılır.
    public String metotReturnluParametresiz() {
        return "Metot Returnlu Parametresiz";
    }

    // 4-) Return lu Parametreli -1
    public String metorReturnluParametreli1(String name, String surname) {
        return "Adınız: " + name + "Soyadınız :" + surname;
    }

    // 5-) Return lu Parametreli - 2
    public Integer metorReturnluParametreli2(int number) {
        return number;
    }

    // PSVM
    public static void main(String[] args) {
        _13_2_MethodIsReturn isReturn1 = new _13_2_MethodIsReturn();

        String result1 = isReturn1.metotReturnluParametresiz();
        System.out.println(result1);

        String result2 = isReturn1.metorReturnluParametreli1("Birsel", "Epik");
        System.out.println(result2);

        Integer result3 = isReturn1.metorReturnluParametreli2(123456);
        System.out.println(result3);
    }

}
