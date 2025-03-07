package kamenov.naturalnaturefinalapp.service;



import kamenov.naturalnaturefinalapp.entity.BlogPost;
import kamenov.naturalnaturefinalapp.web.BlogController;

import java.util.List;

public interface BlogService {
    List<BlogPost> searchPosts(String title);

    List<BlogPost> getAllPosts();

    BlogPost getPostById(Long id);
}
