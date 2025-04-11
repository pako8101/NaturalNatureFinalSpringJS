package kamenov.naturalnaturefinalapp.repositories;

import kamenov.naturalnaturefinalapp.entity.DailyVisitorCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
@Repository
public interface DailyVisitorCountRepository extends JpaRepository<DailyVisitorCount, Long> {
    Optional<DailyVisitorCount> findByDate(LocalDate date);
}