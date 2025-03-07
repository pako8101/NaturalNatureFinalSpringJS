package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.VideoCourse;

import java.util.List;

public interface VideoCourseService {
    List<VideoCourse> getAllCourses();
    VideoCourse getCourseById(Long id);
}
