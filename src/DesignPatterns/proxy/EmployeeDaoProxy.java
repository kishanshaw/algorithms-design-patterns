package DesignPatterns.proxy;

public class EmployeeDaoProxy implements EmployeeDao {

    private final EmployeeDaoImpl employeeDaoImply;

    public EmployeeDaoProxy() {
        employeeDaoImply = new EmployeeDaoImpl();
    }

    @Override
    public void create(String name) {
        if (name.equalsIgnoreCase("Admin")) {
            employeeDaoImply.create(name);
        } else {
            System.out.println("User: " + name + " does not have permission");
        }
    }

    @Override
    public void update(String name, String newName) {
        if (name.equalsIgnoreCase("Admin")) {
            employeeDaoImply.create(name);
        } else {
            System.out.println("User: " + name + " does not have permission");
        }
    }

    @Override
    public void delete(String name) {
        if (name.equalsIgnoreCase("Admin")) {
            employeeDaoImply.create(name);
        } else {
            System.out.println("User: " + name + " does not have permission");
        }
    }
}
