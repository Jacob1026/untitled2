package org.example.model;

public class SyProductStock {
    public int quantity = 10; //庫存只有10

    //synchronized 同步方法關鍵字，只有一個執行緒可以執行這個方法
    public synchronized void buyProduct(String customerName){
        if(quantity>0){
            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                throw  new RuntimeException(e);
            }
            quantity --;
            System.out.println(customerName + "購買一件商品成功" + quantity);
        }else {
            System.out.println(customerName + "購買商品失敗，庫存不足!!!");
        }
    }
}
