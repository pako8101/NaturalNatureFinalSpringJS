package kamenov.naturalnaturefinalapp.service.impl;


import kamenov.naturalnaturefinalapp.entity.Product;
import kamenov.naturalnaturefinalapp.repositories.MarketplaceRepository;
import kamenov.naturalnaturefinalapp.service.MarketplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketplaceServiceImpl implements MarketplaceService {

    private final MarketplaceRepository repository;
    @Autowired
    public MarketplaceServiceImpl(MarketplaceRepository repository) {
        this.repository = repository;
    }
@Override
    public List<Product> searchProducts(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
