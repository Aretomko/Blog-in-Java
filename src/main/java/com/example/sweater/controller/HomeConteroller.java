package com.example.sweater.controller;

import com.example.sweater.domain.Front;
import com.example.sweater.repos.FrontRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeConteroller {
    @Autowired
    private FrontRepo frontRepo;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("fronts", frontRepo.findByStatus("home"));
        List<Front> allFronts = frontRepo.findAll();
        List<String> tags = new ArrayList<>();
        for (Front iterator : allFronts) {
            if(tags.contains(iterator.getTechnology())) continue;
            tags.add(iterator.getTechnology());
        }
        model.addAttribute("tags", tags);
        return "home";
    }
}
