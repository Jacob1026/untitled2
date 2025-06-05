package org.example.model;

import net.datafaker.Faker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataGenerationTask implements Runnable {
    private String fileName;
    private int numberRecord;
    private int taskNumber;

    public DataGenerationTask(String fileName, int numberRecord, int taskNumber) {
        this.fileName = fileName;
        this.numberRecord = numberRecord;
        this.taskNumber = taskNumber;
    }
    @Override
    public void run(){
        System.out.printf("任務%s: 正在生成檔案:%s",taskNumber,fileName);
        Faker faker =new Faker();
        try (
                FileWriter Writer =new FileWriter(fileName);
                BufferedWriter bufferedWriter =new BufferedWriter(Writer);
        ){
            bufferedWriter.write("name,email,phone");
            bufferedWriter.newLine();
            for (int i = 0; i < numberRecord; i++) {
                String name = faker.name().fullName();
                String email = faker.internet().emailAddress();
                String phone = faker.phoneNumber().phoneNumber();
                bufferedWriter.write(String.format("%s,%s,%s",name,email,phone));
                bufferedWriter.newLine();
            }
            System.out.printf("檔案:%s 生成完成,共%s筆資料",fileName,numberRecord);
        }catch (IOException e){
            System.out.println("寫入檔案錯誤");
        }
    }
}
