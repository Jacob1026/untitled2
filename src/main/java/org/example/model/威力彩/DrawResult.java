package org.example.model.威力彩;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DrawResult {
    private Set <Integer> area1Win = new HashSet<>();
    private int area2Win;
    private String dataNumber;

    public DrawResult(String dataNumber) {
        String  fileName = "C:\\Users\\user\\Desktop\\historical_draws.txt";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
        }catch (FileNotFoundException e){
            System.out.println("找不到檔案喔");
        } catch (IOException e) {
            System.out.println("檔案讀取錯誤");
        }
        this.dataNumber = dataNumber;
    }

    public DrawResult(Set<Integer> area1Win, int area2Win, Set<Integer> drawNumber1, int drawNumber2) {
        if(area1Win.size() != 6  || area1Win == null){
            throw new IllegalArgumentException("必須為6個號碼");
        }
        for(int num : area1Win){
            if(num < 1 || num >38){
                throw new IllegalArgumentException("號碼必須為1-38");
            }
        }
        if(area2Win < 1 || area2Win > 8){
            throw new IllegalArgumentException("號碼必須為1-8");
        }
        this.area1Win = area1Win;
        this.area2Win = area2Win;
    }
}

