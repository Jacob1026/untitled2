package org.example.model;

public class NoSyncBuyDemo {
    public static void main(String[] args) throws InterruptedException {
        ProductStock limitedProduct = new ProductStock();
        int numberOfCustomer = 15; //15為客人搶購
        System.out.println("===限量搶購開始===");
        System.out.println("初始庫存" + limitedProduct.quantity);

        Thread[] customers = new Thread[numberOfCustomer];
        for (int i = 0; i < numberOfCustomer; i++) {
            customers[i] = new Customer("顧客-" + (i + 1), limitedProduct);
            customers[i].start();
        }
        for (int i = 0; i < numberOfCustomer; i++) {
            customers[i].join();
        }
        System.out.println("===限量搶購結束===");
        System.out.println("最終庫存" + limitedProduct.quantity);
    }
}
