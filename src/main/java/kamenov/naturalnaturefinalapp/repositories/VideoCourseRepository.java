package kamenov.naturalnaturefinalapp.repositories;

import kamenov.naturalnaturefinalapp.entity.VideoCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCourseRepository extends JpaRepository<VideoCourse, Long> {
}
