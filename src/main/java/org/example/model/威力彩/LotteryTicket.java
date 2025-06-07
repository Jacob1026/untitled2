package org.example.model.威力彩;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
//建立一張彩券
public class LotteryTicket {
    private Set<Integer>area1Number = new HashSet<>();
    private int area2Number;

    public LotteryTicket(Set<Integer> area1Number  ,int area2Number ) {
        if(area1Number.size() != 6  || area1Number == null){
            throw new IllegalArgumentException("必須為6個號碼");
        }
        for(int num : area1Number){
            if(num < 1 || num >38){
                throw new IllegalArgumentException("號碼必須為1-38");
            }
        }
        if(area2Number < 1 || area2Number > 8){
            throw new IllegalArgumentException("號碼必須為1-8");
        }

        this.area2Number = area2Number;
        this.area1Number = area1Number;
    }
    //彩券產生亂數1-38，6個  1-8，1個
 public  static LotteryTicket generateRandomTicket() {
     Random random = new Random();
     Set<Integer> area1 = new HashSet<>();

     while (area1.size() < 6) {
         area1.add(random.nextInt(38) + 1);
     }

     int area2 = random.nextInt(8) + 1;

     return new LotteryTicket(area1, area2);
  }
}

