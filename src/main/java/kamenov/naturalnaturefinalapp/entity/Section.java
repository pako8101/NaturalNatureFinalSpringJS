package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section extends BaseEntity{



    private String name;
    private String content;
    private String imagePath;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "section_subsections",
//            joinColumns = @JoinColumn(name = "section_id"))
//    private List<Subsection> subsections = new ArrayList<>();

    public Section(String name, String content, String imagePath) {
        this.name = name;
        this.content = content;
        this.imagePath = imagePath;

    }

    public Section() {

    }

    // Вложен клас за подсекции
    @Embeddable
    public static class Subsection {
        private String name;
        private String content;
        private String imagePath;

        public Subsection() {}

        public Subsection(String name, String content, String imagePath) {
            this.name = name;
            this.content = content;
            this.imagePath = imagePath;
        }

        // Гетъри и сетъри
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
        public String getImagePath() { return imagePath; }
        public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    }

    // Гетъри и сетъри

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

}
