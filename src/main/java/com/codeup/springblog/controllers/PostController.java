package com.codeup.springblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex() {
        return "";
    }
}
