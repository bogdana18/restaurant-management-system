package com.restaurant.restaurantmanagement.controllers;

import com.restaurant.restaurantmanagement.models.Department;
import com.restaurant.restaurantmanagement.models.Subject;
import com.restaurant.restaurantmanagement.services.DepartmentService;
import com.restaurant.restaurantmanagement.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/subjects")
    public String listSubjects(Model model) {
        model.addAttribute("subjects", subjectService.listSubjects());
        return "subjects";
    }

    @PostMapping("/subjects")
    public String createSubject(Subject subject) {
        subjectService.addSubject(subject);
        return "redirect:/subjects";
    }
}

