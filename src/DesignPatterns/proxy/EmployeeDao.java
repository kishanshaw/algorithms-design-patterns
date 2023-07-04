package DesignPatterns.proxy;

public interface EmployeeDao {
    void create(String name);

    void update(String name, String newName);

    void delete(String name);
}
