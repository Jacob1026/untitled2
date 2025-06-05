package org.example;

import net.datafaker.Faker;

import java.util.HashSet;
import java.util.Set;

public class CollectionOne {
    public static void main(String[] args) {
        Faker faker = new Faker();
        //new HashSet 沒有順序續概念
        Set<String> emails = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            String email = faker.internet().emailAddress();
            System.out.println("新增:" + email);
            boolean added = emails.add(email);
            if (!added) {
                System.out.println("重複，無法新增");
            }
        }
        String duplicatedEmail = emails.iterator().next();
        System.out.println("重複email為" + duplicatedEmail);
        Boolean added = emails.add(duplicatedEmail); //false
        if (!added) {
            System.out.println("重複，無法新增");
        }
        String searchOne = emails.iterator().next();
        String searchTwo = faker.internet().emailAddress();

        System.out.println("查詢是否存在"+ emails.iterator().next());
        System.out.println("查詢結果"+emails.contains(searchOne));
        System.out.println("查詢是否存在"+ faker.internet().emailAddress());
        System.out.println("查詢結果"+emails.contains(searchTwo));








    }
}
