package kamenov.naturalnaturefinalapp.repositories;

import kamenov.naturalnaturefinalapp.entity.OrganicGardeningTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganicGardeningTipRepository extends JpaRepository<OrganicGardeningTip,Long> {
}
