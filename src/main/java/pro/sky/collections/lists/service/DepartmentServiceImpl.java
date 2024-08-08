package pro.sky.collections.lists.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.lists.employees.Employee;
import pro.sky.collections.lists.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalary(Integer department) {
        return employeeService.getEmployee().stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparing(Employee :: getSalary))
                .orElseThrow(EmployeeNotFoundException :: new);
    }

    @Override
    public Employee getMinSalary(Integer department) {
        return employeeService.getEmployee().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparing(Employee :: getSalary))
                .orElseThrow(EmployeeNotFoundException :: new);
    }

    @Override
    public Collection <Employee> employeesDepartment(Integer department) {
        return employeeService.getEmployee().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartment() {
        return employeeService.getEmployee().stream()
                .collect(groupingBy(Employee :: getDepartment));
    }
}
