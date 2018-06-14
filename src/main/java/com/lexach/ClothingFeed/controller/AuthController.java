package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.controller.form.UserRegistrationForm;
import com.lexach.ClothingFeed.controller.valid.UserRegistrationFormValidator;
import com.lexach.ClothingFeed.model.SearchFilter;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.model.UserBookmark;
import com.lexach.ClothingFeed.service.SearchFilterService;
import com.lexach.ClothingFeed.service.UserBookmarkService;
import com.lexach.ClothingFeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBookmarkService userBookmarkService;

    @Autowired
    private SearchFilterService searchFilterService;

    @Autowired
    private UserRegistrationFormValidator userRegistrationFormValidator;

    @InitBinder("UserRegistrationForm")
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(userRegistrationFormValidator);
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "auth/login";
    }

    @GetMapping("/registration")
    public String registration(UserRegistrationForm userRegistrationForm) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("userRegistrationForm") UserRegistrationForm userRegistrationForm, BindingResult bindingResult) {

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


        List<UserBookmark> bookmarks = userBookmarkService.findByUser(user);

        if (!bookmarks.isEmpty()) {
            model.addAttribute("bookmarks", bookmarks);
        }

        List<SearchFilter> filters = searchFilterService.findByUser(user);

        if (!Objects.isNull(filters)) {

            for (SearchFilter filter : filters) {
                filter.setProductList(searchFilterService.applySearchFilter(filter));
            }

            model.addAttribute("filters", filters);
        }


        return "auth/profile";
    }

}