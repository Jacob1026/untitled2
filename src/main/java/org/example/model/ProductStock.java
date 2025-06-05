package org.example.model;

public class ProductStock {
    public int quantity = 10; //庫存只有10
    public void buyProduct(String customerName){
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
