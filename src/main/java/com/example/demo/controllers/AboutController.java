package com.example.demo.controllers;

import com.example.demo.models.Creature;
import com.example.demo.models.CreatureView;
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

    String a = "Living Bones";
    String b = "Abael Scout";

    ArrayList<Creature> tmp = new ArrayList<Creature>();

    ArrayList<String> cre = new ArrayList<String>();

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
        cars.add("Living Bones");
        cars.add("Abael Scout");
        cars.add("Ancient Artillery");

        model.addAttribute("list", cars);

        //foreach




        Iterable<Creature> creatures = tmp;


        System.out.println(creatures.toString());
        //System.out.println(tmp.toString());

        model.addAttribute("creatures", creatures);
        return "about";
    }

    @PostMapping("/about")
    public String blogPostAdd(@RequestParam String creature, Model model){

        //creature = найти id по имени
        cre.add(creature);
        tmp.add(creatureRepository.findByName(creature).get(0));
        //Creature a = creatureRepository.findByName(creature.get(0));
        System.out.println(creatureRepository.findByName(creature).get(0));
        return "redirect:/about";
    }
}
