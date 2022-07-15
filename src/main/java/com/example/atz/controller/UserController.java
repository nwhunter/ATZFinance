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

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

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

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("course") User user){
        // save course to database
        userService.saveUser(user);
        return "redirect:/";
    }

}
