package kamenov.naturalnaturefinalapp.repositories;

import kamenov.naturalnaturefinalapp.entity.GreenTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenTipRepository extends JpaRepository<GreenTip,Long> {

}
