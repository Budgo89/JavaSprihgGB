package com.budgo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImp implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepositoryImp() {
        //init();
    }

    @PostConstruct
    public void init(){
        System.out.println("Init ProductRepositoryImp");
        products.add(new Product(1, "telek", 300));
        products.add(new Product(2, "fon", 200));
        products.add(new Product(3, "book", 50));
        products.add(new Product(4, "apple", 20));
        products.add(new Product(5, "grusha", 20));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
}
