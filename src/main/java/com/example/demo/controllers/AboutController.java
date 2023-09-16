package com.example.demo.controllers;

import com.example.demo.models.Creature;
import com.example.demo.repo.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AboutController {

    @Autowired
    private CreatureRepository creatureRepository;
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
        Iterable<Creature> creatures = creatureRepository.findAll();
        model.addAttribute("creatures", creatures);
        return "about";
    }

    @PostMapping("/about")
    public String blogPostAdd(@RequestParam String creature, Model model){

        System.out.println(creature);
        return "redirect:/about";
    }
}
