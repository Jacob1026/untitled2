package org.example.model;
//abstract 父:定義一個方法,有繼承的都要用此方法 子:更明細去用方法
public abstract class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public abstract void eat();

    public  void displayInfo(){
        System.out.println("姓名:"+name);
        System.out.println("年齡:"+age);
        System.out.println("信箱:"+email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
