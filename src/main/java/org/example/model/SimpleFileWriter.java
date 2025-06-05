package org.example.model;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileWriter {
    public static void main(String[] args) {
        String filename ="firstFile.txt";
        String content = "測試java寫入";
        try {
            writeSth(filename,content);
        }catch (IOException e){
            System.out.println("寫入發生錯誤");
        }
    }

    public static void writeSth (String filename, String content) throws IOException{
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
        System.out.println("成功寫入檔案"+filename);
    }
}
