package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome(Model modelView) {

        String userSession = "ana";
        String role = "mortal";

        List<String> colors = new ArrayList<>();

        colors.add("blue");
        colors.add("red");
        colors.add("green");
        colors.add("yellow");


        if(userSession == "fer") {
            role = "admin";
        }

        modelView.addAttribute("colors", colors);
        modelView.addAttribute("role", role);


        return "home";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model viewModel) {
        viewModel.addAttribute("name", name);
        return "hello";
    }

//    @GetMapping("/")
//    public String welcome(Model viewModel) {
//        String userSession = "ana";
//        String role = "mortal";
//
//        List<String> colors = new ArrayList<>();
//
//        colors.add("blue");
//        colors.add("red");
//        colors.add("green");
//        colors.add("yellow");
//
//        if(userSession.equals("fer")) {
//            role = "admin";
//        }
//
//        viewModel.addAttribute("role", role);
//        viewModel.addAttribute("colors", colors);
//        return "home";
//    }


}
