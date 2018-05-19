package com.lexach.ClothingFeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("name", "name");
        return "index";
    }
}
