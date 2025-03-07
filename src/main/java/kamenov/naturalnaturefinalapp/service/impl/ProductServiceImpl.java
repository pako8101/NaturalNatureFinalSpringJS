package kamenov.naturalnaturefinalapp.service.impl;


import kamenov.naturalnaturefinalapp.entity.Product;
import kamenov.naturalnaturefinalapp.repositories.ProductRepository;
import kamenov.naturalnaturefinalapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {



        private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
@Override
    public List<Product> getAllProducts() {
            return productRepository.findAll();
        }
@Override
        public Product addProduct(Product product) {
            return productRepository.save(product);
        }
@Override
        public void deleteProduct(Long id) {
            productRepository.deleteById(id);
        }

}
