package ProxyDesignPattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=====> Proxy Design Pattern <=====");

        EmployeeDao userEmployeeDao = new EmployeeDaoProxy("USER");
        // Access granted
        userEmployeeDao.getEmployeeInfo(1);

        // Access denied
        userEmployeeDao.createEmployee(new EmployeeDo());
    }
}