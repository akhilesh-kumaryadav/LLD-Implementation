package ProxyDesignPattern;

public interface EmployeeDao {
    void getEmployeeInfo(int employeeId);

    void createEmployee(EmployeeDo employeeDo);
}