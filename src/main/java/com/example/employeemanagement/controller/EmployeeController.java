
package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", service.listAll());
        return "index";
    }

    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "new_employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_employee");
        mav.addObject("employee", service.get(id));
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
