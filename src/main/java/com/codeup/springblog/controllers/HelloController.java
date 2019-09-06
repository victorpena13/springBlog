package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "<h2>Hello from Spring!</h2>";
//    }

//    @PostMapping("/hello")
//    @ResponseBody
//    public String goodbye() {
//        return
//    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String goodbye(@PathVariable String name) {
//        return "well hello" + " " + name + "!";
//    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbyeGoodbye() {
        return "You waved goodbye";
    }


    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }





}
