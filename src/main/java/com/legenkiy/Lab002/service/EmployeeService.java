package com.legenkiy.Lab002.service;

import com.legenkiy.Lab002.model.Employee;
import com.legenkiy.Lab002.model.enums.Role;
import com.legenkiy.Lab002.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    public Employee getById(int id ){
        return employeeRepository.findById(id).orElseThrow();
    }
    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }

    public void edit(Employee employee, int id){
        Employee employee1 = getById(id);
        employee1.setRole(employee.getRole());
        employee1.setSalary(employee.getSalary());
        save(employee1);
    }



}
