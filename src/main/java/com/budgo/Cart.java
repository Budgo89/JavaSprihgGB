package com.budgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;

    private List<Product> products = new ArrayList<>();

    @Autowired
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id) {
        products.add(productRepository.findById(id));
    }
    public void removeProduct(int id) {
        products.remove( products.stream().filter(product -> product.getId()==id).findFirst().orElse(null));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
    public void printCart() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
