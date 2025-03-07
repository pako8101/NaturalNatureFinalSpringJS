package kamenov.naturalnaturefinalapp.repositories;


import kamenov.naturalnaturefinalapp.entity.CartItem;
import kamenov.naturalnaturefinalapp.entity.Product;
import kamenov.naturalnaturefinalapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findByUser(UserEntity user);
    void deleteByUser(UserEntity user);

    List<CartItem> findByProductAndUser(Product product, UserEntity user);
}
