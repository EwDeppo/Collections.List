package pro.sky.collections.lists.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.lists.employees.Employee;
import pro.sky.collections.lists.service.DepartmentServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam Integer department) {
        return departmentService.getMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer department) {
        return departmentService.getMinSalary(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> employeesDepartment() {
        return departmentService.allEmployeesDepartment();
    }

    @GetMapping(value = "/all", params = {"department"})
    public Collection <Employee> allEmployeesDepartment(@RequestParam Integer department) {
        return departmentService.employeesDepartment(department);
    }
}
