package com.legenkiy.Lab002.controller;

import com.legenkiy.Lab002.model.Employee;
import com.legenkiy.Lab002.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String getAllEmployee(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employee/employeePage";
    }

    @GetMapping("/{id}")
    public String getOneEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employee/employee";
    }

    @GetMapping("/new")
    public String getNewPageEmployee(@ModelAttribute("employee") Employee employee) {
        return "employee/employeeNew";
    }

    @PostMapping("/{id}")
    public String saveNew(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/employeeNew";

        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employee/employeeEdit";
    }

    @PatchMapping("/{id}")
    public String saveEdit(@ModelAttribute("employees") @Valid Employee employee,
                           BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "employee/employeeEdit";
        }
        employeeService.edit(employee, id);
        return "redirect:/employees";
    }

}
