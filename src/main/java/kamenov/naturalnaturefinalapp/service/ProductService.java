package kamenov.naturalnaturefinalapp.service;



import kamenov.naturalnaturefinalapp.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product addProduct(Product product);

    void saveProduct(Product product);

    void deleteProduct(Long id);
}
