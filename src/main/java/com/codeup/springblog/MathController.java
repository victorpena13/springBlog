package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {




    @RequestMapping(path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number1, @PathVariable int number2) {
        int total = number1+number2;
        return "add " +total;
    }

    @RequestMapping(path = "minus/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String minus(@PathVariable int number1, @PathVariable int number2) {
        int total = number1-number2;
        return number1 + " minus " + number2 + " equals " + total;
    }

    @RequestMapping(path = "times/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String times(@PathVariable int number1, @PathVariable int number2) {
        int total = number1*number2;
        return number1 + " times " + number2 + " equals " + total;
    }

    @RequestMapping(path = "divide/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int number1, @PathVariable int number2) {
        int total = number1/number2;
        return number1 + " divided by " + number2 + " equals " + total;
    }

}
