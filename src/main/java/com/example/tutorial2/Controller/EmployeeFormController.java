package com.example.tutorial2.Controller;

import com.example.tutorial2.Model.Employee;
import com.example.tutorial2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeFormController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/edit")
    public String toUpdateUI(@RequestParam("id") Long id, Model model) {
        model.addAttribute("employee", employeeRepo.findById(id).get());
        return "update";
    }

    @GetMapping("/add")
    public String toAddUI(@ModelAttribute Employee employee) {
        return "add";
    }

}
