package com.echipa11.all4food.controller;

import com.echipa11.all4food.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    private ProdusService produsService;

    @Autowired
    public DefaultController(ProdusService produsService) {
        this.produsService = produsService;
    }

    @GetMapping("/")
    public String home1(Model model) {
        model.addAttribute("produse", produsService.findAll());
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

}
