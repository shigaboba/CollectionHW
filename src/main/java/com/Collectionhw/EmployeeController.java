package com.Collectionhw;

import com.exceptions.EmployeeAlreadyAddedException;
import com.exceptions.EmployeeNotFoundException;
import com.exceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
         System.out.println("Работа метода find окончена");
         return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        System.out.println("Работа метода add окончена");
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        System.out.println("Работа метода remove окончена");
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/print")
    public List<Employee> print(){
        return employeeService.printEmployees();
    }
}



