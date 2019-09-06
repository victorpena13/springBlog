package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex() {
        return "<h2>Here is a list of the posts</h2>" +
                "<ul>" +
                "<li>1</li>" +
                "<li>2</li>" +
                "<li>3</li>" +
                "<li>4</li>" +
                "</ul>";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postDetail(@PathVariable long id) {
        return "Here is post #" + id;
    }

    @GetMapping("posts/create")
    @ResponseBody
    public String createPostForm() {
        return "Please fill out this form";
    }




}
