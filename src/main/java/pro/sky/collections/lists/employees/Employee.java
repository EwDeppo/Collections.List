package pro.sky.collections.lists.employees;

import java.beans.Transient;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer department;
    private Integer salary;


    public Employee(String firstName, String lastName, Integer department, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public Employee(Integer salary) {
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getLastName() {
        return lastName;
    }

    @Transient
    public String getFullName() {
        return firstName + lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }
}
