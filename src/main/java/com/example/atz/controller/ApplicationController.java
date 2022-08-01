package com.example.atz.controller;


import com.example.atz.model.Application;
import com.example.atz.model.User;
import com.example.atz.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.atz.service.ApplicationService;

@Controller

public class ApplicationController {
    private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserRepository userRepository;


    //Let's see
    //Will be built upon in the future, but were just created to handle navigation in the system

    @GetMapping("/newLoanApplication")
    public String showNewUserForm(Model model){
        //create model attribute to bind form data
        Application application = new Application();
        model.addAttribute("application", application);
        return "new_loan_application";
    }

    //Saves the new application to the SQL database (has not been set up at the moment)
    @PostMapping("/saveApplication")
    public String saveApplication(@ModelAttribute("application") Application application){
        // save course to database
        applicationService.saveApplication(application);
        return "redirect:/";
    }

    @GetMapping("/loanApplicationHistory")
    public String saveLoanApplication(){

        return "view_loan_history";
    }
    @GetMapping("/home")
    public String showHome(){
        return "homepage";
    }
    @GetMapping("/logout")
    public String showIndex(){
        return "index";
    }

}