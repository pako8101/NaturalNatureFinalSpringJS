package kamenov.naturalnaturefinalapp.repositories;

import kamenov.naturalnaturefinalapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
