package org.example.model;

public class MutiThreadDataGenerator {
    private static final int TOTAL_RECORDS = 4000;
    private static final int THREAD_NUM = 4;
    private static final int RECORDS_PRE_THREAD = TOTAL_RECORDS/THREAD_NUM;

    public static void main(String[] args) {
        long startTime =System.currentTimeMillis();
        Thread[] threads =new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {

        }
    }
}
