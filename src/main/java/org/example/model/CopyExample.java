package org.example.model;

import java.io.*;

public class CopyExample {
    public static void main(String[] args) {
        String sourceFile = "firstFile.txt";
        String targetFile = "firstFile_copy.txt";

        // 使用 try-with-resources 語句，確保資源會被自動關閉
        try (FileReader fileReader = new FileReader(sourceFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(targetFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String line;
            // 逐行讀取來源檔案
            while ((line = bufferedReader.readLine()) != null) {
                // System.out.println(line); // 這行可以保留，用於在控制台顯示讀取到的內容 (除錯用)
                bufferedWriter.write(line);    // 將讀取到的該行內容寫入目標檔案
                bufferedWriter.newLine();      // 寫入一個換行符，保持檔案的行結構
            }
            System.out.println("檔案複製成功！");

        } catch (FileNotFoundException e) {
            System.err.println("錯誤：來源檔案 " + sourceFile + " 未找到。");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("檔案複製失敗：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
