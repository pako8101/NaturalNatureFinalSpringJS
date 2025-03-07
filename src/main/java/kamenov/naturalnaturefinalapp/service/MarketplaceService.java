package kamenov.naturalnaturefinalapp.service;


import kamenov.naturalnaturefinalapp.entity.Product;

import java.util.List;

public interface MarketplaceService {
    List<Product> searchProducts(String name);

    List<Product> getAllProducts();

    Product getProductById(Long id);
}
