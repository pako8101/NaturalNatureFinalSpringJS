package kamenov.naturalnaturefinalapp.service.impl;


import kamenov.naturalnaturefinalapp.entity.Order;
import kamenov.naturalnaturefinalapp.repositories.OrderRepository;
import kamenov.naturalnaturefinalapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }
@Override
    public Order createOrder(Order order) {
        return repository.save(order);
    }
}
