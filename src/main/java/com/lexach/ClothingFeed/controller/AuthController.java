package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.controller.form.UserRegistrationForm;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.model.UserBookmark;
import com.lexach.ClothingFeed.service.UserService;
import com.lexach.ClothingFeed.valid.UserRegistrationFromValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Set;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    /*
    @Autowired
    private UserRegistrationFromValidator userRegistrationFromValidator;

    public AuthController(UserService userService, UserRegistrationFromValidator userRegistrationFromValidator) {
        this.userService = userService;
        this.userRegistrationFromValidator = userRegistrationFromValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userRegistrationFromValidator);
    }
    */

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
    @Transactional
    public String profile(Model model) {

        User user = userService.getCurrentUser();

        model.addAttribute("user", user);

        return "auth/profile";
    }

}