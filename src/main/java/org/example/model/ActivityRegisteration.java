package org.example.model;

import net.datafaker.Faker;

import java.util.*;

public class ActivityRegisteration {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Map<String, String> registeredUsers = new HashMap<>();
        System.out.println("===活動報名===");
        int numberOfAttempts = 100;
        int successfulRegisteration = 0;


        for (int i = 0; i < numberOfAttempts; i++) {
            String uniqueId = faker.internet().uuid();
            String userName = faker.name().fullName();
            registeredUsers.put(uniqueId,userName);
//            System.out.println("嘗試報名" + userName);
//            int frequency = Collections.frequency(registeredUsers,userName);
//            if(!(frequency >= 1) ){
//                System.out.println("成功報名");
//                registeredUsers.add(userName);
//                successfulRegisteration++;
//            }else {
//                System.out.println("失敗，重複報名");
//            }
        }
        System.out.println("==報名結束==");
        System.out.println("報名人數" + numberOfAttempts);
        System.out.println("成功報名人數" + registeredUsers.size());

        System.out.println("==成功報名列表======");
        if(registeredUsers.isEmpty()){
            System.out.println("沒有人報名成功");
        }else {
            registeredUsers.forEach((key, value) -> {
                System.out.println("Key: " + key + ", Value: " + value);
            });
//            } 如果資料型態是以物件的形式的話我就打印不出來了，所以用遍歷
//        }
            System.out.println(registeredUsers);
        }

    }
}
