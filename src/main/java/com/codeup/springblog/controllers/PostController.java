package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postRepository) {
        postDao = postRepository;
    }

    @GetMapping("/posts")
    public String postsIndex(Model vModel) {
            Iterable<Post> posts = postDao.findAll();

            vModel.addAttribute("posts", posts);

            return "posts/index";
        }


    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id, Model viewModel) {
        Post post = postDao.findOne(id);
        viewModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/search/{term}")
    public String show(@PathVariable String term, Model viewModel) {
        List<Post> posts = postDao.searchByTitleLike(term);
        viewModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }



//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String createPostForm() {
//        return "please fill out this form";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPost() {
//        return "Great new Post";
//    }
}
