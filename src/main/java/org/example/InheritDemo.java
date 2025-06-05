package org.example;

import net.datafaker.Faker;
import org.example.model.Course;
import org.example.model.RetiredTeacher;
import org.example.model.Student;
import org.example.model.Teacher;



public class InheritDemo {
    public static void main(String[] args) {
        Faker faker =new Faker();
        for(int i = 0; i < 3  ; i++ ){

        }

        Teacher Teacher = new Teacher(
                faker.name().fullName(),
                faker.number().numberBetween(25,30),
                faker.internet().emailAddress(),
                faker.number().digit(),
                faker.educator().campus(),
                new Course[]{
                        new Course(faker.number().positive(),faker.educator().course(),faker.text().text()),
                        new Course(faker.number().positive(),faker.educator().course(),faker.text().text()),
                        new Course(faker.number().positive(),faker.educator().course(),faker.text().text())

                },100.0,100

                );
        Student student = new Student(
                faker.name().fullName(),
                faker.number().numberBetween(18,24),
                faker.internet().emailAddress(),
                faker.number().digit(),
                faker.educator().course(),
                faker.gender().shortBinaryTypes()
        );
        RetiredTeacher retiredTeacher = new RetiredTeacher(
                faker.name().fullName(),
                faker.number().numberBetween(25,30),
                faker.internet().emailAddress(),
                faker.number().digit(),
                faker.educator().campus(),
                new Course[]{
                        new Course(faker.idNumber().hashCode(),faker.educator().course(),faker.text().text()),
                        new Course(faker.idNumber().hashCode(),faker.educator().course(),faker.text().text()),
                },
                faker.bool().bool()
        );
        System.out.println("該位老師是否退休?");
        retiredTeacher.isRetired();

        Teacher.calculatePayment();
        System.out.println(Teacher.getPaymentDetail());
        Teacher.sendNotification("123");
        Teacher.displayInfo();
    }



}

