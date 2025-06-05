package org.example.model;

public class Customer extends Thread{
    private String name;
    private ProductStock stock;
    private SyProductStock syncStock;

    public Customer(String name, ProductStock stock) {
        this.name = name;
        this.stock = stock;
    }
    public Customer(String name, SyProductStock syncStock) {
        this.name = name;
        this.syncStock = syncStock;
    }

    @Override
    public void  run(){

        if(stock!=null){
            stock.buyProduct(name);  //非同步
        }else{
            syncStock.buyProduct(name); //同步
        }


    }
}
