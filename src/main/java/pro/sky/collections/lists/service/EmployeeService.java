package pro.sky.collections.lists.service;

import pro.sky.collections.lists.employees.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> getEmployee();
}
