package com.budgo;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int id);
}
