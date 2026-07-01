package javaFullCourse.JavaStreams;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<Employee> Employees = new ArrayList<>();

        Employees.add(new Employee("mukesh",01,45000));
        Employees.add(new Employee("Rohan",03,65000));
        Employees.add(new Employee("kaya",02,55000));

    }
}
class Employee {
    String name;
    int EmployeeID;
    int Salary;
    public Employee(String name, int EmployeeID, int Salary) {
        this.name = name;
        this.EmployeeID = EmployeeID;
        this.Salary = Salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmployeeID() {
        return EmployeeID;
    }
    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }
    public int getSalary() {
        return Salary;
    }
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

}