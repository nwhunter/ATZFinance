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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

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

    //display list of users
    @GetMapping("/users")
    public String viewUserPage(Model model){
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    //Saves the new user to the SQL database (has not been set up at the moment)
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("course") User user){
        // save course to database
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }

}
