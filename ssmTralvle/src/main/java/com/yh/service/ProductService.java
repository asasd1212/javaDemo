package com.yh.service;

import com.yh.pojo.Product;

import java.util.List;

public interface ProductService {
        List<Product>findAll();

        void save(Product Product);

        Product findById(Integer pid);

        void edit(Product Product);

        Product editById(int pid);

    void deleteById(Integer id);
}
