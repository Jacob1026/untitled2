package org.example.model.樂透;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryTicket {
    private Set<Integer> area1Numbers; // 區塊一的 6 個號碼
    private int area2Number;           // 區塊二的 1 個號碼

    /**
     * 公開建構子，用於手動創建彩票（例如使用者輸入）或隨機生成後內部調用。
     * @param area1Numbers 區塊一的號碼集合
     * @param area2Number 區塊二的號碼
     * @throws IllegalArgumentException 如果號碼不符合威力彩規則
     */
    public LotteryTicket(Set<Integer> area1Numbers, int area2Number) {
        // 驗證區塊一號碼
        if (area1Numbers == null || area1Numbers.size() != 6) {
            throw new IllegalArgumentException("區塊一必須有 6 個號碼。");
        }
        for (int num : area1Numbers) {
            if (num < 1 || num > 38) {
                throw new IllegalArgumentException("區塊一號碼必須在 01-38 之間。");
            }
        }
        // 驗證區塊二號碼
        if (area2Number < 1 || area2Number > 8) {
            throw new IllegalArgumentException("區塊二號碼必須在 01-08 之間。");
        }

        this.area1Numbers = new TreeSet<>(area1Numbers); // 使用 TreeSet 確保號碼排序
        this.area2Number = area2Number;
    }

    /**
     * 靜態方法：隨機生成一張符合規則的威力彩彩票。
     *
     * @return 一張隨機生成的 LotteryTicket 物件
     */
    public static LotteryTicket generateRandomTicket() {
        Random random = new Random();
        Set<Integer> area1 = new HashSet<>();
        // 隨機生成區塊一的 6 個不重複號碼 (1-38)
        while (area1.size() < 6) {
            area1.add(random.nextInt(38) + 1); // nextInt(38) 生成 0-37, +1 變 1-38
        }

        // 隨機生成區塊二的 1 個號碼 (1-8)
        int area2 = random.nextInt(8) + 1; // nextInt(8) 生成 0-7, +1 變 1-8

        return new LotteryTicket(area1, area2); // 現在可以直接調用 public 建構子
    }

    // Getter 方法
    public Set<Integer> getArea1Numbers() {
        return Collections.unmodifiableSet(area1Numbers); // 返回不可修改的 Set
    }

    public int getArea2Number() {
        return area2Number;
    }

    @Override
    public String toString() {
        String area1Str = area1Numbers.stream()
                .map(n -> String.format("%02d", n))
                .collect(Collectors.joining(", "));
        return "區塊一: [" + area1Str + "], 區塊二: [" +
                String.format("%02d", area2Number) + "]";
    }
}