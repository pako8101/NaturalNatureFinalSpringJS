package kamenov.naturalnaturefinalapp.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public BaseEntity() {
    }

    public Long getId() {
        return Id;
    }

    public BaseEntity setId(Long id) {
        Id = id;
        return this;
    }
}
