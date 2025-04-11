package kamenov.naturalnaturefinalapp.entity;

import jakarta.validation.constraints.NotBlank;

public class TestForm {
    @NotBlank(message = "Name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
