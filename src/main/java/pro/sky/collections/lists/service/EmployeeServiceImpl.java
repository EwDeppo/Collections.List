package pro.sky.collections.lists.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.lists.employees.Employee;
import pro.sky.collections.lists.exception.EmployeeAlreadyAddedException;
import pro.sky.collections.lists.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Integer MAX_EMPLOYEES = 3;
    private Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>(MAX_EMPLOYEES);
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }


    @Override
    public Collection<Employee> getEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
