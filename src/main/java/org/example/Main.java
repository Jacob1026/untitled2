package org.example;

import net.datafaker.Faker;
import net.datafaker.providers.base.BaseProviders;
import net.datafaker.providers.base.Weather;

public class Main {
    public static void main(String[] args) {
        Faker faker =new Faker();
        String teacherName = faker.name().fullName();
        String teach = "英文";



    }
}