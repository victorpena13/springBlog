package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postRepository, UserRepository userRepository)
    {
        postDao = postRepository;
        userDao=userRepository;

    }

    @Autowired
    private EmailService emailService;

    @GetMapping("/posts")
    public String postsIndex(Model vModel) {
            Iterable<Post> posts = postDao.findAll();

            vModel.addAttribute("posts", posts);

            return "posts/index";
        }



//show individual post by Id
    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }


//    Search by term
    @GetMapping("/posts/search/{term}")
    public String show(@PathVariable String term, Model viewModel) {
        List<Post> posts = postDao.searchByTitleLike(term);
        viewModel.addAttribute("posts", posts);
        return "/posts/index";
    }


//    Edit.
    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.findOne(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String returnEditPost(@PathVariable long id,
        @RequestParam(name = "title") String title,
        @RequestParam(name = "description") String description,
        Model viewModel) {
    Post updatePost = postDao.findOne(id);
    updatePost.setTitle(title);
    updatePost.setDescription(description);
    postDao.save(updatePost);
    return "redirect:/posts";

    }


//Delete working
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }


    @GetMapping("/posts/create")
    public String createPostForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findOne(userSession.getId());
        post.setOwner(user);
        Post savedPost = postDao.save(post);
        emailService.prepareAndSend(
                savedPost,
                "post created",
                "Your post has been created!" + savedPost.getTitle() + savedPost.getOwner()
        );
        return "redirect:/posts";
    }

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> viewAllPostsInJSONFormat() {
        return postDao.findAll();
    }

    @GetMapping("/posts/ajax")
    public String viewAllPostsWithAjax() {
        return "posts/ajax";
    }


}
