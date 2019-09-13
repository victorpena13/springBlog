package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller
public class UserController {
    private UserRepository userDao;
    private PostRepository postDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PostRepository postDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model viewModel) {
        viewModel.addAttribute("user", new User());
        return "users/sign-up";
    }


    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }





    @GetMapping("/profile")
    public String showUserPosts(Model vModel) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Iterable<Post> posts = postDao.findByOwner(userSession);
        vModel.addAttribute("posts", posts);
        return "users/profile";
    }

}
