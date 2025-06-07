package org.example.model.威力彩;

import org.example.model.樂透.DrawResult;
import org.example.model.樂透.LotteryTicket;

import java.util.HashSet;
import java.util.Set;

public class LotteryMatcher {
    // area1Number ==area1Win set
    // area2Number == area2Win int
    //判斷是隨機號碼是否與當期中獎號碼相同
    public static String checkPrize(LotteryTicket ticket, DrawResult result){
        Set<Integer>area1matchs = new HashSet<>(ticket.getArea1Numbers());
        int area2matchs ;
    }
}

