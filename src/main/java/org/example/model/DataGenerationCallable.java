package org.example.model;

import net.datafaker.Faker;

import java.util.concurrent.Callable;

public class DataGenerationCallable implements Callable<Integer> {
    private Faker faker;
    private int recordsToGenerate;
    private int taskNumber;

    public DataGenerationCallable(Faker faker, int recordsToGenerate, int taskNumber) {
        this.faker = new Faker();
        this.recordsToGenerate = recordsToGenerate;
        this.taskNumber = taskNumber;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("任務 # " + taskNumber + "正在生成" +recordsToGenerate+"筆資料");

        for (int i = 0; i < recordsToGenerate; i++) {
            String name =faker.name().fullName();
            String email =faker.internet().emailAddress();
            String phone =faker.phoneNumber().phoneNumber();
            String record = String.format("%s,%s,%s",name,email,phone);
        }
        System.out.println("任務 #"+taskNumber+"完成");
        return  recordsToGenerate;
    }


}
