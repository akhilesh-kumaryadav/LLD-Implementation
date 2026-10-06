package PrototypePattern.Solution;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=====> Prototype Design Pattern <=====");

        // Create initial prototypes (expensive operations)
        Student student = new Student(5, "Akhi", "CSE", 224);
        student.printDetails();

        // Clone objects (Fast operations)
        Student clone = (Student) student.clone();
        clone.setInHighSchool(true);
        clone.printDetails();
        System.out.println("Same object? " + (student == clone));
    }
}