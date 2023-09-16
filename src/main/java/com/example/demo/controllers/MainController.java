package com.example.demo.controllers;

import com.example.demo.models.Article;
import com.example.demo.models.Creature;
import com.example.demo.repo.ArticleRepository;
import com.example.demo.repo.CreatureRepository;
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




}