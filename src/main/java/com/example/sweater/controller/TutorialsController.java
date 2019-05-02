package com.example.sweater.controller;

import com.example.sweater.domain.Front;
import com.example.sweater.repos.FrontRepo;
import com.example.sweater.repos.ModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TutorialsController {
    @Autowired
    private FrontRepo frontRepo;
    @Autowired
    private ModuleRepo moduleRepo;

    @GetMapping("/tutorials")
    public String tutorials(Model model){
        model.addAttribute("fronts", frontRepo.findByStatus("tutorial"));
        return "tutorialsTech";
    }
    @GetMapping("/tutorials/{technology}")
    public String showTutorials(@PathVariable String technology,
                                Model model){
        model.addAttribute("fronts", frontRepo.findByTechnology(technology).stream().filter(i -> i.getStatus().equals("lesson")).sorted().collect(Collectors.toList()));
        return "tutorials";
    }
    @GetMapping("/findByTechnologyFromTeg/{technology}")
    public String findByTechnilogyFromTeg(@PathVariable String technology,
                                          Model model){
        model.addAttribute("fronts", frontRepo.findByTechnology(technology).stream().filter(i -> !i.getStatus().equals("tutorial")).collect(Collectors.toList()));
        return "tutorials";
    }
    @GetMapping("/showTutorial/{id}")
    public String showTutorialById(@PathVariable String id,
                                    Model model){
        Front currentFront = frontRepo.findAllById(Long.valueOf(id));
        model.addAttribute("modules", moduleRepo.findByFront(currentFront).stream().sorted().collect(Collectors.toList()));
        model.addAttribute("heading", currentFront.getHeading());
        model.addAttribute("date", currentFront.getDateOfPosting());
        String nextTutorialNumber = String.valueOf(currentFront.getOrderNumber()+1);
        model.addAttribute("nextOrderNumber", nextTutorialNumber);
        model.addAttribute("technology" , currentFront.getTechnology());
        model.addAttribute("status", currentFront.getStatus());
        return "tutorial";
    }
    @GetMapping("/showNextTutorial/{orderNumber}/{technology}/{status}")
    public String showNexTutorial(@PathVariable String orderNumber,
                                  @PathVariable String technology,
                                  @PathVariable String status,
                                  Model model){
        int counter = 0;
        List<Front> currentFronts = frontRepo.findByOrderNumber(Integer.valueOf(orderNumber));
        for (Front iterator : currentFronts) {
            try {
                if (iterator.getTechnology().equals(technology) && iterator.getStatus().equals(status)) {
                    model.addAttribute("modules", moduleRepo.findByFront(iterator).stream().sorted().collect(Collectors.toList()));
                    model.addAttribute("heading", iterator.getHeading());
                    model.addAttribute("date", iterator.getDateOfPosting());
                    String nextTutorialNumber = String.valueOf(iterator.getOrderNumber() + 1);
                    model.addAttribute("nextOrderNumber", nextTutorialNumber);
                    model.addAttribute("technology", iterator.getTechnology());
                    model.addAttribute("staus", iterator.getStatus());
                    break;
                } else counter++;
            } catch (NullPointerException e) {}
        }
                if (counter == currentFronts.size()){
                    model.addAttribute("fronts", frontRepo.findByTechnology(technology).stream().filter(i -> i.getStatus().equals(status)).sorted().collect(Collectors.toList()));
                    return "tutorials";
                }
        return "tutorial";
    }
}
