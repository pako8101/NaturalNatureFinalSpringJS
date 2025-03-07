package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
    @Column(name = "customer_name",nullable = false,unique = true)
    private String customerName;
    @Column(name = "customer_address",nullable = false,unique = true)
    private String customerAddress;
    @OneToMany
    private List<Product> products;
    @ManyToOne
    private Recipe recipe;

    public Order() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Order setRecipe(Recipe recipe) {
        this.recipe = recipe;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Order setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Order setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Order setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
