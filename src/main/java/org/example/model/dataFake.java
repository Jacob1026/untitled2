package org.example.model;

import net.datafaker.Faker;
import net.datafaker.providers.healthcare.Disease;

public class dataFake {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(getDisease().anyDisease());
        System.out.println(getFaker().disease().anyDisease());
        System.out.println(getRandomBasketballPlayer(faker));
    }

    private static Disease getDisease() {
        Faker faker = new Faker();
//        Disease disease = faker.disease();
        return faker.disease();
    }

    private static Faker getFaker() {
        Faker faker = new Faker();
        return faker;

    }

    private static String getRandomBasketballPlayer(Faker faker){
        return faker.basketball().players();
    }


}

