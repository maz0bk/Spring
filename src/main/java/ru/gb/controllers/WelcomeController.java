package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        return "index";
    }
    @GetMapping("/wel")
    @ResponseBody
    public String index(){
        return "Hello world~";
    }

}
