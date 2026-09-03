package ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void getEmployeeInfo(int employeeId) {
        System.out.println("Fetching employee information for Id: " + employeeId);
    }

    @Override
    public void createEmployee(EmployeeDo employeeDo) {
        System.out.println("Creating employee: " + employeeDo);
    }
}