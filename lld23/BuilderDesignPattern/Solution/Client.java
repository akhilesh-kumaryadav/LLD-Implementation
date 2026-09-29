package BuilderDesignPattern.Solution;

public class Client {
    public static void main(String[] args) {
        System.out.println("=====> Builder Design Pattern <=====");

        StudentRegistrationDirector engStudentDirector = new StudentRegistrationDirector(
                new EngineeringStudentBuilder());
        StudentRegistrationDirector mbaStudentDirectory = new StudentRegistrationDirector(new MBAStudentBuilder());

        Student engineerStudent = engStudentDirector.createStudent();
        Student mbaStudent = mbaStudentDirectory.createStudent();

        System.out.println("===> Student details:" + engineerStudent.toString());
        System.out.println("===> Student details:" + mbaStudent.toString());
    }
}