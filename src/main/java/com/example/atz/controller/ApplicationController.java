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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.atz.service.ApplicationService;

import java.util.List;

@Controller

public class ApplicationController {
    private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/newLoanApplication")
    public String showNewUserForm(Model model){
        //create model attribute to bind form data
        Application application = new Application();
        model.addAttribute("application", application);
        return "new_loan_application";
    }

    //Saves the new application to the SQL database
    @PostMapping("/saveApplication")
    public String saveApplication(@ModelAttribute("application") Application application){
        // save course to database
        applicationService.saveApplication(application);
        return "users";
    }



    //display list of applications
    @GetMapping("/loanApplicationHistory")
    public String viewApplicationHistory(Model model){
        List<Application> allApps = applicationService.getAllApplications();
        model.addAttribute("allApps", allApps);

        return "view_loan_history";
    }

    @GetMapping("/showLoanFormForUpdate/{sid}")
    public String showStudFormForUpdate(@PathVariable( value = "appId") long appId, Model model){

        // get student from the service
        Application application = applicationService.getAppById(appId);


        // set student as a model attribute to pre-populate the form
        model.addAttribute("application", application);

        return "update_application";
    }

    @GetMapping("/home")
    public String showHome(){
        return "users";
    }
    @GetMapping("/logout")
    public String showIndex(){
        return "redirect:/";
    }



}