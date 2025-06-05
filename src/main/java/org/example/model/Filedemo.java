package org.example.model;

import java.io.FileReader;
import java.io.IOException;

public class Filedemo {
    public static void main(String[] args) throws IOException {
        String path = "";
        try{
            FileReader reader = new FileReader(path);
            reader.close();
        }catch (IOException e){
            System.out.println("檔案讀取錯誤");
        }

    }
}
