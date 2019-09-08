package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Path;

@Controller
public class MathController {

    @GetMapping("/add/{number1}/and/{number2}")
    @ResponseBody
    public String plus(@PathVariable int number1, @PathVariable int number2) {
        int total = number1 + number2;
        return number1 + " plus " + number2 + " equals " + total;
    }

    @GetMapping("/minus/{number1}/and/{number2}")
    @ResponseBody
    public String minus(@PathVariable int number1, @PathVariable int number2) {
        int total = number1 - number2;
        return number1 + " minus " + number2 + " equals " + total;
    }

    @GetMapping("/multiply/{number1}/and/{number2}")
    @ResponseBody
    public String multiply(@PathVariable int number1, @PathVariable int number2) {
        int total = number1 * number2;
        return number1 + " times " + number2 + " equals " + total;
    }

    @GetMapping("/divide/{number1}/and/{number2}")
    @ResponseBody
    public String divide(@PathVariable int number1, @PathVariable int number2) {
        int total = number1/number2;
        return number1 + " divided " + number2 + " equals " + total;

    }
}
