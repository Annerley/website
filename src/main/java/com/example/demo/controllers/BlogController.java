package com.example.demo.controllers;

import com.example.demo.models.Article;
import com.example.demo.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("posts", articles);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){

        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam  String anons, @RequestParam  String full_text, Model model){
        Article post = new Article(title, anons, full_text);
        articleRepository.save(post);
        return "redirect:/blog";
    }


}
