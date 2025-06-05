package org.example.model;

public class Student extends Person implements Notiflable {
    private String studentId;
    private String major;
    private String sex;

    public Student(String name, int age, String email, String studentId, String major, String sex) {
        super(name, age, email);
        this.studentId = studentId;
        this.major = major;
        this.sex = sex;
    }
    @Override
    public void eat() {
        System.out.println("蛋營養");
    }
    @Override
    public void displayInfo() {
//        super.displayInfo();
        System.out.println("學號:" + studentId);
        System.out.println("主修科目:" + major);
        System.out.println("性別:" + sex);
    }

    public void introduce() {
        String gender;
        if (sex.equals("m")) {
            gender = "男生";
        } else if (sex.equals("f")) {
            gender = "女生";
        } else {
            gender = "難道你第三性?";
        }
        System.out.println("我叫" + getName() + "今年" + getAge() + "歲，我是" + gender);
    }


    @Override
    public void sendNotification(String message) {
        System.out.println("向"+ getName() +"發送通知:" + message);
    }
}
