package pro.sky.collections.lists.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.lists.employees.Employee;
import pro.sky.collections.lists.exception.EmployeeAlreadyAddedException;
import pro.sky.collections.lists.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private static final Integer MAX_EMPLOYEES = 3;
    List<Employee> employees = new ArrayList<>(MAX_EMPLOYEES);
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if (employee != null) {
            throw new EmployeeAlreadyAddedException();
        }
        employee = new Employee(firstName, lastName);
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = removeEmployee(firstName, lastName);
        if (employee != null) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee findEmployee = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee.equals(findEmployee))
                return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> getEmployee() {
        return employees;
    }
}
