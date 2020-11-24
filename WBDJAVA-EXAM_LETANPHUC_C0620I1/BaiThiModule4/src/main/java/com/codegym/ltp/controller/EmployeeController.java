package com.codegym.ltp.controller;

import com.codegym.ltp.model.Employee;
import com.codegym.ltp.model.EmployeeGroup;
import com.codegym.ltp.service.EmployeeGroupService;
import com.codegym.ltp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public EmployeeGroupService employeeGroupService;

    @ModelAttribute("employeeGroups")
    public Iterable<EmployeeGroup> employeeGroups() {
        return employeeGroupService.findAll();
    }

    @RequestMapping(value = "/employees")
    public ModelAndView listCustomer(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Employee> employees;
        if(search.isPresent()){
            employees = employeeService.findAllByFullNameContaining(search.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/employee/index");
        modelAndView.addObject("listEmployees", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New employee created successfully");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }
        return null;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("employee") Employee employee){
//        employee.setId(employee.getId());
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "Employee updated successfully");
        return modelAndView;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/delete");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute("employee") Employee employee) {
        employeeService.remove(employee.getId());
        return "redirect:/employees";

    }
}
