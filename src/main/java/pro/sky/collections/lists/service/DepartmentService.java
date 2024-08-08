package pro.sky.collections.lists.service;

import pro.sky.collections.lists.employees.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getMaxSalary(Integer department);
    Employee getMinSalary(Integer department);
    Collection<Employee> employeesDepartment(Integer department);
    Map<Integer, List<Employee>> allEmployeesDepartment();
}
