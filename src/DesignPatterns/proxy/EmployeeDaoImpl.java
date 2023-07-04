package DesignPatterns.proxy;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String name) {
        System.out.println("Employee with name: " + name + " is created");
    }

    @Override
    public void update(String name, String newName) {
        System.out.println("Employee with name: " + name + " has an updated name: " + newName);
    }

    @Override
    public void delete(String name) {
        System.out.println("Employee with name: " + name + " is deleted");
    }
}
