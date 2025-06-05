package org.example.model;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","Bob","Charlie");
        //for遍歷
        for(String name : names){
            printName(name);
        }
        //Lambda
        names.forEach((name)->printName(name));

    }
    public static void  printName(String name){
        System.out.println(name);
    }
}
