package com.Collectionhw;

import com.exceptions.EmployeeAlreadyAddedException;
import com.exceptions.EmployeeNotFoundException;
import com.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>(List.of(new Employee("Fidan", "Gafarov"),
                new Employee("Guzel", "Urazova"),
                new Employee("Magafur", " Gizatullin"),
                new Employee("Salavat", " Yulaev"),
                new Employee("Flura", " Kildiyarova"),
                new Employee("Aydar", " Galimov"),
                new Employee("Salavat", " Fathetdinov"),
                new Employee("Flura", " Suleimanova"),
                new Employee("Hania", " Farhi"),
                new Employee("Vasilya", " Fattahova")));
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        int id = this.employees.size()+1;
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                id = i;
            }
        }
        if (id == this.employees.size()+1) throw new EmployeeNotFoundException();
        return employee;
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (this.employees.size() < 20) {
            Employee newEmployee = new Employee(firstName, lastName);
            try {
                this.findEmployee(firstName, lastName);
                throw new EmployeeAlreadyAddedException();
            } catch (EmployeeNotFoundException e) {
                this.employees.add(newEmployee);
                return newEmployee;
            }
        } else throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        try {
            findEmployee(firstName, lastName);
            this.employees.remove(newEmployee);
            return newEmployee;
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }
    }

    public List<Employee> printEmployees (){
        return employees;
    }
}
