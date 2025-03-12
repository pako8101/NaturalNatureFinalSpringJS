package kamenov.naturalnaturefinalapp.web;

import io.jsonwebtoken.io.IOException;
import kamenov.naturalnaturefinalapp.entity.Comment;
import kamenov.naturalnaturefinalapp.entity.Post;
import kamenov.naturalnaturefinalapp.repositories.CommentRepository;
import kamenov.naturalnaturefinalapp.repositories.PostRepository;
import kamenov.naturalnaturefinalapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Controller
public class ForumController {

private final EmailService emailService;
        private final PostRepository postRepository;
        private final CommentRepository commentRepository;
        @Value("${upload.directory}")
        private String uploadDir;
@Autowired
        public ForumController(EmailService emailService, PostRepository postRepository, CommentRepository commentRepository) {
    this.emailService = emailService;
    this.postRepository = postRepository;
            this.commentRepository = commentRepository;
        }

        @GetMapping("/forum")
        public String getForumPage(Model model) {
            List<Post> posts = postRepository.findAll();
            for (Post post : posts) {
                if (post.getComments() == null) {
                    post.setComments(new ArrayList<>());
                }
            }
            model.addAttribute("posts", posts);
            model.addAttribute("newPost", new Post("", "", ""));
            model.addAttribute("newComment", new Comment("", "", "", null));
            return "forum";
        }

        @PostMapping("/forum/add-post")
        public String addPost(
                @RequestParam String author,
                @RequestParam String content,
                @RequestParam("image") MultipartFile image,
                Model model) throws IOException, java.io.IOException {
            String imagePath = null;
            if (!image.isEmpty()) {
                imagePath = saveImage(image);
            }
            Post post = new Post(author, content, imagePath);
            postRepository.save(post);
            String subject = "New Post on Eco Life Forum";
            String text = "A new post has been created by " + author + ":\n\n" + content +
                    "\n\nCheck it out at: http://localhost:8029/forum";
            emailService.sendNotificationEmail(subject, text);
            return "redirect:/forum";
        }

    @PostMapping("/forum/add-comment")
    public String addComment(
            @RequestParam Long postId,
            @RequestParam String author,
            @RequestParam String content,
            @RequestParam("image") MultipartFile image,
            Model model) throws IOException, java.io.IOException {
        String imagePath = null;
        if (!image.isEmpty()) {
            imagePath = saveImage(image);
        }
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment(author, content, imagePath, post);
        String subject = "New Post on Eco Life Forum";
        String text = "A new post has been created by " + author + ":\n\n" + content +
                "\n\nCheck it out at: http://localhost:8029/forum";
        emailService.sendNotificationEmail(subject, text);
        commentRepository.save(comment);
        return "redirect:/forum";
    }

        private String saveImage(MultipartFile image) throws IOException, java.io.IOException {
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            Path path = Paths.get(uploadDir + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, image.getBytes());
            return "/uploads/" + fileName;
        }
}