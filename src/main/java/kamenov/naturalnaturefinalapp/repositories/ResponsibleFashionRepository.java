package kamenov.naturalnaturefinalapp.repositories;

import kamenov.naturalnaturefinalapp.entity.ResponsibleFashion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsibleFashionRepository extends JpaRepository<ResponsibleFashion, Long> {
    List<ResponsibleFashion> findByCategory(String category);
    boolean existsByTitle(String title);

    ResponsibleFashion findByTitle(String title);
}
