package com.example.sweater.controller;

import com.example.sweater.domain.Front;
import com.example.sweater.domain.Module;
import com.example.sweater.repos.FrontRepo;
import com.example.sweater.repos.ModuleRepo;
import com.example.sweater.service.CheckboxValeChecker;
import com.example.sweater.service.FileService;
import com.example.sweater.service.ImageDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {
    @Autowired
    private FrontRepo frontRepo;
    @Autowired
    private ModuleRepo moduleRepo;
    @Autowired
    private FileService fileService;
    @Autowired
    private CheckboxValeChecker checkboxValeChecker;
    @Autowired
    private ImageDeleteService imageDeleteService;



    @GetMapping("/admin")
    public String admin(@RequestParam(required = false) String filter,
                        Model model){
        if (filter != null){
            model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
            model.addAttribute("fronts", frontRepo.findByHeading(filter));
            return "admin";
        }
        model.addAttribute("fronts", frontRepo.findAll());
        model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
        return "admin";
    }

    @PostMapping("/addFront")
    public String addFacade(@RequestParam(required = false) String status,
                            @RequestParam String heading,
                            @RequestParam String shortDescription,
                            @RequestParam(required = false) String technology,
                            @RequestParam(required = false) String orderNumber,
                            @RequestParam(required = false) String link,
                            @RequestParam(value = "file", required = false) MultipartFile file,
                            Model model) throws IOException {
        String resultFilename = fileService.fileService(file);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        if (link.equals("")) link = null;
        Front front = new Front(status, heading, shortDescription ,dateFormat.format(date), resultFilename, technology, Integer.valueOf(orderNumber),link);
        frontRepo.save(front);
        model.addAttribute("fronts", frontRepo.findAll());
        model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
        return "admin";
    }
    @GetMapping("/deleteFront/{id}")
    public String deleteFrontById(@PathVariable String id,
                                  Model model) throws IOException{
        List<Module> currentModules =  moduleRepo.findByFront(frontRepo.findAllById(Long.valueOf(id)));
        Front currentFront = frontRepo.findAllById(Long.valueOf(id));
        imageDeleteService.deleteModuleImages(currentModules);
        imageDeleteService.deleteFrontImages(currentFront);
        moduleRepo.deleteAll(currentModules);
        frontRepo.delete(currentFront);
        model.addAttribute("fronts", frontRepo.findAll());
        model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
        return "admin";
    }
    @GetMapping("/showModules/{id}")
    public String findComponentsById(@PathVariable String id,
                                     Model model){
        model.addAttribute("modules", moduleRepo.findByFront(frontRepo.findAllById(Long.valueOf(id))));
        model.addAttribute("id", id);
        model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
        return "adminModules";
    }
    @GetMapping("/deleteModule/{id}")
    public String deleteModuleById(@PathVariable String id,
                                   Model model) throws IOException {
        Module currentModule = moduleRepo.findAllById(Long.valueOf(id));
        imageDeleteService.deleteModuleImage(currentModule);
        moduleRepo.delete(moduleRepo.findAllById(Long.valueOf(id)));
        model.addAttribute("modules", moduleRepo.findAll());
        model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
        return "adminModules";
    }
    @PostMapping("/addNewModule/{id}")
    public String addNewModule(@RequestParam(value = "isText", required = false)String[] isText,
                               @RequestParam(value = "isImage", required = false)String[] isImage,
                               @RequestParam(value = "isCode", required = false)String[] isCode,
                               @RequestParam(required = false) String text,
                               @RequestParam String orderNumber,
                               @PathVariable String id,
                               @RequestParam(value = "file" , required = false) MultipartFile file,
                               Model model) throws IOException {
        String resultFilename = null;
        if(checkboxValeChecker.check(isImage)){
            resultFilename = fileService.fileService(file);
        }
        if (checkboxValeChecker.check(isText) || checkboxValeChecker.check(isCode)) {
            resultFilename = null;
        }
        moduleRepo.save(new Module(checkboxValeChecker.check(isImage),
                checkboxValeChecker.check(isText),
                checkboxValeChecker.check(isCode),
                text,
                resultFilename,
                Integer.valueOf(orderNumber),
                frontRepo.findAllById(Long.valueOf(id))));

        model.addAttribute("modules" , moduleRepo.findByFront(frontRepo.findAllById(Long.valueOf(id))));
        model.addAttribute("technologies",  frontRepo.findAll().stream().map(Front::getTechnology).filter(i -> !i.equals("contact") && !i.equals("home")).distinct().collect(Collectors.toList()));
        return "adminModules";
    }
}
