package kamenov.naturalnaturefinalapp.repositories;


import kamenov.naturalnaturefinalapp.entity.UserRoleEnt;
import kamenov.naturalnaturefinalapp.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEnt,Long> {
    Optional<UserRoleEnt> findUserRoleEntityByRole(UserRoleEnum role);
}
