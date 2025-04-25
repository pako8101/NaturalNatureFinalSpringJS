package kamenov.naturalnaturefinalapp.repositories;

import kamenov.naturalnaturefinalapp.entity.AiRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AiRecipeRepository  extends JpaRepository<AiRecipe, Long> {
    @Query("SELECT r FROM AiRecipe r ORDER BY r.generatedAt DESC LIMIT 5")
    List<AiRecipe> findTop5ByOrderByGeneratedAtDesc();

    @Query("SELECT r FROM AiRecipe r ORDER BY r.generatedAt DESC")
    List<AiRecipe> findAllByOrderByGeneratedAtDesc();
}
