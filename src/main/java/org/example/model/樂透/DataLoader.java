package org.example.model.樂透;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataLoader {

    public static List<DrawResult> loadHistoricalDraws(String filePath) throws IOException {
        List<DrawResult> historicalDraws = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\historical_draws.txt"))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length != 8) {
                    System.err.println("警告: 歷史數據檔案第 " + lineNumber + " 行格式錯誤，跳過此行: " + line);
                    continue;
                }

                String drawDateStr = parts[0].trim();
                Set<Integer> area1Numbers = new HashSet<>();
                int area2Number = -1;

                try {
                    for (int i = 1; i <= 6; i++) {
                        area1Numbers.add(Integer.parseInt(parts[i].trim()));
                    }
                    area2Number = Integer.parseInt(parts[7].trim());

                    // 基本驗證 (DrawResult 建構子也會驗證，但這裡可以提前捕捉)
                    if (area1Numbers.size() != 6) {
                        System.err.println("警告: 歷史數據檔案第 " + lineNumber + " 行區塊一號碼數量不足6個，跳過此行: " + line);
                        continue;
                    }
                    for (int num : area1Numbers) {
                        if (num < 1 || num > 38) throw new NumberFormatException("區塊一號碼超出範圍");
                    }
                    if (area2Number < 1 || area2Number > 8) throw new NumberFormatException("區塊二號碼超出範圍");

                    historicalDraws.add(new DrawResult(drawDateStr, area1Numbers, area2Number));

                } catch (NumberFormatException e) {
                    System.err.println("警告: 歷史數據檔案第 " + lineNumber + " 行數字解析錯誤，跳過此行: " + line + " - " + e.getMessage());
                } catch (IllegalArgumentException e) { // Catch validation errors from DrawResult constructor
                    System.err.println("警告: 歷史數據檔案第 " + lineNumber + " 行數據無效，跳過此行: " + line + " - " + e.getMessage());
                }
            }
        }
        return historicalDraws;
    }
}