package kamenov.naturalnaturefinalapp.repositories;

import kamenov.naturalnaturefinalapp.entity.PassiveHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassiveHouseRepository extends JpaRepository<PassiveHouse, Long> {

    List<PassiveHouse> findByCategory(String category);
}
