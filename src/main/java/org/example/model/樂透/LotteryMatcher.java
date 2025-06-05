package org.example.model.樂透;

import java.util.HashSet;
import java.util.Set;

public class LotteryMatcher {

    public static String checkPrize(LotteryTicket ticket, DrawResult result) {
        Set<Integer> matchedArea1 = new HashSet<>(ticket.getArea1Numbers());
        matchedArea1.retainAll(result.getWinningArea1Numbers());
        int area1Matches = matchedArea1.size();
        boolean area2Matched = (ticket.getArea2Number() == result.getWinningArea2Number());

        if (area1Matches == 6 && area2Matched) {
            return "頭獎";
        } else if (area1Matches == 6 && !area2Matched) {
            return "貳獎";
        } else if (area1Matches == 5 && area2Matched) {
            return "參獎 $150,000";
        } else if (area1Matches == 5 && !area2Matched) {
            return "肆獎 $20,000";
        } else if (area1Matches == 4 && area2Matched) {
            return "伍獎 $4,000";
        } else if (area1Matches == 4 && !area2Matched) {
            return "陸獎 $800";
        } else if (area1Matches == 3 && area2Matched) {
            return "柒獎 $400";
        } else if (area1Matches == 2 && area2Matched) {
            return "捌獎 $200";
        } else if (area1Matches == 3 && !area2Matched) {
            return "玖獎 $100";
        } else if (area1Matches == 1 && area2Matched) {
            return "普獎 $100";
        } else {
            return "未中獎";
        }
    }
}