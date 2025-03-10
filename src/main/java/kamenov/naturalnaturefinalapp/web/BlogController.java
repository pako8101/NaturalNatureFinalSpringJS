package kamenov.naturalnaturefinalapp.web;


import kamenov.naturalnaturefinalapp.entity.BlogPost;
import kamenov.naturalnaturefinalapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")

public class BlogController {

    private  final BlogService service;
    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping()
    public String blog(Model model) {
        model.addAttribute("posts", service.getAllPosts());
        return "blog";
    }

    @GetMapping("/{id}")
    public String blogPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", service.getPostById(id));
        return "blog-post";
    }
    @GetMapping("/posts")
    public List<BlogPost> searchPosts(@RequestParam String title) {
        return service.searchPosts(title);
    }
}
