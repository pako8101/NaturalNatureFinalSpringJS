package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.entity.VideoCourse;
import kamenov.naturalnaturefinalapp.service.VideoCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class VideoCourseController {

    private final VideoCourseService service;
    @Autowired
    public VideoCourseController(VideoCourseService service) {
        this.service = service;
    }
    @GetMapping("/video-courses")
    public String getVideoCoursesPage(Model model) {
        // Списък с видеокурсове
        List<VideoCourse> videoCourses = Arrays.asList(
                new VideoCourse("Beginners Guide to Zero Waste Living", "https://www.youtube.com/watch?v=6jQ_oiJOx0A"),
                new VideoCourse("Easy Ways to Reduce Waste", "https://www.youtube.com/watch?v=8oN1lMtLY5I"),
                new VideoCourse("Sustainable Living Tips", "https://www.youtube.com/watch?v=5fG9xM6Y5Zk"),
                new VideoCourse("Eco-Friendly: The Future of Eco-Sustainable Houses", "https://www.youtube.com/watch?v=RUosBOg0hAM&t=2s"),
                new VideoCourse("How to Start Composting", "https://www.youtube.com/watch?v=zvUYRO7R7eU")
        );
        model.addAttribute("videoCourses", videoCourses);
        return "video-courses";
    }
//    @GetMapping("/video-courses")
//    public String videoCourses(Model model) {
//        model.addAttribute("courses", service.getAllCourses());
//        return "video-courses";
//    }

    @GetMapping("/video-courses/{id}")
    public String videoCourseDetails(@PathVariable Long id, Model model) {
        model.addAttribute("course", service.getCourseById(id));
        return "video-course-details";
    }
}
