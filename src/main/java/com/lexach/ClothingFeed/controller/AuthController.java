package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.controller.form.UserRegistrationForm;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "auth/login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationForm());
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(
            @Valid @ModelAttribute("userForm") UserRegistrationForm userRegistrationForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }

        User user = new User();
        user.setEmail(userRegistrationForm.getEmail());
        user.setUsername(userRegistrationForm.getUsername());
        user.setPassword(userRegistrationForm.getPassword());

        userService.signupUser(user);

        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "auth/profile";
    }

}