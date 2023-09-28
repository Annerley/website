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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class AboutController {


    ArrayList<Creature> tmp = new ArrayList<Creature>();


    ArrayList<Creature> tmp2 = new ArrayList<Creature>();

    @Autowired
    private CreatureRepository creatureRepository;
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Frosthaven");

        //gather list from db
        ArrayList<String> cars = new ArrayList<String>();

        cars.add("Living Bones");
        cars.add("Abael Scout");
        cars.add("Ancient Artillery");

        model.addAttribute("list", cars);

        //foreach




        Iterable<Creature> creatures = tmp;



        System.out.println(creatures.toString());
        //System.out.println(tmp.toString());

        model.addAttribute("creatures", tmp);
        return "about";
    }

    @PostMapping("/about")
    public String blogPostAdd(@RequestParam String creature, Model model){


        //creature = найти id по имени
        //cre.add(creature);
        Creature currentCreature = creatureRepository.findByName(creature).get(0);

        currentCreature.SetCurrentInstancesQuantity(0);
        for(int i=0; i<tmp.size(); i++){

            if(tmp.get(i).getName().equals(currentCreature.getName())){

                currentCreature.SetCurrentInstancesQuantity(tmp.get(i).getCurrentInstancesQuantity() + 1);
            }

        }



        tmp.add(currentCreature);
        //Creature a = creatureRepository.findByName(creature.get(0));
        //System.out.println(creatureRepository.findByName(creature).get(0));
        return "redirect:/about";
    }
}
