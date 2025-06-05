package org.example.model;

import org.example.LengthException;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入密碼");
    if(scanner.hasNext()){
        String pwds =scanner.next().trim();
        //密碼長度限制
        if (pwds.length()>20 || pwds.length() <= 8){
            throw new LengthException();
        }
        //密碼格式驗證
        String password_regex =  "^(?=.*[A-Z])(?=.*[a-z]).*$";
        if(!pwds.matches(password_regex)){
            throw new RuntimeException("密碼要包含數字以及大小寫");
        }
    System.out.println(pwds);
    }

    }
}
