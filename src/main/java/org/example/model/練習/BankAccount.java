package org.example.model.練習;

//public class BankAccount {
//    private double balance ;  //餘額
//    public double bankAccount(double initialBalance){
//        this.balance = initialBalance ;
//        return initialBalance;
//    };
//    //提款 withdraw  提款金額 amount
//    public  synchronized  void  withdraw(double amount , String personName){
//        System.out.println(personName + " 準備提款 " + amount + " 元，目前餘額: " + balance);
//        if(balance >= amount){
//            try {
//                Thread.sleep(50);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            balance -=amount;
//            System.out.println(personName+ " 提款成功！剩餘餘額: " + balance);
//        }else {
//            System.out.println(personName+ " 提款失敗！餘額不足: " + balance);
//
//        }
//    };
//    public static void main(String[] args) {
//        BankAccount sharedAccount = new BankAccount();
//        Thread thread1 =new Thread();
//        Thread thread2 =new Thread();
//    }
