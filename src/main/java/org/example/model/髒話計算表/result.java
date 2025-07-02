package org.example.model.髒話計算表;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class result {
    public static void main(String[] args) {
        //1:自行輸入文章
//        Scanner scanner = new Scanner(System.in);
//        String article = scanner.nextLine();

        //2:設置 article 內容
//        String article = "幹你娘奈德利，上路被提摩打爆，要不要刪遊戲呀";
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = "C:\\Users\\user\\Desktop\\article.txt";

        try {
            FileReader fileReader =new FileReader(fileName);
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            String currentLine ;
            while ((currentLine = bufferedReader.readLine())!=null){
                stringBuilder.append(currentLine).append("\n");
            }
        }catch (FileNotFoundException e){
            System.out.println("找不到檔案" + e);
        }catch (IOException e) {
            System.out.println("讀取檔案時發生錯誤" + e);
            return;
        }
        String article = stringBuilder.toString();

        calculateFine calculateFine = new calculateFine();
        int total = calculateFine.calculate(article);
        System.out.println("罰金總計：" + total);
        System.out.println(article);
//        scanner.close();
    }
}
