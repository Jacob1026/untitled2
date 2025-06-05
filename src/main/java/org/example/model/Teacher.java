package org.example.model;

public class Teacher extends Person implements Payable,Notiflable {
    //老師獨有的屬性
    private String teacherId ;
    private String department;
    private Course[] courses;
    private double hourlyRate;
    private double workedHours;

    public Teacher(String name, int age, String email
            , String department,String teacherId, Course[] courses
            ,double hourlyRate ,int workedHours){
        super(name, age, email);
        this.department = department;
        this.teacherId = teacherId;
        this.courses = courses;
        this.hourlyRate =hourlyRate;
        this.workedHours = workedHours;
    }


    public void teach(){
        System.out.println(getName()+" 教受科目 "+ courses[0]);
    }
//父:有訂一個抽象方法abstract，具體如何做看子類別
    @Override
    public void eat() {
        System.out.println("吃老闆畫的餅");
    }

    @Override
    public void displayInfo(){
//        super.displayInfo();
        System.out.println("教師編號:"+teacherId );
        System.out.println("部門名稱:"+department );
        System.out.println("授課內容:" );
        for (Course course : courses){
            System.out.printf("%s: %s %s \n",course.getCourseId(),course.getCourseName(),course.getDescription());
        }
    }



    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    @Override
    public double calculatePayment() {
        return hourlyRate * workedHours;
    }

    @Override
    public void processPayment() {
        System.out.println("處理"+getName()+"的薪資支付中:"+calculatePayment());
    }

    @Override
    public String getPaymentDetail() {
        return "教師:"+getName()+"時薪為"+hourlyRate+"工作時數"+workedHours+
                "總薪資"+calculatePayment();
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("向"+ getName() +"發送通知:" + message);
    }
}