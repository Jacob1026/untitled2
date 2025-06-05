package org.example.model;

public class StringToIntExceptionDemo {
    public static void main(String[] args) {
        String numberStr ="123aa";
        int number;
        try {
            number =Integer.parseInt(numberStr);
            System.out.println("轉換後數字" + number);
        }catch (ArithmeticException e){
            System.out.println("計算錯誤");
        }catch (Exception e){
            System.out.println("無法將字串轉為數字");
        }
    }
}
