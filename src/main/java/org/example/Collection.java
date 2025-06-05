package org.example;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        Faker faker = new Faker();
        List<String> studentNames = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            String name = faker.name().fullName();
            studentNames.add(name);
            System.out.println(name);
        }
        // array.length
        System.out.println("學生總數" + studentNames.size());
        //array[0]
        System.out.println("第一位學生"+studentNames.get(0));
        //array{array.length-1}
        System.out.println("最後一位學生"+studentNames.get(studentNames.size()-1));

        //新增 list set
        String newNames = faker.name().fullName();
        System.out.println("新增第三位:" + newNames);
        studentNames.set(2,newNames);

        System.out.println("移除第五位學生"+studentNames.get(4));
        studentNames.remove(4);

        System.out.println("最後名單");
        for (String name : studentNames){
            System.out.println(name);
        }




    }
}
