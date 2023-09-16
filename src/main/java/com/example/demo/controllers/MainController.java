package com.example.demo.controllers;

import com.example.demo.models.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About me");

        //gather list from db
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        model.addAttribute("list", cars);
        return "about";
    }

    @PostMapping("/about")
    public String blogPostAdd(@RequestParam String creature,  Model model){
        
        System.out.println(creature);
        return "redirect:/about";
    }


}