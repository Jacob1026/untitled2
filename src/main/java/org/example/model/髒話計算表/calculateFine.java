package org.example.model.髒話計算表;

import static org.example.model.髒話計算表.sheet.fineMap;

public class calculateFine {
    static int totalFine = 0;

    public calculateFine(String article) {
    }

    public static int calculateFine(){
        String article ="幹你老師奈德利，要不要臉呀垃圾，上路被提摩打爆，不如刪遊戲了";
        for (String swearWord : fineMap.keySet()) {
            if (article.contains(swearWord)) {
                int fineAmount = fineMap.get(swearWord);
                totalFine += fineAmount;
            }
        }
        return totalFine;
    }
}
