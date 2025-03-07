package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.VideoCourse;
import kamenov.naturalnaturefinalapp.repositories.VideoCourseRepository;
import kamenov.naturalnaturefinalapp.service.VideoCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoCourseServiceImpl implements VideoCourseService {

    private final VideoCourseRepository videoCourseRepository;

    @Autowired
    public VideoCourseServiceImpl(VideoCourseRepository videoCourseRepository) {
        this.videoCourseRepository = videoCourseRepository;
    }

    @Override
    public List<VideoCourse> getAllCourses() {
        return videoCourseRepository.findAll();
    }

    @Override
    public VideoCourse getCourseById(Long id) {
        return videoCourseRepository.findById(id).orElse(new VideoCourse());
    }
}
