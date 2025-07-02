package org.example.model.髒話計算表;

import static org.example.model.髒話計算表.sheet.fineMap;

public class calculateFine {

    public  int calculate(String article){
        int totalFine = 0;
        if(article == null || article.isEmpty()){
            return 0;
        }
        for (String swearWord : fineMap.keySet()) {
            if (article.contains(swearWord)) {
                int fineAmount = fineMap.get(swearWord);
                totalFine += fineAmount;
            }
        }
        return totalFine;
    }
}
