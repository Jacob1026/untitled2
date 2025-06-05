package org.example.model;

public class User {
    private String name;
    private String email;
    private String phone;

    public String getEmailProvider() {
        return emailProvider;
    }

    public void setEmailProvider(String emailProvider) {
        if(emailProvider.contains("@")){
            this.emailProvider = emailProvider.split("@")[1];
        }else{
            this.emailProvider = "";
        }
    }

    private String emailProvider;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public  String toString(){
        return String.format("姓名:%s ,email:%s ,電話:%s ,",name,email,phone);
    }
}
