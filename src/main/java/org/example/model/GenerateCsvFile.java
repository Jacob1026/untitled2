package org.example.model;

import net.datafaker.Faker;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class GenerateCsvFile {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String fileName ="user.csv";
        int numberOfUser = 100;

        try (FileWriter fileWriter =new FileWriter(fileName, StandardCharsets.UTF_8);
             FileOutputStream fileOutputStream =new FileOutputStream(fileName);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        ){

            bufferedWriter.write("名字,email,電話號碼");
            for (int i = 0; i < numberOfUser; i++) {
                String name = faker.name().fullName();
                String email =faker.internet().emailAddress();
                String phone = faker.phoneNumber().phoneNumber();

                bufferedWriter.write(String.format("%s,%s,%s" ,name,email,phone));
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            System.out.println("建立失敗");
        }
    }
}
