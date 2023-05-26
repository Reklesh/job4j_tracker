package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John Connor");
        student.setGroup("911");
        student.setDateOfReceipt(new Date());
        System.out.println("Student " + student.getName() + " enrolled in the group № "
                + student.getGroup() + " " + student.getDateOfReceipt());
    }
}
