package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.service.VideoCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VideoCourseController {

    private final VideoCourseService service;
    @Autowired
    public VideoCourseController(VideoCourseService service) {
        this.service = service;
    }

    @GetMapping("/video-courses")
    public String videoCourses(Model model) {
        model.addAttribute("courses", service.getAllCourses());
        return "video-courses";
    }

    @GetMapping("/video-courses/{id}")
    public String videoCourseDetails(@PathVariable Long id, Model model) {
        model.addAttribute("course", service.getCourseById(id));
        return "video-course-details";
    }
}
