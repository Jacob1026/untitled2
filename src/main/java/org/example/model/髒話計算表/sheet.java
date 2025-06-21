package org.example.model.髒話計算表;

import java.util.HashMap;
import java.util.Map;

public class sheet {
     static final Map<String, Integer> fineMap = new HashMap<>();

     static {
          fineMap.put("幹", 0); // 台語發語詞不構成公然侮辱
          fineMap.put("更年期到了", 4800); // 涉及個人私事，被判刑公然侮辱
          fineMap.put("賤貨", 6000); // 指控對方犯罪行為
          fineMap.put("米蟲", 7500); // 具有明顯侮辱性的言論
          fineMap.put("王八蛋", 8000); // 涉及具體人名，造成名譽損害
          fineMap.put("不要臉的髒東西", 9000); // 具有明顯侮辱性的言論
          fineMap.put("你去吃屎啦", 4500); // 言語造成對方身心受創，需要醫療護理
          fineMap.put("敗類", 9000); // 言論使對方人格受損
          fineMap.put("智障", 4500); // 使用具有歧視意味的詞語
          fineMap.put("賤人就是矯情", 6000); // 貶低他人身份，造成心理傷害
          fineMap.put("頭殼裝屎", 9000); // 言論對他人造成精神折磨
          fineMap.put("白痴", 7500); // 涉及對他人家庭和個人品德的侮辱
          fineMap.put("婊子", 5000); // 對對方身份或性格的嚴重侮辱
          fineMap.put("下流", 6000); // 使用具有侮辱性的詞語
          fineMap.put("幹X娘", 7500); // 具有極大的侮辱性，造成心理傷害
          fineMap.put("死番仔", 9000); // 涉及種族歧視的言論
          fineMap.put("人渣公務員", 9000); // 公然侮辱公職人員，造成精神折磨
          fineMap.put("神經病", 4500); // 使用侮辱性詞語，對對方造成精神傷害
          fineMap.put("特珠性關條", 6000); // 使用極度惡劣言語，需公開道歉
          fineMap.put("滾蛋", 7500); // 具有明顯的貶低性，影響社會風氣
          fineMap.put("笨蛋", 5000); // 侮辱性言論，造成對方心理不適
          fineMap.put("廢物", 4500); // 侮辱性言詞，嚴重損害他人自尊心
          fineMap.put("北港香爐", 6000); // 具有極大的侮辱性，對對方造成心理傷害
          fineMap.put("醜八怪", 7500); // 侮辱性言詞，造成對方尊嚴受損
          fineMap.put("媽的", 4500); // 涉及對他人家庭的侮辱
          fineMap.put("狗娘養的", 9000); // 涉及對他人母親的侮辱
          fineMap.put("低能兒", 6000); // 對對方人身或家庭的嚴重侮辱
          fineMap.put("乞丐", 7500); // 涉及對他人家庭背景的侮辱
          fineMap.put("低端", 4500); // 具有極大的貶低性，對對方造成心理傷害
          fineMap.put("垃圾", 9000);// 涉及對他人心理健康的極大侮辱
     }

}


