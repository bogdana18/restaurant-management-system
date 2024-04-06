package com.restaurant.restaurantmanagement.controllers;

import ch.qos.logback.core.model.Model;
import com.restaurant.restaurantmanagement.models.Restaurant;
import com.restaurant.restaurantmanagement.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService departmentService;

    //@ModelAttribute
    @GetMapping("/departments")
    public String departments(ModelAndView modelAndView) {
        modelAndView.addObject("departments", departmentService.listDepartments());
        return "departments";
    }
    //@ModelAttribute
    @GetMapping("/departments/{id}")
    public String departmentInfo(@PathVariable Long id, ModelAndView modelAndView) {
        Restaurant department = departmentService.getDepartmentById(id);
        if (department != null) {
            modelAndView.addObject("department", department);
            return "department-info";
        }
        return "redirect:/departments";
    }
    @PostMapping("/departments/create")
    public String createDepartment(Restaurant department) {
        departmentService.addDepartment(department);
        return "redirect:/departments";
    }
    @PostMapping("/departments/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments";
    }

}
