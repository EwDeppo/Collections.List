package pro.sky.collections.lists.service;

import pro.sky.collections.lists.employees.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer department, Integer salary);
    Employee removeEmployee(String firstName, String lastName, Integer department, Integer salary);
    Employee findEmployee(String firstName, String lastName, Integer department, Integer salary);
    Collection<Employee> getEmployee();
}
