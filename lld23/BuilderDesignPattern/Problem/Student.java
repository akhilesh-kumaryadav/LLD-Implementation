package BuilderDesignPattern.Problem;

import java.util.List;

public class Student {
    // Mandotory fields
    int rollNumber;
    int age;
    String name;
    String branch;
    // Optional fields
    String fatherName;
    String motherName;
    List<String> subjects;
    String mobileNo;
    String emailId;

    public Student(int rollNumber, int age, String name, String branch) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
        this.branch = branch;
    }

    public Student(int rollNumber, int age, String name, String branch, String fatherName) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
        this.branch = branch;
        this.fatherName = fatherName;
    }

    public Student(int rollNumber, int age, String name, String branch, String fatherName, String motherName) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
        this.branch = branch;
        this.fatherName = fatherName;
        this.motherName = motherName;
    }

    public Student(int rollNumber, int age, String name, String branch, String fatherName, String motherName,
            String emailId) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
        this.branch = branch;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.emailId = emailId;
    }

    // Compilation error - Constructor signature is same as another
    // constructor(above)
    // public Student(int rollNumber, int age, String name, String branch, String
    // fatherName, String motherName,
    // String mobileNo) {
    // this.rollNumber = rollNumber;
    // this.age = age;
    // this.name = name;
    // this.branch = branch;
    // this.fatherName = fatherName;
    // this.motherName = motherName;
    // this.mobileNo = mobileNo;
    // }

    public Student(int rollNumber, int age, String name, String branch, String fatherName, String motherName,
            List<String> subjects, String mobileNo, String emailId) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
        this.branch = branch;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.subjects = subjects;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
    }

    public void printDetails() {
        System.out.println("=== Student Details ===");
        System.out.print(this + ": ");
        System.out.println("Id: " + rollNumber +
                ", Name: " + name +
                ", Age: " + age +
                ", Branch: " + branch +
                ", Roll No: " + rollNumber +
                ", Father Name: " + fatherName +
                ", Mother Name: " + motherName +
                ", Subjects: " + subjects +
                ", Mobile No: " + mobileNo +
                ", Email Id: " + emailId);
    }
}