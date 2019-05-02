package com.example.sweater.controller;

import com.example.sweater.domain.Front;
import com.example.sweater.repos.FrontRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

@Controller
public class AdminFindController {
    @Autowired
    private FrontRepo frontRepo;

    @GetMapping("/findFrontByStatusAdmin/{status}")
    public String fingdByStausAdmin(@PathVariable String status,
                                    Model model){
        model.addAttribute("fronts", frontRepo.findByStatus(status));
        model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
        return "admin";
    }
    @GetMapping("/findFrontByTechnologyAdmin/{technology}")
    public String findFrontByTechnologyAdmin(@PathVariable String technology,
                                             Model model){
        model.addAttribute("fronts", frontRepo.findByTechnology(technology));
        model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
        return "admin";
    }
}
