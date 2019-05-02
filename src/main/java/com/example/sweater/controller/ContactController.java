package com.example.sweater.controller;

import com.example.sweater.repos.FrontRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @Autowired
    private FrontRepo frontRepo;

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("fronts" , frontRepo.findByStatus("contact"));
        return "tutorials";
    }
}
