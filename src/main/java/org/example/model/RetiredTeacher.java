package org.example.model;

public class RetiredTeacher extends Teacher{
    //unique fields
    private boolean isRetired;

    public RetiredTeacher(String name, int age, String email, String teacherId, String department, Course[] courses, boolean isRetired) {
        super(name, age, email, teacherId, department, courses,50,100);
        this.isRetired = isRetired;
    }

    public boolean isRetired() {
        if(isRetired){
            System.out.println("已退休");
        }else {
            System.out.println("在職中");
        }
        return isRetired;
    }

    public void setRetired(boolean retired) {
        isRetired = retired;
    }
}
