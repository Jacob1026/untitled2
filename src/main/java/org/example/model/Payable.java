package org.example.model;

public interface Payable {
    double calculatePayment(); //計算應付金額
    void processPayment();  //處理付款
    String getPaymentDetail();//取得付款詳情
}
