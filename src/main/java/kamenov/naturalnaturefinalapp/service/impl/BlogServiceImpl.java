package kamenov.naturalnaturefinalapp.service.impl;


import kamenov.naturalnaturefinalapp.entity.BlogPost;
import kamenov.naturalnaturefinalapp.repositories.BlogRepository;
import kamenov.naturalnaturefinalapp.service.BlogService;
import kamenov.naturalnaturefinalapp.web.BlogController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {



        private final BlogRepository repository;
    @Autowired
    public BlogServiceImpl(BlogRepository repository) {
        this.repository = repository;
    }
@Override
    public List<BlogPost> searchPosts(String title) {
            return repository.findByTitleContaining(title);

    }

    @Override
    public List<BlogPost> getAllPosts() {
        return repository.findAll();
    }

    @Override
    public BlogPost getPostById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
