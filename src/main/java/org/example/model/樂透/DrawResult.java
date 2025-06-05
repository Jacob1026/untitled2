package org.example.model.樂透;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class DrawResult {
    private LocalDate drawDate;             // 開獎日期
    private Set<Integer> winningArea1Numbers; // 區塊一的 6 個中獎號碼
    private int winningArea2Number;         // 區塊二的 1 個中獎號碼

    public DrawResult(String drawDateStr, Set<Integer> winningArea1Numbers, int winningArea2Number) {
        // 驗證日期字串格式，或在 DataLoader 中處理
        try {
            this.drawDate = LocalDate.parse(drawDateStr);
        } catch (Exception e) {
            // 實際應用中，這裡的日期格式可能需要更強的容錯或指定格式
            // System.err.println("警告: 日期格式錯誤，使用當前日期替代: " + drawDateStr);
            this.drawDate = LocalDate.now(); // 預設或拋出異常
        }

        // 驗證號碼 (與 LotteryTicket 類似，但這裡假設來自可信源或 DataLoader 已驗證)
        if (winningArea1Numbers == null || winningArea1Numbers.size() != 6) {
            throw new IllegalArgumentException("開獎結果區塊一必須有 6 個號碼。");
        }
        for (int num : winningArea1Numbers) {
            if (num < 1 || num > 38) {
                throw new IllegalArgumentException("開獎結果區塊一號碼必須在 01-38 之間。");
            }
        }
        if (winningArea2Number < 1 || winningArea2Number > 8) {
            throw new IllegalArgumentException("開獎結果區塊二號碼必須在 01-08 之間。");
        }

        this.winningArea1Numbers = new TreeSet<>(winningArea1Numbers); // 排序方便顯示
        this.winningArea2Number = winningArea2Number;
    }

    /**
     * 靜態方法：隨機生成一期符合規則的威力彩開獎結果。
     * @param drawDateStr 開獎日期字串 (e.g., "2024-06-05")
     * @return 一個隨機生成的 DrawResult 物件
     */
    public static DrawResult generateRandomDraw(String drawDateStr) {
        Random random = new Random();
        Set<Integer> area1 = new HashSet<>();
        while (area1.size() < 6) {
            area1.add(random.nextInt(38) + 1);
        }
        int area2 = random.nextInt(8) + 1;
        return new DrawResult(drawDateStr, area1, area2);
    }

    // Getter 方法
    public LocalDate getDrawDate() {
        return drawDate;
    }

    public Set<Integer> getWinningArea1Numbers() {
        return Collections.unmodifiableSet(winningArea1Numbers);
    }

    public int getWinningArea2Number() {
        return winningArea2Number;
    }

    @Override
    public String toString() {
        String area1Str = winningArea1Numbers.stream()
                .map(n -> String.format("%02d", n))
                .collect(Collectors.joining(", "));
        return "開獎日期: " + drawDate.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", 區塊一: [" + area1Str + "], 區塊二: [" +
                String.format("%02d", winningArea2Number) + "]";
    }
}