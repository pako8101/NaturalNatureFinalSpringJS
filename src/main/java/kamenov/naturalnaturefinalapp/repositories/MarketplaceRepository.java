package kamenov.naturalnaturefinalapp.repositories;


import kamenov.naturalnaturefinalapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketplaceRepository extends JpaRepository<Product,Long> {

        List<Product> findByNameContaining(String name);

}
