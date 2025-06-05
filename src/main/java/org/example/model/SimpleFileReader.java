package org.example.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileReader {
    public static void main(String[] args) {
        String fileName ="firstFile.txt";
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line ;

            while ((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
            bufferedReader.close();
        }catch (IOException e){
            System.out.println("讀取失敗");
        }
    }
}
