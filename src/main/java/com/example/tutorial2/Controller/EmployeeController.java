package com.example.tutorial2.Controller;

import com.example.tutorial2.Model.Employee;
import com.example.tutorial2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", employeeRepo.findAll());
        return "index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Employee employee) {
        employeeRepo.save(employee);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String update(@RequestParam("id") Long id, @ModelAttribute Employee employee) {
        employeeRepo.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        employeeRepo.delete(employeeRepo.findById(id).get());
        return "redirect:/";
    }
}
