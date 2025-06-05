package org.example.model.樂透;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*; // For Scanner, List, Set, Map, HashMap, LinkedHashMap, Comparator etc.

public class PowerLotterySimulator {

    private static final String HISTORY_FILE = "C:\\Users\\user\\Desktop\\historical_draws.txt";
    private static List<DrawResult> historicalDrawResults;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            historicalDrawResults = DataLoader.loadHistoricalDraws(HISTORY_FILE);
            System.out.println("成功載入 " + historicalDrawResults.size() + " 期歷史開獎數據。");
        } catch (IOException e) {
            System.err.println("錯誤: 無法載入歷史開獎數據檔案 '" + HISTORY_FILE + "': " + e.getMessage());
            System.err.println("請確保檔案存在且格式正確。程式將無法執行回測功能。");
            historicalDrawResults = new ArrayList<>();
        }

        int choice;
        do {
            displayMenu();
            System.out.print("請選擇功能: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // 消耗換行符

                switch (choice) {
                    case 1:
                        simulateRandomDraw();
                        break;
                    case 2:
                        if (historicalDrawResults.isEmpty()) {
                            System.out.println("沒有可用的歷史數據進行回測。請檢查 " + HISTORY_FILE + " 檔案。");
                        } else {
                            backtestMyTicket(scanner);
                        }
                        break;
                    case 3:
                        System.out.println("感謝使用，再見！");
                        break;
                    default:
                        System.out.println("無效的選擇，請重新輸入。");
                }
            } catch (InputMismatchException e) {
                System.out.println("輸入無效，請輸入數字選項。");
                scanner.nextLine(); // 清除錯誤的輸入
                choice = 0;
            }
            System.out.println(); // 換行，使輸出更清晰
        } while (choice != 3);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("--- 威力彩模擬系統 ---");
        System.out.println("1. 隨機生成一張彩票並模擬開獎");
        System.out.println("2. 回測我的彩票 (需歷史數據)");
        System.out.println("3. 退出");
        System.out.println("--------------------");
    }

    private static void simulateRandomDraw() {
        System.out.println("\n--- 隨機模擬開獎 ---");
        LotteryTicket myTicket = LotteryTicket.generateRandomTicket();
        System.out.println("您的彩票: " + myTicket);

        // 使用 DrawResult 的靜態方法生成當期開獎號碼
        String currentDateStr = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        DrawResult currentDrawResult = DrawResult.generateRandomDraw(currentDateStr);
        System.out.println("本期開獎: " + currentDrawResult);

        String prize = LotteryMatcher.checkPrize(myTicket, currentDrawResult);
        System.out.println("中獎結果: " + prize);
        System.out.println("--------------------");
    }

    private static void backtestMyTicket(Scanner scanner) {
        System.out.println("\n--- 回測我的彩票 ---");
        LotteryTicket myTicket = null;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                Set<Integer> area1Numbers = new TreeSet<>(); // Use TreeSet to store in sorted order and handle duplicates
                System.out.println("請輸入區塊一的 6 個號碼 (1-38), 用空格或逗號分隔: ");
                String area1Input = scanner.nextLine();
                // 替換逗號為空格，然後用空格分割
                String[] nums1 = area1Input.trim().replaceAll(",", " ").split("\\s+");

                if (nums1.length != 6) {
                    throw new IllegalArgumentException("區塊一必須輸入 6 個號碼。");
                }
                for (String s : nums1) {
                    int num = Integer.parseInt(s.trim());
                    // LotteryTicket constructor will validate range, Set.add will validate uniqueness
                    if (!area1Numbers.add(num)) { // TreeSet.add returns false if element already present
                        throw new IllegalArgumentException("區塊一號碼重複: " + num);
                    }
                    // 區塊一號碼範圍驗證也可以在此處或 LotteryTicket 建構子中進行
                    if (num < 1 || num > 38) {
                        throw new IllegalArgumentException("區塊一號碼無效 (1-38): " + num);
                    }
                }
                if (area1Numbers.size() != 6) { // Double check size after adding to set (in case of duplicates not caught by exception)
                    throw new IllegalArgumentException("區塊一號碼數量不足或有重複，請確保輸入6個不重複號碼。");
                }


                System.out.println("請輸入區塊二的 1 個號碼 (1-8): ");
                String area2Input = scanner.nextLine().trim();
                int area2Number = Integer.parseInt(area2Input);
                // LotteryTicket constructor will validate range for area2Number

                myTicket = new LotteryTicket(area1Numbers, area2Number); // Now calls public constructor
                isValidInput = true;

            } catch (InputMismatchException e) { // Should be caught by nextInt if used, but here using nextLine
                System.out.println("輸入格式錯誤，請確保輸入的是數字。");
                // scanner.nextLine(); // Not needed if always using nextLine()
            } catch (NumberFormatException e) {
                System.out.println("號碼輸入包含非數字字元，請重新輸入。 " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("號碼輸入錯誤: " + e.getMessage());
            } catch (Exception e) { // Catch-all for unexpected errors
                System.out.println("發生未知輸入錯誤: " + e.getMessage());
                e.printStackTrace(); // For debugging
            }
        }

        System.out.println("您輸入的彩票: " + myTicket);

        System.out.println("\n開始回測...");
        // 使用 LinkedHashMap 保持獎項順序，或預定義獎項列表
        Map<String, Integer> prizeCounts = new LinkedHashMap<>();
        // 預先定義獎項，確保即使未中獎的獎項也可能顯示 (如果需要)
        String[] prizeOrder = {"頭獎", "貳獎", "參獎", "肆獎", "伍獎", "陸獎", "柒獎", "捌獎","玖獎", "普獎", "未中獎"};
        for (String prizeName : prizeOrder) {
            prizeCounts.put(prizeName, 0);
        }

        for (DrawResult draw : historicalDrawResults) {
            String prize = LotteryMatcher.checkPrize(myTicket, draw);
            prizeCounts.put(prize, prizeCounts.getOrDefault(prize, 0) + 1);
        }

        System.out.println("\n--- 回測結果 ---");
        boolean anyWins = false;
        for (Map.Entry<String, Integer> entry : prizeCounts.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " 次");
                if (!"未中獎".equals(entry.getKey())) {
                    anyWins = true;
                }
            }
        }
        if (!anyWins && prizeCounts.getOrDefault("未中獎", 0) > 0) { // If only "未中獎" has counts > 0
            System.out.println("未中獎: " + prizeCounts.get("未中獎") + " 次");
        }
        if (prizeCounts.values().stream().allMatch(v -> v == 0)) { // Should not happen if "未中獎" is tracked
            System.out.println("沒有任何歷史開獎記錄匹配，或未中任何獎項。");
        }
        System.out.println("--------------------");
    }
}
// 移除 LotteryTicketExtension 類別