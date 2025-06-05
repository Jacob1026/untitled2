package org.example;

import net.datafaker.Faker;

import java.util.Scanner;

public class 練習 {
    public static void main(String[] args) {
        String[][] data = new String[3][];
        Scanner scn = new Scanner(System.in);
        for (int x = 0; x < 3; x++) {
            System.out.println(x + 1 + "號同學接踵第幾劑:");
            data[x] = new String[scn.nextInt()];
            for (int y = 0; y < data[x].length; y++) {
                System.out.println("請輸入" + (y + 1) + "次接踵日期");
                data[x][y] = scn.next();
            }
        }
    }
}

