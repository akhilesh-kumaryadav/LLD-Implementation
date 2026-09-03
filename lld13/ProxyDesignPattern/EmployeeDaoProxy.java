package ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao {
    private EmployeeDao employeeDao;
    private String clientRole;

    public EmployeeDaoProxy(String clientRole) {
        employeeDao = new EmployeeDaoImpl();
        this.clientRole = clientRole;
    }

    @Override
    public void getEmployeeInfo(int employeeId) {
        if (clientRole.equals("ADMIN") || clientRole.equals("USER")) {
            employeeDao.getEmployeeInfo(employeeId);
        } else {
            System.out.println("Access Denied.");
        }
    }

    @Override
    public void createEmployee(EmployeeDo employeeDo) {
        if (clientRole.equals("ADMIN")) {
            employeeDao.createEmployee(employeeDo);
        } else {
            System.out.println("Access Denied.");
        }
    }
}