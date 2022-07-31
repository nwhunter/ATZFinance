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

public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //Displays a form to create a new user of the ATZ system
    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    //Handles the user login for the ATZ system
    @GetMapping("/userLogin")
    public String userLogin(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login_user";
    }

    //display list of courses
    @GetMapping("/userList")
    public String viewUserPage(Model model){
        model.addAttribute("listStudents", userService.getAllUsers());

        return "student_list";
    }

    //Saves the new user to the SQL database (has not been set up at the moment)
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("course") User user){
        // save course to database
        userService.saveUser(user);
        return "redirect:/";
    }

    //Will be built upon in the future, but were just created to handle navigation in the system
    @GetMapping("/newLoanApplication")
    public String showNewLoanApplication(){
        return "new_loan_application";
    }
    @GetMapping("/loanApplicationHistory")
    public String showLoanApplicationHistory(){
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
