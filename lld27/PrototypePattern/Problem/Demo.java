package PrototypePattern.Problem;

public class Demo {
    public static void main(String[] args) {
        Student student = new Student(1, "Akhilesh", "CSE", 123);
        student.printDetails();

        // Create a clone of the student object;
        Student clone = new Student();
        clone.id = student.id;
        clone.name = student.name;
        clone.branch = student.branch;

        // Complilation error, coz rollNo is private
        // clone.rollNo = student.rollNo;
    }
}