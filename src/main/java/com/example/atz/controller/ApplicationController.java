package com.example.atz.controller;


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
import com.example.atz.service.UserService;

@Controller

public class ApplicationController {
    private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    //Will be built upon in the future, but were just created to handle navigation in the system
    @GetMapping("/newLoanApplication")
    public String showNewLoanApplication(){
        return "new_loan_application";
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